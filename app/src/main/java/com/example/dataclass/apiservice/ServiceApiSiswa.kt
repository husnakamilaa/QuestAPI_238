package com.example.dataclass.apiservice

import com.example.dataclass.modeldata.DataSiswa
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApiSiswa  {
    @GET("bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>


}