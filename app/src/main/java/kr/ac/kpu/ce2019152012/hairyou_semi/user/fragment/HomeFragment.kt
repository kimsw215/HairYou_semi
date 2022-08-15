package kr.ac.kpu.ce2019152012.hairyou_semi.user.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.MarkerOptions
import kr.ac.kpu.ce2019152012.hairyou_semi.R

import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mapView: GoogleMap

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    var permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.map.getMapAsync(this)
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

    override fun onMapReady(googleMap: GoogleMap) {
        val myLocation = com.google.android.gms.maps.model.LatLng(37.3401906, 126.7335293)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15f))

        // 마커 출력
        val marker = MarkerOptions().position(myLocation)
            .title("한국공학대학교")

        googleMap?.addMarker(marker)
    }
}
