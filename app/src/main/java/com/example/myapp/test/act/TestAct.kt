package com.example.myapp.test.act

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapp.R
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.databinding.TestActBinding
import com.example.myapp.test.room.WordModel


class TestAct : AbsStateActivity() {
    private lateinit var binding: TestActBinding
    //private lateinit var  viewModel: WordModel //by viewModels()

    override fun initImportant(
        setMultipleStateView: (view: View) -> Unit,
        setContentView: (view: View) -> Unit,
        setInVisible: (views: MutableList<View>) -> Unit
    ) {

    }

    override fun initializedLayout() {
        //val model = ViewModelProvider(this).get(MyViewModel::class.java)
        val model = ViewModelProviders.of(this).get(WordModel(application = application)::class.java)

        //viewModel = ViewModelProvider(this).get(WordModel::class.java)
        binding = DataBindingUtil.setContentView(this@TestAct, R.layout.test_act)

    }

    override fun initializedView() {

        initView()
    }

    private fun initView() {


        //https://medium.com/mindorks/using-room-database-android-jetpack-675a89a0e942s
        toast("show Toast")


        /*val data =
            Room.databaseBuilder(applicationContext, AppDataBase::class.java, "database_name")
                .build()

        data.userDao()
        data.userDao().getAll()*/


        /*viewModel.allWork.observe(this, Observer { _lists ->


            " ${Gson().toJson(_lists)} ".Log()

        })*/


    }

    override fun initObservable() {
        //TODO("Not yet implemented")
    }

    companion object {
        @JvmStatic
        fun getIntent(context: Context): Intent {
            return Intent(context, TestAct::class.java).apply {

            }
        }
    }

}
