package kr.ac.kpu.ce2019152012.hairyou_semi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.ktx.Firebase
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.ActivityJoinCustomerBinding

class JoinCustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJoinCustomerBinding

    private lateinit var auth: FirebaseAuth
    private lateinit var db : FirebaseFirestore

    private var user = Firebase.auth.currentUser
    private var uid = user?.uid.toString()

    private val itemsCollectionRef = db.collection("Customer")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)
        binding = ActivityJoinCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        setup2()

        // 회원가입 뒤로가기 버튼
        binding.joinBackBtn.setOnClickListener {
            val intent = Intent(this, JoinSelectActivity::class.java)
            startActivity(intent)
        }

        // 회원가입 버튼 누르면 서버로 Call
        binding.joinInBtn.setOnClickListener {
            val gender = if (binding.joinSelectMan.isSelected()) "male" else "female"

            //customer.saveCustomer().enqueue(Callback)

            val email = binding.joinIdEdit.text.toString().trim()
            val password = binding.joinPwEdit.text.toString().trim()

            // Database store
            val userInformation = hashMapOf(
                "id" to binding.joinIdEdit.text.toString().trim(),
                "passwd" to binding.joinPwEdit.text.toString().trim(),
                "name" to binding.joinNameEdit.text.toString().trim(),
                "phone" to binding.joinPhoneEdit.text.toString().trim(),
                "uid" to uid
            )

            db.collection("Customer").document(uid)
                .set(userInformation, SetOptions.merge())
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }



            createUser(email, password)
            // 회원가입 완료 후 로그인창으로 이동
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            // 이메일 형식 체크
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                if (task.isSuccessful) {
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            } else {
                Toast.makeText(this, "이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show()
                updateUI(null)
            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    private fun reload() {

    }

    companion object {
        private const val TAG = "EmailPassword"
    }

    fun setup2(){
        db = FirebaseFirestore.getInstance()
        val settings = firestoreSettings {
            isPersistenceEnabled = true
        }
        db.firestoreSettings = settings
    }
}
