package io.github.gusriil.moviemagnet.ui.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.repository.PersonRepository
import io.github.gusriil.moviemagnet.domain.model.Credit
import io.github.gusriil.moviemagnet.domain.model.Person
import io.github.gusriil.moviemagnet.ui.BaseDetailViewModel
import javax.inject.Inject

class PersonViewModel(
    repository: PersonRepository,
    personId: Any
) : BaseDetailViewModel<Person>(repository.getPerson(personId)) {

    /**
     * Factory for constructing PersonViewModel with parameter
     */
    class Factory @Inject constructor(
        private val repository: PersonRepository,
        private val credit: Credit
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PersonViewModel(repository, credit.id) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}