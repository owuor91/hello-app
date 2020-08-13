package ke.co.hello

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var lastName: String,
    @SerializedName("email") var email: String,
    @SerializedName("phone_number") var phoneNumber: String,
    @SerializedName("student_id") var studentId: String,
    @SerializedName("date_of_birth") var dateOfBirth: String,
    @SerializedName("image_url") var imageUrl: String
)