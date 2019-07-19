package ru.skillbranch.dev_intensive.utils

import android.service.voice.AlwaysOnHotwordDetector

object Utils {
    fun parseFullName (fullName:String?) :Pair<String?, String?>{
//      FIX ME - HOME TASK
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
       // return Pair (firstName, lastName)
        return firstName to lastName
    }

   /* fun transliteration(payload: String, divider: String = " "): String {
        TODO("not implemented")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("not implemented")
    }
}