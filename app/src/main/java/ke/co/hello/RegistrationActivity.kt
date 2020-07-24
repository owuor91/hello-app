package ke.co.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

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
            Toast.makeText(baseContext, lastName, Toast.LENGTH_SHORT).show()
        }
    }
}