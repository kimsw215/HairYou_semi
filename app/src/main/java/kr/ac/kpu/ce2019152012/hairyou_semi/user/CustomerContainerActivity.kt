package kr.ac.kpu.ce2019152012.hairyou_semi.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kr.ac.kpu.ce2019152012.hairyou_semi.R
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.NavCustomerMainBinding

class CustomerContainerActivity : AppCompatActivity() {

    private lateinit var binding: NavCustomerMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NavCustomerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostCustomerFragmnet = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController = navHostCustomerFragmnet.navController
        binding.bottomNav.setupWithNavController(navController)
    }
}