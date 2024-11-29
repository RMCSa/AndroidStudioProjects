package br.com.loginvesp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.loginvesp.databinding.FragmentRegisterBinding
import br.com.loginvesp.databinding.FragmentSplashBinding
import com.google.firebase.Firebase
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegisterFragment : Fragment() {

    private var _binding : FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container,  true )
        return  _binding!!.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding  = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        binding.btnRegistrar.setOnClickListener {
            val email = binding.edtEmailRG.text.toString()
            val pwd   = binding.edtPwdRG.text.toString()

            auth.createUserWithEmailAndPassword(email, pwd)
                .addOnCompleteListener {task ->
                    if (task.isSuccessful) {
                        findNavController().popBackStack()
                    } else {
                        Toast.makeText(activity, task.exception?.message, Toast.LENGTH_LONG).show()
                    }
                }

        }

        binding.btnCancelar.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}