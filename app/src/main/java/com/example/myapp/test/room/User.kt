package com.example.myapp.test.room

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Entity
class User(
    @PrimaryKey var uId: Int,
    @ColumnInfo(name = "first_name") var firstName: String?,
    @ColumnInfo(name = "last_name") var lastName: String?
)

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uId IN (:userId) ")
    fun loadAllByIDds(userId: IntArray): List<User>

    @Delete
    fun delete(user: User)
}

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

// codolab ...


@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") var word: String)

@Dao
interface WordDao {
    @Query("SELECT *from word_table ORDER BY word ASC")
    fun getAlphabeticallyWord(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null
        fun getDataBase(context: Context): WordRoomDatabase {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                WordRoomDatabase::class.java,
                "word_database"
            ).build()
            INSTANCE = instance
            return instance
        }
    }
}

class WordRepository(private var wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAlphabeticallyWord()
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}


class WordModel(application: Application) : AndroidViewModel(application) {
    private var resiponstory: WordRepository
    var allWork: LiveData<List<Word>>

    init {
        val wordDao = WordRoomDatabase.getDataBase(application).wordDao()
        resiponstory = WordRepository(wordDao)
        allWork = resiponstory.allWords
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        resiponstory.insert(word)
    }
}
//https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#9