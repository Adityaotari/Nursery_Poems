package com.example.poems

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity



import com.example.poems.databinding.SplashActivityBinding

class SplashActivity: AppCompatActivity() {
    private lateinit var binding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use Handler to delay the task
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}