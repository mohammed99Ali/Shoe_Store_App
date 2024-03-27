package com.test_one.project_one.orderPackage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.test_one.project_one.R
import com.test_one.project_one.SharedViewModel
import com.test_one.project_one.databinding.FragmentOrderBinding

class Order : Fragment() {
    lateinit var binding: FragmentOrderBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        val genderId = binding.genderGB.checkedRadioButtonId
        val brandId = binding.brandGB.checkedRadioButtonId
        val typeId = binding.typeGB.checkedRadioButtonId
        val madeId = binding.madeGB.checkedRadioButtonId
        sharedViewModel.name.observe(viewLifecycleOwner, Observer<String> {
            // Update the text of the user name edit text
            binding.orderNameEV.setText(it)
        })
        sharedViewModel.size.observe(viewLifecycleOwner, Observer<String> {
            // Update the text of the user name edit text
            binding.shoeSizeEV.setText(it)
        })
        sharedViewModel.color.observe(viewLifecycleOwner, Observer<String> {
            // Update the text of the user name edit text
            binding.colorEV.setText(it)
        })

        sharedViewModel.genderGB.observe(viewLifecycleOwner, { genderId ->

            binding.maleRB.isChecked = genderId == R.id.male_RB
            binding.femaleRB.isChecked = genderId == R.id.female_RB
        })

        sharedViewModel.brandGB.observe(viewLifecycleOwner, { brandId ->

            binding.gucciRB.isChecked = brandId == R.id.gucci_RB
            binding.todsRB.isChecked = brandId == R.id.tods_RB
            binding.pradaRB.isChecked = brandId == R.id.prada_RB
            binding.santoniRB.isChecked = brandId == R.id.santoni_RB
        })

        sharedViewModel.typeGB.observe(viewLifecycleOwner, { typeId ->
            binding.sportsRB.isChecked = typeId == R.id.sports_RB
            binding.casualRB.isChecked = typeId == R.id.casual_RB
            binding.formalRB.isChecked = typeId == R.id.formal_RB
            binding.workRB.isChecked = typeId == R.id.work_RB
        })

        sharedViewModel.madeGB.observe(viewLifecycleOwner, { madeId ->
            binding.leatherRB.isChecked = madeId == R.id.leather_RB
            binding.rubberRB.isChecked = madeId == R.id.rubber_RB
            binding.foamRB.isChecked = madeId == R.id.foam_RB
            binding.plasticRB.isChecked = madeId == R.id.plastic_RB
        })



        binding.nextOrderIB.setOnClickListener { view: View ->
            if (allAnswered()) {
                val genderValue = when (genderId) {
                    R.id.male_RB -> "Male"
                    else -> "Female"
                }
                val brandValue = when (brandId) {
                    R.id.gucci_RB -> "Gucci"
                    R.id.prada_RB -> "Prada"
                    R.id.tods_RB -> "Tod's"
                    else -> "Santoni"
                }
                val typeValue = when (typeId) {
                    R.id.work_RB -> "Work"
                    R.id.formal_RB -> "Formal"
                    R.id.sports_RB -> "Sport"
                    else -> "Casual"
                }
                val madeValue = when (madeId) {
                    R.id.leather_RB -> "Leather"
                    R.id.foam_RB -> "Foam"
                    R.id.plastic_RB -> "Plastic"
                    else -> "Rubber"
                }
                sharedViewModel.saveData(
                    genderValue,
                    brandValue,
                    typeValue,
                    madeValue,
                    binding.orderNameEV.text.toString(),
                    binding.shoeSizeEV.text.toString(),
                    binding.colorEV.text.toString(),
                    binding.genderGB.checkedRadioButtonId,
                    binding.brandGB.checkedRadioButtonId,
                    binding.typeGB.checkedRadioButtonId,
                    binding.madeGB.checkedRadioButtonId
                )

                view.findNavController().navigate(
                    OrderDirections.actionOrderToPreview("cancel")
                )
            } else
                Toast.makeText(activity, "Missing values", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }



    //check if the all the choices are answered, this is here because this fun takes the view state not data
    private fun allAnswered(): Boolean {

        val genderId = binding.genderGB.checkedRadioButtonId
        val brandId = binding.brandGB.checkedRadioButtonId
        val typeId = binding.typeGB.checkedRadioButtonId
        val madeId = binding.madeGB.checkedRadioButtonId

        var valueOfGender = false
        var valueOfBrand = false
        var valueOfType = false
        var valueOfMaterial = false
        var valueOfSize = false
        var valueOfColor = false
        binding.apply {
            if (genderId != -1)
                valueOfGender = true
            if (brandId != -1)
                valueOfBrand = true
            if (typeId != -1)
                valueOfType = true
            if (madeId != -1)
                valueOfMaterial = true
            if (shoeSizeEV.text.isNotEmpty())
                valueOfSize = true
            if (colorEV.text.isNotEmpty() && orderNameEV.text.isNotEmpty())
                valueOfColor = true
        }
        return valueOfGender && valueOfBrand && valueOfType && valueOfMaterial && valueOfSize && valueOfColor
    }
}