package defy.tech.chiropractic.model.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite ORDER BY id ASC")
    fun getAll(): LiveData<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(contact: Favorite)

    @Delete
    fun delete(contact: Favorite)

}