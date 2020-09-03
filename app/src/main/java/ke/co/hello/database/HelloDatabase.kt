package ke.co.hello.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ke.co.hello.Course

@Database(entities = arrayOf(Course::class), version = 1)
abstract class HelloDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao

    companion object {
        private var dbInstance: HelloDatabase? = null
        fun getInstance(context: Context): HelloDatabase {
            if (dbInstance == null) {
                dbInstance =
                    Room.databaseBuilder(context, HelloDatabase::class.java, "hello-db").build()
            }
            return dbInstance as HelloDatabase
        }
    }
}