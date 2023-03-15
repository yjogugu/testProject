package com.taijoo.myproject.module

import com.taijoo.myproject.data.model.BookStore
import com.taijoo.myproject.data.model.ClothingStore
import com.taijoo.myproject.data.model.Store
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent :: class)
abstract class StoreModule {

    @BookStoreQualifier
    @Binds
    abstract fun BookStoreImpl(bookStore: BookStore) : Store

    @ClothingStoreQualifier
    @Binds
    abstract fun ClothingStoreImpl(clothingStore: ClothingStore) : Store
}


@Qualifier
annotation class BookStoreQualifier

@Qualifier
annotation class ClothingStoreQualifier