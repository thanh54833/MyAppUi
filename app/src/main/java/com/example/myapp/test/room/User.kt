package com.example.myapp.test.room

/*
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

    class WordDatabaseCallBack(private var scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)

            scope.launch {
                INSTANCE?.let { _dataBase ->
                    val wordDao = _dataBase.wordDao()
                    wordDao.deleteAll()

                    var word = Word("hello")
                    wordDao.insert(word)
                    word = Word("world")
                    wordDao.insert(word)
                    word = Word("todo")
                    wordDao.insert(word)

                }
            }
        }
    }


    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null
        fun getDataBase(context: Context, scope: CoroutineScope): WordRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                context.applicationContext,
                WordRoomDatabase::class.java,
                "word_database"
                ) .fallbackToDestructiveMigration().addCallback(WordDatabaseCallBack(scope)).build()
                INSTANCE = instance
                instance
            }
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
        val wordDao = WordRoomDatabase.getDataBase(application,viewModelScope).wordDao()
        resiponstory = WordRepository(wordDao)
        allWork = resiponstory.allWords
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        resiponstory.insert(word)
    }
}

//https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#9

*/

