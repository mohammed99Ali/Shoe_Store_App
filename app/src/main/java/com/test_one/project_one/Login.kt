package com.test_one.project_one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.test_one.project_one.databinding.FragmentLoginBinding
import com.test_one.project_one.databinding.FragmentOrderBinding

class Login : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.shared = sharedViewModel

        sharedViewModel.userName.observe(viewLifecycleOwner, Observer<String> {
            // Update the text of the user name edit text
            binding.userNameETV.setText(it)
        })
        sharedViewModel.email.observe(viewLifecycleOwner, Observer<String> {
            // Update the text of the user name edit text
            binding.emailETV.setText(it)
        })
        sharedViewModel.password.observe(viewLifecycleOwner, Observer<String> {
            // Update the text of the user name edit text
            binding.passwordETV.setText(it)
        })
        binding.loginB.setOnClickListener { view: View ->
            if (binding.userNameETV.text.isNotEmpty() && binding.emailETV.text.isNotEmpty() && binding.passwordETV.text.isNotEmpty()){
                sharedViewModel.saveLoginData(binding.userNameETV.text.toString(),binding.emailETV.text.toString(),binding.passwordETV.text.toString())
                view.findNavController().navigate(R.id.action_login_to_welcome)
            }
            else
            Toast.makeText(activity, "Missing values", Toast.LENGTH_SHORT).show()

        }
        binding.signInB.setOnClickListener { view: View ->
            if (binding.userNameETV.text.isNotEmpty() && binding.emailETV.text.isNotEmpty() && binding.passwordETV.text.isNotEmpty()){
                sharedViewModel.saveLoginData(binding.userNameETV.text.toString(),binding.emailETV.text.toString(),binding.passwordETV.text.toString())
                view.findNavController().navigate(R.id.action_login_to_welcome)
            }
            else
                Toast.makeText(activity, "Missing values", Toast.LENGTH_SHORT).show()

        }




        return binding.root
    }
}