package com.test_one.project_one.orderListPackage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.test_one.project_one.R
import com.test_one.project_one.SharedViewModel
import com.test_one.project_one.databinding.FragmentOrderListBinding

class OrderList : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentOrderListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_list, container, false)
        val args = OrderListArgs.fromBundle(requireArguments())
        binding.shared = sharedViewModel
        binding.setLifecycleOwner(this)

        if (args.isSaved)
            binding.apply {
                orderOneTv.visibility = View.VISIBLE
                shareOrderListB.visibility = View.VISIBLE
                invalidateAll()
            }

        binding.addFAB.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_orderList_to_order)
        }
        binding.shareOrderListB.setOnClickListener {
            startActivity(
                sharedViewModel.getShareIntent()
            )
        }
        binding.orderOneTv.setOnClickListener {view : View ->
        view.findNavController().navigate(R.id.action_orderList_to_preview)

        }
        return binding.root
    }



}