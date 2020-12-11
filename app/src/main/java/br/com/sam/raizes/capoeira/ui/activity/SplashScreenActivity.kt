package br.com.sam.raizes.capoeira.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.sam.raizes.capoeira.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        splashScreenConfig()
    }

    private fun splashScreenConfig() {
        ic_welcome.alpha = 0f
        ic_welcome.animate().setDuration(3000).alpha(1f).withEndAction {
            val intent = Intent(this, RaizeirosListActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}
