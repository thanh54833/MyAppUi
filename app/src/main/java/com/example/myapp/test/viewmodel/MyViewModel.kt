package com.example.myapp.test.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var users: MutableLiveData<List<User>>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
                loadUsers()
            }
            return field
        }
        private set

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
    }
}

class User()