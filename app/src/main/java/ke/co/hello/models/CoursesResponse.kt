package ke.co.hello.models

import com.google.gson.annotations.SerializedName
import ke.co.hello.models.Course

data class CoursesResponse(
    @SerializedName("courses") var courses: List<Course>
)