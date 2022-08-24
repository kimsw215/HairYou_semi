package kr.ac.kpu.ce2019152012.hair_you.user.fragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kr.ac.kpu.ce2019152012.hairyou_semi.R
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.FragmentCustomerReser3Binding

class Customer_ResThreeFragment : Fragment() {
    private var _binding: FragmentCustomerReser3Binding?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomerReser3Binding.inflate(inflater,container,false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.color.setOnClickListener {
            binding.color.isSelected = binding.color.isSelected != true
            binding.cut.isSelected = false
            binding.perm.isSelected = false
        }

        binding.perm.setOnClickListener {
            binding.perm.isSelected = binding.perm.isSelected != true
            binding.color.isSelected = false
            binding.perm.isSelected = false
        }

        binding.cut.setOnClickListener {
            binding.cut.isSelected = binding.cut.isSelected != true
            binding.color.isSelected = false
            binding.perm.isSelected = false
        }


        binding.nextpage.setOnClickListener {
            view.findNavController().navigate(R.id.action_customer_ResThreeFragment_to_customer_ResFourFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}