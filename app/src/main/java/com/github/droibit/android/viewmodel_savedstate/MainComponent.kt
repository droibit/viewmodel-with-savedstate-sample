package com.github.droibit.android.viewmodel_savedstate

import androidx.lifecycle.ViewModel
import dagger.multibindings.IntoMap
import androidx.savedstate.SavedStateRegistryOwner
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import dagger.*
import javax.inject.Named


@Component(modules = [
    MainModule::class
])
interface MainComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: MainActivity): Builder

        fun build(): MainComponent
    }
}

@Module(includes = [
    AssistedInject_ViewModelAssistedFactoriesModule::class,
    MainModule.BindingModule::class
])
object MainModule {

    @Nullable
    @Provides
    @JvmStatic
    fun provideDefaultArgs(): Bundle? {
        return null
    }

    @Named("text")
    @Provides
    @JvmStatic
    fun provideText(): String = "hello, world!"

    @Module
    interface BindingModule {
        @Binds
        @IntoMap
        @ViewModelKey(MainViewModel::class)
        fun bindFactory(factory: MainViewModel.Factory): ViewModelAssistedFactory<out ViewModel>

        @Binds
        fun bindSavedStateRegistryOwner(activity: MainActivity): SavedStateRegistryOwner

//        @Binds
//        fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
    }
}