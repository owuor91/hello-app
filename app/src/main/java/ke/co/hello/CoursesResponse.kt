package ke.co.hello

import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses") var courses: List<Course>
)