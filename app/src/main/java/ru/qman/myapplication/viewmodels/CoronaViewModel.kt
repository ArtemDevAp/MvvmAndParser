package ru.qman.myapplication.viewmodels

import androidx.arch.core.util.Function
import androidx.lifecycle.*
import kotlinx.coroutines.*
import ru.qman.myapplication.entities.CoronaEntity
import ru.qman.myapplication.mappers.CoronaMapper
import ru.qman.myapplication.models.CoronaModel
import ru.qman.myapplication.network.Client
import ru.qman.myapplication.repositories.CoronaRepository

class CoronaViewModel : ViewModel() {

    private val mCoronaEntity = MutableLiveData<CoronaEntity>()
    private val mError = MutableLiveData<String>()
    private val mLoading = MutableLiveData<Boolean>()

    private val mCoronaRepository = CoronaRepository(Client)
    private val mapper = CoronaMapper()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mCoronaRepository.getCoronaEntity()?.let {
                    mCoronaEntity.postValue(it)
                } ?: mError.postValue("Null data")

            } catch (t: Throwable) {
                mError.postValue(t.message)
            }
        }
    }

    fun getData(): LiveData<CoronaModel> = Transformations.map(mCoronaEntity, Function {
        return@Function mapper.entityToModel(it)
    })

    fun error(): LiveData<String> = mError
}