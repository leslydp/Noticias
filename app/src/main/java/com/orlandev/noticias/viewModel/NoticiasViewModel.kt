package com.orlandev.noticias.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orlandev.noticias.data.source.remote.dto.News
import com.orlandev.noticias.data.source.repository.NoticiasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticiasViewModel @Inject constructor(private val noticiasRepository: NoticiasRepository) :
    ViewModel() {
    val data = MutableStateFlow<News?>(null)

    init {
        onRefresh()
    }

    fun onRefresh() {
        viewModelScope.launch {
            data.value = noticiasRepository.fetchAll()
        }
    }


}