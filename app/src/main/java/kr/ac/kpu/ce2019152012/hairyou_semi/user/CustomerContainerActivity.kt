package kr.ac.kpu.ce2019152012.hairyou_semi.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.ac.kpu.ce2019152012.hairyou_semi.R
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.NavCustomerMainBinding

class CustomerContainerActivity : AppCompatActivity() {

    private lateinit var binding: NavCustomerMainBinding

    private val bottomNavgation : BottomNavigationView by lazy { findViewById(R.id.bottom_nav) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NavCustomerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onSetUpNavigation()
    }

    private fun onSetUpNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment

        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener{ _, destination, _ ->

        }
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
    }
}