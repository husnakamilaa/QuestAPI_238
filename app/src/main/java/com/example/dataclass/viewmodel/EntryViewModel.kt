package com.example.dataclass.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dataclass.modeldata.DetailSiswa
import com.example.dataclass.modeldata.UIStateSiswa
import com.example.dataclass.modeldata.toDataSiswa
import com.example.dataclass.repositori.JaringanRepositoryDataSiswa
import com.example.dataclass.repositori.RepositoryDataSiswa
import okhttp3.Response

class EntryViewModel (private val repositoryDataSiswa: RepositoryDataSiswa):
        ViewModel() {
            var uiStateSiswa by mutableStateOf(UIStateSiswa())
                private set

            //fungsi buat validasi input
            private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa):
                    Boolean {
                    return with(uiState) {
                        nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
                    }
            }

            // fungsi buat nangani kalo ada perubahan text input
            fun updateUiState(detailSiswa: DetailSiswa) {
                uiStateSiswa =
                    UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
            }

            //fungsi buat nyimpen data yang di entry
            suspend fun addSiswa() {
                if (validasiInput()) {
                    val sip:Response<Void> = repositoyDataSiswa.postDataSiswa(uiStateSiswa
                        .detailSiswa.toDataSiswa())
                    if (sip.isSuccessful) {
                        println("Sukses Tambah Data: ${sip.message()}")
                    }else {
                        println("Gagal tambah data: ${sip.errorBody()}")
                    }
                }
            }

        }