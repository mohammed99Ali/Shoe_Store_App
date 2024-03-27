package com.test_one.project_one.orderPackage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.test_one.project_one.R
import com.test_one.project_one.SharedViewModel
import com.test_one.project_one.databinding.FragmentPreviewBinding

class Preview : Fragment() {
    lateinit var binding: FragmentPreviewBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_preview, container, false)
        var args = PreviewArgs.fromBundle(requireArguments())
        binding.lifecycleOwner = viewLifecycleOwner
        binding.shared = sharedViewModel


        binding.cancelB.text = args.newButtonName
        binding.cancelB.setOnClickListener { view: View ->
            view.findNavController().navigate(PreviewDirections.actionPreviewToOrder())
        }
        binding.saveB.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(PreviewDirections.actionPreviewToOrderList(isSaved = true))
        }
        binding.shareB.setOnClickListener {
            startActivity(
                sharedViewModel.getShareIntent()
            )
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.login_fragment -> {
                findNavController().navigate(R.id.action_preview_to_login_fragment)
                true
            }

            else -> NavigationUI.onNavDestinationSelected(
                item,
                requireView().findNavController()
            )
        }
    }
}
