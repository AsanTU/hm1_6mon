package mbk.io.sabrina_hm1_6m.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import mbk.io.sabrina_hm1_6m.data.api.CartoonApiService
import mbk.io.sabrina_hm1_6m.data.base.BaseRepository
import mbk.io.sabrina_hm1_6m.data.model.BaseResponse
import mbk.io.sabrina_hm1_6m.data.model.Character
import mbk.io.sabrina_hm1_6m.utils.Resource
import retrofit2.Response
import java.io.IOException

class Repository(private val api: CartoonApiService) : BaseRepository() {
    fun getCharacters(): LiveData<Resource<BaseResponse>> = doRequest {
        api.getCharacters()
    }

    fun getCharacter(id: Int): LiveData<Resource<Character>> = doRequest {
        api.getCharacter(id)
    }

}