package com.digitalcreative.coronaapps

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.digitalcreative.coronaapps.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val anim = AnimationUtils.loadAnimation(this, R.anim.anim_splash).apply {
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    setAnimationListener(null)

                    img_splash.apply {
                        visibility = View.INVISIBLE
                        clearAnimation()
                    }

                    tv_splash.apply {
                        visibility = View.INVISIBLE
                        clearAnimation()
                    }

                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    finish()
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
        }

        img_splash.startAnimation(anim)
        tv_splash.startAnimation(anim)
    }
}