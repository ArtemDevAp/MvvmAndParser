package ru.qman.myapplication.repositories

import ru.qman.myapplication.entities.CoronaEntity
import ru.qman.myapplication.network.Client
import ru.qman.myapplication.network.CoronaParser

class CoronaRepository(private val client: Client) {

    fun getCoronaEntity(): CoronaEntity? {
        val source = client.source("https://www.worldometers.info/coronavirus/")
        return CoronaParser().parse(source)
    }
}