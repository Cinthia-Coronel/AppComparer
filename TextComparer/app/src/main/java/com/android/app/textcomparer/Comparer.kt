package com.android.app.textcomparer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Comparer: ViewModel() {
    private val result = MutableLiveData<String>()
    val resultado: LiveData<String> = result

    fun textComparer(text1: String, text2: String) {
        result.value = if (text1 == text2) {
            "Los textos son iguales"
        } else {
            "Los textos son diferentes"
        }
    }
}