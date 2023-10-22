package com.example.abrirgaleria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.*
import com.example.abrirgaleria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var pickMedia = registerForActivityResult(PickVisualMedia()) { url ->
        if (url == null) {
            Log.e("Algo", "No se selecciono nada ")
        } else {
            binding.img.setImageURI(url)
        }
    }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGaleria.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
        }
    }
}