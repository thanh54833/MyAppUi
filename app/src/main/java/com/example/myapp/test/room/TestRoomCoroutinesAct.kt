package com.example.myapp.test.room

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.room.*
import com.example.myapp.R
import com.example.myapp.Uitls.Log
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.databinding.TestRoomCoroutiesBinding
import com.google.gson.Gson
import kotlinx.coroutines.launch


class TestRoomCoroutinesAct : AbsStateActivity() {
    lateinit var binding: TestRoomCoroutiesBinding
    lateinit var viewModel: RoomDBViewModel

    override fun initImportant(
        setMultipleStateView: (view: View) -> Unit,
        setContentView: (view: View) -> Unit,
        setInVisible: (views: MutableList<View>) -> Unit
    ) {

    }

    override fun initializedLayout() {
        "test act room corouties".Log("TEST")
        binding =
            DataBindingUtil.setContentView(this@TestRoomCoroutinesAct, R.layout.test_room_corouties)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext)))
        ).get(RoomDBViewModel::class.java)


    }

    override fun initializedView() {

        initListener()
    }

    private fun initListener() {
        var index = 0
        binding.insertBtn.setOnClickListener {
            index++
            viewModel.insert(User(id = index, email = "email", avatar = "avatar", name = "name"))
        }
        binding.showBtn.setOnClickListener {
            "Get All : ${Gson().toJson(viewModel.getAll())} ".Log()
        }
        binding.deleteBtn.setOnClickListener {
            viewModel.deleteAll()
        }
    }

    override fun initObservable() {
        viewModel.userV2.observe(this, Observer { _result ->
            "Result : ${Gson().toJson(_result)} ".Log()
        })
    }
}


class RoomDBViewModel(private val dbHelper: DatabaseHelper) ://private val apiHelper: ApiHelper,
    ViewModel() {
    var userV2 = MutableLiveData<MutableList<User>>()

    init {
        viewModelScope.launch {
            userV2.value = dbHelper.getUsers().toMutableList()
        }
    }

    fun insert(user: User) {
        viewModelScope.launch {
            dbHelper.insertAll(mutableListOf(user))
            userV2.value = dbHelper.getUsers().toMutableList()
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            dbHelper.deleteAll()
            userV2.value = dbHelper.getUsers().toMutableList()
        }
    }

    fun getAll(): MutableList<User>? {
        return userV2.value
    }
}


enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

object DatabaseBuilder {
    private var INSTANCE: AppDatabase? = null
    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "mindorks-example-coroutines"
        ).build()
}


interface DatabaseHelper {
    suspend fun getUsers(): List<User>
    suspend fun insertAll(users: List<User>)
    suspend fun deleteAll()
}


class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {
    override suspend fun getUsers(): List<User> = appDatabase.userDao().getAll()
    override suspend fun insertAll(users: List<User>) = appDatabase.userDao().insertAll(users)
    override suspend fun deleteAll() = appDatabase.userDao().deleteAll()
}

@Entity
data class User(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "avatar") val avatar: String?
)

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertAll(users: List<User>)

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}