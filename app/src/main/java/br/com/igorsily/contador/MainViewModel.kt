package br.com.igorsily.contador

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(context: Context) : ViewModel() {

    val countPeople = MutableLiveData<Int>()


    init {
        countPeople.value = 0;
    }

    fun plusPeople() {
        countPeople.value = countPeople.value?.plus(1)
    }

    fun minusPeople() {
        countPeople.value = countPeople.value?.minus(1)
    }


    class Factory(
        private val activity: Activity
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            MainViewModel(activity) as T
    }

}