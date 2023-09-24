package io.github.gusriil.moviemagnet.domain.repository

import io.github.gusriil.moviemagnet.domain.model.Person
import io.reactivex.Single

interface PersonRepository {

    fun getPerson(personId: Any): Single<Person>
}