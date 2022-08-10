package kr.ac.kpu.ce2019152012.hairyou_semi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.ActivityJoinSelectBinding

class JoinSelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinSelectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.joinCustomerBtn.setOnClickListener{
            var intent = Intent(this, JoinCustomerActivity::class.java)
            startActivity(intent)
        }
    }
}