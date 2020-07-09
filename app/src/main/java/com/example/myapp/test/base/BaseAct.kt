package com.example.myapp.test.base

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.Uitls.Log
import com.example.myapp.abs.AbsStateActivity

class BaseAct : AbsStateActivity() {
    lateinit var viewModel: MyViewModel

    override fun initImportant(
        setMultipleStateView: (view: View) -> Unit,
        setContentView: (view: View) -> Unit,
        setInVisible: (views: MutableList<View>) -> Unit
    ) {

    }

    override fun initializedLayout() {
        viewModel = ViewModelProvider(this, viewModelFactory { MyViewModel("thanh") })
            .get(MyViewModel::class.java)


        "viewModel name : ${viewModel.name} ".Log()
    }

    override fun initializedView() {

    }

    override fun initObservable() {

    }
}

inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(aClass: Class<T>): T = f() as T
    }

class MyViewModelFactory(var name: String) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyViewModel(name) as T
    }
}

class MyViewModel(var name: String) : ViewModel() {

}
//

