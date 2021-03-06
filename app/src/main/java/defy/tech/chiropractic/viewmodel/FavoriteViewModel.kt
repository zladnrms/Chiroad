package defy.tech.chiropractic.viewmodel

import android.app.Application
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import defy.tech.chiropractic.GlobalApplication
import defy.tech.chiropractic.model.FavoriteRepository
import defy.tech.chiropractic.model.favorite.Favorite

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = FavoriteRepository(application)
    private val contacts = repository.getAll()

    var welcomeText = MutableLiveData<String>().apply { value = "ㅂㅈㅇㅂ" }

    fun getAll(): LiveData<List<Favorite>> {
        return this.contacts
    }

    fun insert(contact: Favorite) {
        repository.insert(contact)
    }

    fun delete(contact: Favorite) {
        repository.delete(contact)
    }

    fun createWelcome() {
        welcomeText.value = "dd"
    }

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        welcomeText.value = s.toString()
    }
}
