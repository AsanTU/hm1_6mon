package mbk.io.sabrina_hm1_6m.ui.first_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mbk.io.sabrina_hm1_6m.data.model.BaseResponse
import mbk.io.sabrina_hm1_6m.data.repository.Repository
import mbk.io.sabrina_hm1_6m.data.model.Character
import mbk.io.sabrina_hm1_6m.utils.Resource

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _charactersLv = MutableLiveData<Resource<BaseResponse>>()
    val charactersLv: LiveData<Resource<BaseResponse>> = _charactersLv
    fun getCharacters() {
        _charactersLv.value = Resource.Loading()
        repository.getCharacters().observeForever { resource ->
            _charactersLv.value = resource
        }
    }

}