package com.example.rickandmorty.ui.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.domain.usecase.GetCharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(CharactersState())
    val state: State<CharactersState> = _state

    init {
        viewModelScope.launch {
            _state.value = CharactersState(
                pagingData = getCharacterListUseCase.invoke().cachedIn(viewModelScope),
            )
        }
    }
}
