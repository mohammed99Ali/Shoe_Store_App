package com.test_one.project_one

import android.content.Intent
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel(){

    private var _gender = MutableLiveData<String>()
    val gender: LiveData<String>
        get() = _gender

    private var _brand = MutableLiveData<String>()
    val brand: LiveData<String>
        get() = _brand

    private var _type = MutableLiveData<String>()
    val type: LiveData<String>
        get() = _type

    private var _made = MutableLiveData<String>()
    val made: LiveData<String>
        get() = _made

    private var _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private var _size = MutableLiveData<String>()
    val size: LiveData<String>
        get() = _size

    private var _userName = MutableLiveData<String>()
    val userName: LiveData<String>
       get() = _userName
    private var _color = MutableLiveData<String>()
    val color: LiveData<String>
        get() = _color

    private var _email = MutableLiveData<String>()
    val email: LiveData<String>
          get() = _email

    private var _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password


    private var _genderGB = MutableLiveData<Int>()
    val genderGB: LiveData<Int>
        get() = _genderGB

    private var _brandGB = MutableLiveData<Int>()
    val brandGB: LiveData<Int>
        get() = _brandGB
    private var _typeGB = MutableLiveData<Int>()
    val typeGB: LiveData<Int>
        get() = _typeGB
    private var _madeGB = MutableLiveData<Int>()
    val madeGB: LiveData<Int>
        get() = _madeGB






    fun saveLoginData(username : String,email : String,password :String){
        _userName.value = username
        _email.value = email
        _password.value = password
    }

    fun saveData(genderValue: String,brandValue: String,typeValue: String,madeValue: String,nameValue: String,sizeValue: String,colorValue: String, genderId : Int , brandId : Int , typeId : Int , madeId : Int){
        _gender.value = genderValue
        _brand.value = brandValue
        _type.value = typeValue
        _made.value = madeValue
        _name.value = nameValue
        _size.value = sizeValue
        _color.value = colorValue
        _genderGB.value = genderId
        _brandGB.value = brandId
        _typeGB.value = typeId
        _madeGB.value = madeId
    }

    fun getShareIntent(): Intent {
        val orderMessage: String =
            "This is an order from ${userName.value} using negozio shoe application \n This is the order name : ${_name.value} \n" +
                    "This is the gender of the customer : ${_gender.value}" + "\nThis is the brand that he customer want : ${_brand.value}" + "\nThis is the type shoes : ${_type.value}" + "\nThis is the material he/she asked for : ${made.value}" + "\nThis is the size of the shoe : ${size.value}" + "\nThis is the color of the shoe : ${color.value}" + "\nFinally\nYou are not buying an object,\n you are buying a style "

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, orderMessage)
        return shareIntent
    }



}