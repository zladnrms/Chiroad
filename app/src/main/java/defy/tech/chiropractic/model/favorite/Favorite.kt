package defy.tech.chiropractic.model.favorite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class Favorite(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "link_url")
    var link_url: String
) {
    constructor() : this(null, "", "", "")
}
