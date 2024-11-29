package br.slmm.com.loginvesp

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.slmm.com.loginvesp.databinding.DialogAddSubjectBinding
import br.slmm.com.loginvesp.databinding.FragmentSubjectsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SubjectsFragment : Fragment() {

    private var _binding: FragmentSubjectsBinding? = null
    private val binding get() = _binding!!
    private lateinit var subjectsAdapter: SubjectAdapter
    private val subjectsList = mutableListOf<Subject>()
    private val databaseReference = FirebaseDatabase.getInstance().getReference("subjects")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubjectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewSubjects.layoutManager = LinearLayoutManager(context)

        subjectsAdapter = SubjectAdapter(subjectsList, { subject ->
            showEditSubjectDialog(subject)
        }, { subject ->
            deleteSubject(subject)
        })

        binding.recyclerViewSubjects.adapter = subjectsAdapter

        // Adicione o espaçamento
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.item_spacing)
        binding.recyclerViewSubjects.addItemDecoration(SpacingItemDecoration(spacingInPixels))

        fetchSubjects()

        binding.addSubjectButton.setOnClickListener {
            showAddSubjectDialog()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fetchSubjects() {
        binding.progressBar.visibility = View.VISIBLE
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                subjectsList.clear()
                for (dataSnapshot in snapshot.children) {
                    val subject = dataSnapshot.getValue(Subject::class.java)
                    subject?.let { subjectsList.add(it) }
                }
                subjectsAdapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
                binding.progressBar.visibility = View.GONE
            }
        })
    }

    private fun showEditSubjectDialog(subject: Subject) {
        val dialogView = DialogAddSubjectBinding.inflate(layoutInflater)
        dialogView.nameEditText.setText(subject.name)
        dialogView.descriptionEditText.setText(subject.description)
        dialogView.professorEditText.setText(subject.professor)

        AlertDialog.Builder(requireContext())
            .setTitle("Editar Matéria")
            .setView(dialogView.root)
            .setPositiveButton("Salvar") { dialog, which ->
                val newName = dialogView.nameEditText.text.toString()
                val newDescription = dialogView.descriptionEditText.text.toString()
                val newProfessor = dialogView.professorEditText.text.toString()
                updateSubject(subject.id, newName, newDescription, newProfessor)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun showAddSubjectDialog() {
        val dialogView = DialogAddSubjectBinding.inflate(layoutInflater)

        AlertDialog.Builder(requireContext())
            .setTitle("Adicionar Matéria")
            .setView(dialogView.root)
            .setPositiveButton("Adicionar") { dialog, which ->
                val name = dialogView.nameEditText.text.toString()
                val description = dialogView.descriptionEditText.text.toString()
                val professor = dialogView.professorEditText.text.toString()
                addSubject(name, description, professor)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun addSubject(name: String, description: String, professor: String) {
        val id = databaseReference.push().key ?: return
        val subject = Subject(id, name, description, professor)
        databaseReference.child(id).setValue(subject)
    }

    private fun updateSubject(id: String, name: String, description: String, professor: String) {
        val subject = Subject(id, name, description, professor)
        databaseReference.child(id).setValue(subject)
    }

    private fun deleteSubject(subject: Subject) {
        databaseReference.child(subject.id).removeValue()
    }
}
