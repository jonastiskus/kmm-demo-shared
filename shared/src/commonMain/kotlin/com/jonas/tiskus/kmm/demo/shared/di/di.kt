package com.jonas.tiskus.kmm.demo.shared.di

import com.jonas.tiskus.kmm.demo.shared.data.remote.CatsApi
import com.jonas.tiskus.kmm.demo.shared.data.remote.CatsApiImpl
import com.jonas.tiskus.kmm.demo.shared.data.repository.FactsRepositoryImpl
import com.jonas.tiskus.kmm.demo.shared.domain.repository.FactsRepository
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val di = DI {
    bindSingleton<CatsApi> { CatsApiImpl() }
    bindSingleton<FactsRepository> { FactsRepositoryImpl(instance()) }
}