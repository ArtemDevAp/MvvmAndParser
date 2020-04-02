package ru.qman.myapplication.network

import android.util.Log
import ru.qman.myapplication.entities.CoronaEntity
import java.util.regex.Pattern

class CoronaParser {

    fun parse(source: String): CoronaEntity? {

        val pattern = Pattern.compile(
                "r-number.*?>.*?(\\d+,?\\d+).*?<.*?r-number.*?>.*?(\\d+,?\\d+).*?<.*?r-number.*?>.*?(\\d+,?\\d+).*?<",
                Pattern.CASE_INSENSITIVE or Pattern.DOTALL
        )

        val matcher = pattern.matcher(source)
        val massive = mutableListOf<String>()

        if (matcher.find()) {
            massive += matcher.group(1)
            massive += matcher.group(2)
            massive += matcher.group(3)
        }
        return CoronaEntity(massive[0], massive[1], massive[2])
    }
}