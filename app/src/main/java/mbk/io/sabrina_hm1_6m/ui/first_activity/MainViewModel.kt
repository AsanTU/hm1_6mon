package mbk.io.sabrina_hm1_6m.ui.first_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mbk.io.sabrina_hm1_6m.data.Repository
import mbk.io.sabrina_hm1_6m.model.Character
import mbk.io.sabrina_hm1_6m.utils.Resource
import javax.inject.Inject

class MainViewModel (
    private val repository: Repository
) : ViewModel() {
    fun getAllData(): LiveData<Resource<List<Character>>> {
        return repository.getCharacters()
    }
}