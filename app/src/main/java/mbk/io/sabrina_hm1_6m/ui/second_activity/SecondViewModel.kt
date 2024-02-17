package mbk.io.sabrina_hm1_6m.ui.second_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mbk.io.sabrina_hm1_6m.data.model.BaseResponse
import mbk.io.sabrina_hm1_6m.data.repository.Repository
import mbk.io.sabrina_hm1_6m.data.model.Character
import mbk.io.sabrina_hm1_6m.utils.Resource

class SecondViewModel(private val repository: Repository) : ViewModel() {

    private val _charactersLv = MutableLiveData<Resource<Character>>()
    val charactersLv: LiveData<Resource<Character>> = _charactersLv
    fun getCharacter(id: Int) {
        _charactersLv.value = Resource.Loading()
        repository.getCharacter(id).observeForever { resource ->
            _charactersLv.value = resource
        }
    }
}