package kr.ac.kpu.ce2019152012.hair_you.user.fragment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.kpu.ce2019152012.hair_you.adapter.SearchAdapter
import kr.ac.kpu.ce2019152012.hair_you.databinding.FragmentCustomerReser1Binding
import kr.ac.kpu.ce2019152012.hair_you.dto.SearchDataVo

class Customer_ResOneFragment : Fragment() {
    private var _binding: FragmentCustomerReser1Binding?= null
    private val binding get() = _binding!!

    // Adapter 변수 선언
    private lateinit var listAdapter: SearchAdapter

    // linearManager
    private lateinit var Lmanager: LinearLayoutManager

    // 검색 정보 변수 선언
    var datas = ArrayList<SearchDataVo>()

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
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}