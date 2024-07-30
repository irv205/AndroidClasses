package com.irv205.testproject.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _itemListObject = MutableLiveData<List<String>>()
    val itemListObject : LiveData<List<String>> get() = _itemListObject

    init {
        getList()
    }
    private fun getList() {
        val list = listOf(
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5"
        )
        _itemListObject.value = list
    }

}