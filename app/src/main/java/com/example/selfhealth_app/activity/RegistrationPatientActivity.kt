package com.example.selfhealth_app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.selfhealth_app.R
import com.example.selfhealth_app.api.ApiRetrofit
import com.example.selfhealth_app.model.SubmitModel
import kotlinx.android.synthetic.main.activity_room.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationPatientActivity : AppCompatActivity() {

    private lateinit var editNo: EditText
    private lateinit var editName: EditText
    private lateinit var editBorn: EditText
    private lateinit var editGender: EditText
    private lateinit var editAddress: EditText
    private lateinit var editComplaint: EditText
    private lateinit var editRoom: EditText
    private lateinit var buttonSend: Button
    private val api by lazy { ApiRetrofit().endpoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_patient)

        setupView()
        setupListener()
    }

    private fun setupView() {
        editNo = findViewById(R.id.no)
        editName = findViewById(R.id.name)
        editBorn = findViewById(R.id.born)
        editGender = findViewById(R.id.gender)
        editAddress = findViewById(R.id.address)
        editComplaint = findViewById(R.id.complaint)
        editRoom = findViewById(R.id.room)
        buttonSend = findViewById(R.id.send)
    }

    private fun setupListener() {
        buttonBack.setOnClickListener(){
            finish()
        }

        buttonSend.setOnClickListener(){
            Log.e("PatientActivity", editNo.text.toString())
            Log.e("PatientActivity", editName.text.toString())
            Log.e("PatientActivity", editBorn.text.toString())
            Log.e("PatientActivity", editGender.text.toString())
            Log.e("PatientActivity", editAddress.text.toString())
            Log.e("PatientActivity", editComplaint.text.toString())
            Log.e("PatientActivity", editRoom.text.toString())
            api.create(
                editNo.text.toString(),
                editName.text.toString(),
                editBorn.text.toString(),
                editGender.text.toString(),
                editAddress.text.toString(),
                editComplaint.text.toString(),
                editRoom.text.toString()
            )
                .enqueue(object : Callback<SubmitModel> {
                    override fun onResponse( call: Call<SubmitModel>, response: Response<SubmitModel>
                    ) {
                        if (response.isSuccessful) {
                            Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })
        }
    }
}