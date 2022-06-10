package com.c22pc415.felicare.utils

import android.content.Context
import android.util.Patterns
import android.widget.Toast

object Utils {
    private const val MINIMUM_PASSWORD_LENGTH = 6

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun validateEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun validatePassword(password: String): Boolean =
        password.length >= MINIMUM_PASSWORD_LENGTH

    fun validateName(name: String): Boolean = name.isNotEmpty()

}