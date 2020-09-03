package ke.co.hello.database

import androidx.room.*
import ke.co.hello.Course

@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun getAllCourses(): List<Course>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(course: Course)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(course: Course)

    @Delete
    fun delete(course: Course)


}