package mbk.io.sabrina_hm1_6m.ui.second_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mbk.io.sabrina_hm1_6m.data.Repository
import mbk.io.sabrina_hm1_6m.model.Character
import javax.inject.Inject

class SecondViewModel(private val repository: Repository) : ViewModel() {

    fun getData(id: Int): LiveData<Character> {
        return repository.getCharacter(id)
    }
}