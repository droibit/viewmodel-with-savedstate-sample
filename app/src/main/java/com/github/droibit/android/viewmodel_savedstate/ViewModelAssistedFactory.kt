package com.github.droibit.android.viewmodel_savedstate

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ViewModelAssistedFactory<T : ViewModel> {
    fun create(handle: SavedStateHandle): T
}