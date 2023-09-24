package io.github.gusriil.moviemagnet.repository

import io.github.gusriil.moviemagnet.data.network.PersonApi
import io.github.gusriil.moviemagnet.data.response.asDomainModel
import io.github.gusriil.moviemagnet.domain.repository.PersonRepository
import io.github.gusriil.moviemagnet.domain.model.Person
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PersonRepositoryImpl @Inject constructor(
    private val personApi: PersonApi
) : PersonRepository {

    override fun getPerson(personId: Any): Single<Person> =
        personApi.getPerson(personId).map { it.asDomainModel() }
}