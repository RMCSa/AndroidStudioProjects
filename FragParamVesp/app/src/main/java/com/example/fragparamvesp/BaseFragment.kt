package com.example.fragparamvesp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fragparamvesp.databinding.FragmentBaseBinding


class BaseFragment : Fragment() {
    private var _binding: FragmentBaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBaseBinding.inflate(inflater,container, false)
        return _binding!!.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavegarParaTela1()
    }

    private fun NavegarParaTela1(){
        binding.button.setOnClickListener{
        val action = BaseFragmentDirections
            .actionBaseFragmentToTela1Fragment("RMCSA")
            findNavController().navigate(action)
        }
    }

    private fun EscutarFragmentos(){
        parentFragmentManager.setFragmentResultListener("chave",
            this){key, bundle ->
            val nome = bundle[key].toString()
            binding.textView.text = nome
            val nome2 = bundle.getString("chave2")
            binding.textView.text = nome2
        }
    }

}