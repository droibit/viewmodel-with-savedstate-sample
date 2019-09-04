package com.github.droibit.android.viewmodel_savedstate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import javax.inject.Named

class MainViewModel @AssistedInject constructor(
    @Named("text") text: String,
    @Assisted private val handle: SavedStateHandle
) : ViewModel() {
    private val textSink = MutableLiveData<String>().apply { value = text }
    val text: LiveData<String> = textSink

    @AssistedInject.Factory
    interface Factory : ViewModelAssistedFactory<MainViewModel>
}