import com.google.gson.Gson
import myapplication.network.MyResponse
import myapplication.network.MyResponseService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import retrofit2.http.GET





fun main(args: Array<String>) {
    val retrofit2 = Retrofit.Builder().baseUrl("https://echo.getpostman.com").addConverterFactory(GsonConverterFactory.create()).build()

    val myResponseService: MyResponseService? = retrofit2.create(MyResponseService::class.java)

    val call: Call<MyResponse>? = myResponseService?.getResponse("123")

    val response = call?.execute()?.body()

    print(response.toString())
}