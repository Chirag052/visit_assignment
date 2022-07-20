package com.techhustlers.visitassignment.ui.monthly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.techhustlers.visitassignment.ui.main.MainActivity
import com.techhustlers.visitassignment.R
import com.techhustlers.visitassignment.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupBinding()
        animateLogo()
        setupDelayHandler()
    }
    override fun onBackPressed() {
        finishAffinity()
    }
    // endregion

    // region CUSTOM METHODS


    // To setup UI Binding
    private fun setupBinding() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // To add fade animation
    private fun animateLogo() {
        val animation: Animation =
            AnimationUtils.loadAnimation(applicationContext, R.anim.fade_animation)
        binding.appIcon.startAnimation(animation)
    }

    // To add fade animation
    private fun setupDelayHandler() {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 3000)
    }

}