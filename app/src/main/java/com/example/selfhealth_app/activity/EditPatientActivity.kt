package com.example.selfhealth_app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.selfhealth_app.R
import com.example.selfhealth_app.api.ApiRetrofit
import com.example.selfhealth_app.model.PatientModel
import com.example.selfhealth_app.model.SubmitModel
import kotlinx.android.synthetic.main.activity_registration_patient.*
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.activity_room.buttonBack
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditPatientActivity : AppCompatActivity() {

    private lateinit var editNo: EditText
    private lateinit var editName: EditText
    private lateinit var editBorn: EditText
    private lateinit var editGender: EditText
    private lateinit var editAddress: EditText
    private lateinit var editComplaint: EditText
    private lateinit var editRoom: EditText
    private lateinit var buttonUpdate: Button
    private val api by lazy { ApiRetrofit().endpoint }
    private val pasien by lazy { intent.getSerializableExtra("pasien") as PatientModel.Data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_patient)

        setupView()
        setupListener()
    }

    private fun setupView() {
        editNo = findViewById(R.id.editNo)
        editName = findViewById(R.id.editName)
        editBorn = findViewById(R.id.editBorn)
        editGender = findViewById(R.id.editGender)
        editAddress = findViewById(R.id.editAddress)
        editComplaint = findViewById(R.id.editComplaint)
        editRoom = findViewById(R.id.editRoom)
        buttonUpdate = findViewById(R.id.update)

        editNo.setText(pasien.nomor_pasien)
        editName.setText(pasien.nama)
        editBorn.setText(pasien.ttl)
        editGender.setText(pasien.jenis_kelamin)
        editAddress.setText(pasien.alamat)
        editComplaint.setText(pasien.keluhan)
        editRoom.setText(pasien.kamar)
    }

    private fun setupListener() {
        buttonBack.setOnClickListener(){
            finish()
        }

        buttonUpdate.setOnClickListener() {
            api.update(
                pasien.id!!,
                editNo.text.toString(),
                editName.text.toString(),
                editBorn.text.toString(),
                editGender.text.toString(),
                editAddress.text.toString(),
                editComplaint.text.toString(),
                editRoom.text.toString()
            )
                .enqueue(object: Callback<SubmitModel> {
                    override fun onResponse(
                        call: Call<SubmitModel>,
                        response: Response<SubmitModel>
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