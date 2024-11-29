package br.slmm.com.loginvesp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.slmm.com.loginvesp.databinding.ItemSubjectBinding

class SubjectAdapter(
    private val subjects: List<Subject>,
    private val onEditClick: (Subject) -> Unit,
    private val onDeleteClick: (Subject) -> Unit
) : RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    inner class SubjectViewHolder(private val binding: ItemSubjectBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(subject: Subject) {
            binding.nameTextView.text = subject.name
            binding.descriptionTextView.text = subject.description
            binding.professorTextView.text = subject.professor

            binding.editButton.setOnClickListener { onEditClick(subject) }
            binding.deleteButton.setOnClickListener { onDeleteClick(subject) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val binding = ItemSubjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(subjects[position])
    }

    override fun getItemCount(): Int = subjects.size
}
