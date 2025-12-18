package com.example.dataclass.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dataclass.repositori.RepositoryDataSiswa
import okio.IOException

sealed interface StatusUiSiswa {

}

class HomeViewModel(private val repositoryDataSiswa: RepositoryDataSiswa: RepositoryDataSiswa):
        viewModel() {
            var listSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa.Loading)
                private set
            init {
                loadSiswa()
            }

            fun loadSiswa() {
                viewModelScope.launch {
                    listSiswa = StatusUiSiswa.Loading
                    listSiswa = try {
                        StatusUiSiswa.Success(repositoryDataSiswa.getDataSiswa())
                    }catch (e: IOException){
                        StatusUiSiswa.Error
                    }
                }
            }
        }
