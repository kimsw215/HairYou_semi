package kr.ac.kpu.ce2019152012.hair_you.user.fragment.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.kpu.ce2019152012.hairyou_semi.R
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.FragmentCustomerReser1Binding


class Customer_ResOneFragment : Fragment() {
    private var _binding: FragmentCustomerReser1Binding?= null
    private val binding get() = _binding!!


    // linearManager
    private lateinit var Lmanager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomerReser1Binding.inflate(inflater,container,false)
        val view = binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.straight.setOnClickListener {
            binding.straight.isSelected = binding.straight.isSelected != true
            binding.gopseul.isSelected = false
            binding.bangopseul.isSelected = false
        }

        binding.bangopseul.setOnClickListener {
            binding.bangopseul.isSelected = binding.bangopseul.isSelected != true
            binding.bangopseul.isSelected = false
            binding.gopseul.isSelected = false
        }

        binding.gopseul.setOnClickListener {
            binding.gopseul.isSelected = binding.gopseul.isSelected != true
            binding.straight.isSelected = false
            binding.bangopseul.isSelected = false
        }
        binding.nextpage.setOnClickListener {
            view.findNavController().navigate(R.id.action_customer_ResOneFragment_to_customer_ResTwoFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}