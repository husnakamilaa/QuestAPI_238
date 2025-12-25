package com.example.dataclass.viewmodel

import android.annotation.SuppressLint
import retrofit2.HttpException
import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dataclass.modeldata.DataSiswa
import com.example.dataclass.repositori.RepositoryDataSiswa
import com.example.dataclass.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.launch
import retrofit2.Response
import okio.IOException

sealed interface StatusUIDetail {
    data class Success(val satusiswa: DataSiswa): StatusUIDetail
    object Error: StatusUIDetail
    object Loading: StatusUIDetail
}
