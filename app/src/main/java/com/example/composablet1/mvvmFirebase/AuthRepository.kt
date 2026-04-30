package com.example.composablet1.mvvmFirebase

import com.google.firebase.auth.FirebaseAuth

class AuthRepository {

    private val auth = FirebaseAuth.getInstance()

//    fun login(
//        email: String,
//        password: String,
//        onResult: (Boolean, String?) -> Unit
//    ) {
//        auth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener {
//                if (it.isSuccessful) {
//                    onResult(true, null)
//                } else {
//                    task.exception?.printStackTrace()
//                    onResult(false, it.exception?.message)
//                }
//            }
//    }
    fun login(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    task.exception?.printStackTrace() // 🔥 VERY IMPORTANT
                    onResult(false, task.exception?.message)
                }
            }
    }

    fun register(
        email: String,
        password: String,
        onResult: (Boolean, String?) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, it.exception?.message)
                }
            }
    }
}