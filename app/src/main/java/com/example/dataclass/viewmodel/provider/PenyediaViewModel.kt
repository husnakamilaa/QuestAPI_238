package com.example.dataclass.viewmodel.provider

import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dataclass.repositori.AplikasiDataSiswa
import com.example.dataclass.viewmodel.EntryViewModel
import com.example.dataclass.viewmodel.HomeViewModel

fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa = (
        this[viewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as
            AplikasiDataSiswa
        )

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiDataSiswa().container.repositoryDataSiswa) }
        initializer { EntryViewModel(aplikasiDataSiswa().container.repositoryDataSiswa) }
    }
}