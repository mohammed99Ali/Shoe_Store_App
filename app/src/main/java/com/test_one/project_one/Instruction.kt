package com.test_one.project_one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.test_one.project_one.databinding.FragmentInstructionBinding

class Instruction : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentInstructionBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_instruction,container,false)
        binding.nextInstructionIB.setOnClickListener{view : View -> view.findNavController().navigate(R.id.action_instruction_to_orderList) }
        return binding.root
    }
}