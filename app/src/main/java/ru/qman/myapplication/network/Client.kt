package ru.qman.myapplication.network

import java.net.URL

object Client {

    fun source(url: String): String = URL(url).readText()

}