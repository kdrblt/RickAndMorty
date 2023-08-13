package com.example.rickandmorty.ui.characterdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.common.Resource
import com.example.rickandmorty.domain.usecase.GetUniqueCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getUniqueCharacterUseCase: GetUniqueCharacterUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(CharacterDetailState())
    val state: State<CharacterDetailState> = _state

    init {
        val id = savedStateHandle.get<String>("characterId")
        id?.let { getCharacterDetails(it) }
    }

    private fun getCharacterDetails(id: String) {
        getUniqueCharacterUseCase(GetUniqueCharacterUseCase.Params(id)).onEach { it ->
            when (it) {
                is Resource.OnError -> {
                    _state.value = CharacterDetailState(error = it.error.message.toString())
                }

                Resource.OnLoading -> {
                    _state.value = CharacterDetailState(isLoading = true)
                }

                is Resource.OnSuccess -> {
                    _state.value = CharacterDetailState(character = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}
