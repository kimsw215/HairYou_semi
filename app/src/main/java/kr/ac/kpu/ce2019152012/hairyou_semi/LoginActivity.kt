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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.ktx.Firebase
import kr.ac.kpu.ce2019152012.hairyou_semi.databinding.ActivityLoginBinding
import kr.ac.kpu.ce2019152012.hairyou_semi.user.CustomerContainerActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)

        auth = Firebase.auth
        setup2()

        // 로그인버튼 누르고 디자이너와 고객창으로 이동하기위한 데이터베이스 id 리스트
        var CustomerList = arrayListOf<String>()
        var DesignerList = arrayListOf<String>()

        db.collection("Customer")
            .get()
            .addOnSuccessListener { result ->
                for (docoment in result) {
                    CustomerList.add(docoment.id.trim())
                    Log.d("list", CustomerList.toString().trim())
                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }

        db.collection("Designer")
            .get()
            .addOnSuccessListener { result ->
                for (docoment in result) {
                    DesignerList.add(docoment.id.trim())
                    Log.d("list", DesignerList.toString().trim())
                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }

        // 이메일로 로그인
        binding.loginBtn.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.editId.text.toString().trim(),
                binding.editPwEdit.text.toString().trim()
            )
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                        val user = auth?.currentUser
                        updateUI(user)
                        if (binding.editId.text.toString().trim() in CustomerList) {
                            val intent = Intent(this, CustomerContainerActivity::class.java)
                            intent.putExtra("userId", binding.editId.text.toString())
                            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            finish()
                        }
                        else {
                            Log.w(TAG, "Error getting documents ")
                        }
                    } else {
                        Toast.makeText(this, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
        }

        binding.joinText.setOnClickListener {
            val intent = Intent(this, JoinSelectActivity::class.java)
            startActivity(intent)
        }

    }

/*    private fun signIn(email: String, password: String) {
        // [START sign_in_with_email]
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                    val intent = Intent(this, DesignerMainActivity::class.java)
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                } else {
                    Toast.makeText(this, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
        // [END sign_in_with_email]
    }*/

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accroingly.
        val currenUser = auth.currentUser
        if (currenUser != null) {
            reload()
        }
    }

    private fun sendEmailVerification() {
        // [START send_email_verification]
        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                // Email Verification sent
            }
        // [END send_email_verification]
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    private fun reload() {

    }

    fun setup() {
        db = Firebase.firestore

        val settings = firestoreSettings {
            isPersistenceEnabled = true
        }
        db.firestoreSettings = settings
    }

    fun setup2() {
        db = FirebaseFirestore.getInstance()
        val settings = firestoreSettings {
            isPersistenceEnabled = true
        }
        db.firestoreSettings = settings
    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}