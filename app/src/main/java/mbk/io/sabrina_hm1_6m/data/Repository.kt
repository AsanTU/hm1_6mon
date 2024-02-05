package mbk.io.sabrina_hm1_6m.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mbk.io.sabrina_hm1_6m.model.BaseResponse
import mbk.io.sabrina_hm1_6m.model.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: CartoonApiService) {
    fun getCharacters(): MutableLiveData<List<Character>> {
        val characters = MutableLiveData<List<Character>>()

        api.getCharacters().enqueue(object : Callback<BaseResponse> {
            override fun onResponse(
                call: Call<BaseResponse>,
                response: Response<BaseResponse>
            ) {
                if (response.isSuccessful && response.body() != null && response.code() in 200..300) {
                    response.body()?.let {
                        characters.postValue(it.results)
                    }
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                Log.e("ololo", t.message.toString())
            }

        })
        return characters
    }

    fun getCharacter(id: Int): LiveData<Character> {
        val characterLv = MutableLiveData<Character>()
        api.getCharacter(id).enqueue(object : Callback<Character> {
            override fun onResponse(
                call: Call<Character>,
                response: Response<Character>
            ) {
                response.body()?.let {
                    characterLv.postValue(it)
                }
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.e("ololo", t.message.toString())
            }
        })
        return characterLv
    }
}