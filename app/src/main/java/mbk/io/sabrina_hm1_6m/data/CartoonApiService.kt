package mbk.io.sabrina_hm1_6m.data

import mbk.io.sabrina_hm1_6m.model.BaseResponse
import mbk.io.sabrina_hm1_6m.model.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CartoonApiService {
    @GET("character")
    fun getCharacters(): Call<BaseResponse<Character>>

    @GET("character/{id}")
    fun getCharacter(@Path("id") id: Int): Call<Character>
}