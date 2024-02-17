package mbk.io.sabrina_hm1_6m.data.api

import mbk.io.sabrina_hm1_6m.data.model.BaseResponse
import mbk.io.sabrina_hm1_6m.data.model.Character
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CartoonApiService {
    @GET("character")
    suspend fun getCharacters(): Response<BaseResponse>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>
}