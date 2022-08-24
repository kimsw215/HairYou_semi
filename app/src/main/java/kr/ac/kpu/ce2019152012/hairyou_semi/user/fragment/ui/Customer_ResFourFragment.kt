package kr.ac.kpu.ce2019152012.hair_you.user.fragment.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import kr.ac.kpu.ce2019152012.hairyou_semi.R
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.FragmentCustomerReser4Binding
import java.util.*

class Customer_ResFourFragment : Fragment() {
    private var _binding: FragmentCustomerReser4Binding?= null
    private val binding get() = _binding!!

    private var ResFivefragment: Customer_ResFiveFragment? = null

    val calendar: Calendar = Calendar.getInstance()
    val currentTime = calendar.timeInMillis // 현재 시간

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomerReser4Binding.inflate(inflater,container,false)
        val view = binding.root

        binding.btn1.isEnabled = false
        binding.btn3.isEnabled = false
        binding.btn5.isEnabled = false

        calendar.add(Calendar.DATE,-1)
        binding.selectDateDp.minDate = calendar.timeInMillis
        calendar.add(Calendar.DATE,6)
        binding.selectDateDp.maxDate = calendar.timeInMillis
        binding.selectDateDp.setOnDateChangedListener { datePicker, year, month, day ->
            when(day){
                23 -> {
                    binding.btn1.isEnabled = false
                    binding.btn3.isEnabled = false
                    binding.btn5.isEnabled = false
                }
                25 -> {
                    binding.btn1.isEnabled = true
                    binding.btn3.isEnabled = false
                    binding.btn5.isEnabled = true
                }
                27 -> {
                    binding.btn1.isEnabled = true
                    binding.btn3.isEnabled = true
                    binding.btn5.isEnabled = false
                }
                else -> {
                    binding.btn1.isEnabled = false
                    binding.btn3.isEnabled = false
                    binding.btn5.isEnabled = false
                }
            }
            binding.getDate.text = "선택한 날짜: ${binding.selectDateDp.year}년 ${(binding.selectDateDp.month+1)}월 ${binding.selectDateDp.dayOfMonth}일"
        }



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn2.setOnClickListener {
            binding.btn2.isSelected = binding.btn2.isSelected != true
            binding.btn4.isSelected = false
        }

        binding.btn4.setOnClickListener {
            binding.btn4.isSelected = binding.btn4.isSelected != true
            binding.btn2.isSelected = false
        }


        binding.nextpage.setOnClickListener {
/*
            var bundle = Bundle()
            bundle.putString("date",binding.getDate.toString())
            val transaction: FragmentTransaction =
                requireActivity()!!.supportFragmentManager.beginTransaction()
            ResFivefragment?.arguments = bundle
*/

            view.findNavController().navigate(R.id.action_customer_ResFourFragment_to_customer_ResFiveFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}