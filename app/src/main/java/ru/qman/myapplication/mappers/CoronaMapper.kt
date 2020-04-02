package ru.qman.myapplication.mappers

import ru.qman.myapplication.entities.CoronaEntity
import ru.qman.myapplication.models.CoronaModel

class CoronaMapper {

    fun entityToModel(coronaEntity: CoronaEntity): CoronaModel {
        return CoronaModel(
            coronaEntity.cases,
            coronaEntity.deaths,
            coronaEntity.recovered
        )
    }
}