package com.test_one.project_one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.test_one.project_one.databinding.FragmentWelcomeBinding

class Welcome : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentWelcomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false)
        binding.nextWelcomeIB.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_welcome_to_instruction)}
        return binding.root
    }


}