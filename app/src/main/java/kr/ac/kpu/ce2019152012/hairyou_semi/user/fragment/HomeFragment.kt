package kr.ac.kpu.ce2019152012.hairyou_semi.user.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.ac.kpu.ce2019152012.hairyou_semi.R
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    var place_name: String = "@@@@@@@@@@@@@"             // 장소명, 업체명
    lateinit var address_name: String           // 전체 지번 주소
    lateinit var road_address_name: String      // 전체 도로명 주소
    lateinit var x: String                      // X 좌표값 혹은 longitude
    lateinit var y: String                      // Y 좌표값 혹은 latitude


    // ResearchAdapter 변수 선언
//    private lateinit var listAdapter: SearchAdapter
//    private lateinit var listAdapter : HomeAdapter

    // linearManager
    private lateinit var Lmanager: LinearLayoutManager

    // gridManager
    private lateinit var Gmanager: GridLayoutManager

    // 검색 정보 변수 선언
//    private lateinit var datas : ArrayList<SearchDataVo>

//    val datas = mutableListOf<HomeShopDataVo>()

    private lateinit var navController: NavController

    // 뷰가 생성되었을 때
    // 프래그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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

    companion object{
        const val RawCount = 1
    }

}
