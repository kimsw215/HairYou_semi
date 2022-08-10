package kr.ac.kpu.ce2019152012.hair_you.user.fragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.FragmentCustomerReser4Binding

class Customer_ResFourFragment : Fragment() {
    private var _binding: FragmentCustomerReser4Binding?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomerReser4Binding.inflate(inflater,container,false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}