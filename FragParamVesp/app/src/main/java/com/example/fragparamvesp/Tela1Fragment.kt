package com.example.fragparamvesp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragparamvesp.databinding.FragmentBaseBinding
import com.example.fragparamvesp.databinding.FragmentTela1Binding


class Tela1Fragment : Fragment() {
    private var _binding: FragmentTela1Binding? = null
    private val binding get() = _binding!!
    private val args: Tela1FragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTela1Binding.inflate(inflater,container, false)
        return _binding!!.root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nome = args.nome
        binding.textView2.text = nome

        binding.button2.setOnClickListener{
            val resp = binding.editRetorno.text.toString()
            parentFragmentManager.setFragmentResult(
                "chave",
                bundleOf(Pair("chave2", resp))
            )
            parentFragmentManager.setFragmentResult(
                "chave",
                bundleOf(Pair("chave3", resp + "@"))
            )
            findNavController().popBackStack()
        }
    }


}