package com.test_one.project_one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.test_one.project_one.databinding.FragmentAboutBinding

class About : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentAboutBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_about,container,false)
        return binding.root
    }
}