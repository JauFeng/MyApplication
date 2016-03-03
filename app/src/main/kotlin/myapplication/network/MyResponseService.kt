package myapplication.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyResponseService {
    @GET("get")
    fun getResponse(@Query("param") param: String): Call<MyResponse>
}