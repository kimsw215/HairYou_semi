package kr.ac.kpu.ce2019152012.hair_you.user.fragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kr.ac.kpu.ce2019152012.hairyou_semi.R
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.FragmentCustomerReser5Binding

class Customer_ResFiveFragment : Fragment() {
    private var _binding: FragmentCustomerReser5Binding?= null
    private val binding get() = _binding!!

    private var name : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomerReser5Binding.inflate(inflater,container,false)
        val view = binding.root

/*        if (getArguments() != null)
        {
            name = getArguments()?.getString("date"); // 프래그먼트1에서 받아온 값 넣기
            binding.date.text = name
        }*/

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextpage.setOnClickListener {
            view.findNavController().navigate(R.id.action_customer_ResFiveFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}