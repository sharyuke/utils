package com.sharyuke.app.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.sharyuke.app.R
import com.sharyuke.utils.onClick
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 *
 * // db
 *  const val roomRuntime = "androidx.room:room-runtime:2.2.3"
 *  const val roomKtx = "androidx.room:room-ktx:2.2.3"
 *  const val aptRoomCompile = "androidx.room:room-compiler:2.2.3"
 * // coroutine
 * const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1"
 * const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1"
 * const val lifeCycleScope = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0" // lifecycleScope
 */
class FileRoomActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_room)
        title = "Room"
        val db = Room.databaseBuilder(this, Db::class.java, "test").allowMainThreadQueries().build()
        val dogDao = db.getDogDao()
        dogDao.insert(Dog("you", 24))
        dogDao.getDogs().onEach {
            findViewById<TextView>(R.id.file_room_tv).text = it.map { i -> i.toString() + "\n" }.toString()
            Log.d("====> ", "====> $it")
            findViewById<Button>(R.id.file_room_btn).onClick {
//                dogDao.delete(it.random())
                dogDao.update(Dog("you", 33).apply { id = 16 })
            }
        }.launchIn(lifecycleScope)
        var t = 0
    }
}

@Entity(tableName = "dog")
data class Dog(@ColumnInfo(name = "name") var name: String? = null, @ColumnInfo(name = "age") var age: Int? = null) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    override fun toString(): String = "id:$id, name:$name, age:$age"
}

@Dao
interface DogDao {

    @Insert(onConflict = REPLACE)
    fun insert(dog: Dog)

    @Update
    fun update(dog: Dog)

    @Delete
    fun delete(dog: Dog)

    @Query("select * from dog")
    fun getDogs(): Flow<List<Dog>>
}

@Database(entities = [Dog::class], version = 1)
abstract class Db() : RoomDatabase() {
    abstract fun getDogDao(): DogDao
}
