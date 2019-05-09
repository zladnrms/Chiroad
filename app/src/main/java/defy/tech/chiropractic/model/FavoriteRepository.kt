package defy.tech.chiropractic.model

import android.app.Application
import androidx.lifecycle.LiveData
import defy.tech.chiropractic.model.favorite.Favorite
import defy.tech.chiropractic.model.favorite.FavoriteDao
import defy.tech.chiropractic.model.favorite.FavoriteDatabase

class FavoriteRepository(application: Application) {

    private val contactDatabase = FavoriteDatabase.getInstance(application)!!
    private val contactDao: FavoriteDao = contactDatabase.favoriteDao()
    private val contacts: LiveData<List<Favorite>> = contactDao.getAll()

    fun getAll(): LiveData<List<Favorite>> {
        return contacts
    }

    fun insert(contact: Favorite) {
        try {
            val thread = Thread(Runnable {
                contactDao.insert(contact) })
            thread.start()
        } catch (e: Exception) { }
    }

    fun delete(contact: Favorite) {
        try {
            val thread = Thread(Runnable {
                contactDao.delete(contact)
            })
            thread.start()
        } catch (e: Exception) { }
    }

}