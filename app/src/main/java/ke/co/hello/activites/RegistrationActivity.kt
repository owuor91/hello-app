package ke.co.hello.activites

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ke.co.hello.R
import ke.co.hello.api.ApiClient
import ke.co.hello.api.ApiInterface
import ke.co.hello.models.RegistrationResponse
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegister.setOnClickListener {
            var firstName = etFirstName.text.toString()
            var lastName = etLastName.text.toString()
            val email = etEmail.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()
            val password = etPassword.text.toString()
            val passwordConfirmation = etConfirmPassword.text.toString()

            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("first_name", firstName)
                .addFormDataPart("last_name", lastName)
                .addFormDataPart("email", email)
                .addFormDataPart("phone_number", phoneNumber)
                .addFormDataPart("password", password)
                .build()

            registerUser(requestBody)
            Toast.makeText(baseContext, lastName, Toast.LENGTH_SHORT).show()
        }
    }


    fun registerUser(requestBody: RequestBody) {
        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        var registrationCall = apiClient.registerStudent(requestBody)
        registrationCall.enqueue(object : Callback<RegistrationResponse> {
            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<RegistrationResponse>,
                response: Response<RegistrationResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    startActivity(Intent(baseContext, MainActivity::class.java))
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}