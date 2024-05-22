package academy.nouri.s1_project.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import azizi.mahsa.movieSample.ui.utils.Constants

@Entity(tableName = Constants.MOVIES_TABLE)
data class MovieEntity(
    @PrimaryKey
    var id: Int = 0,
    var poster: String = "",
    var title: String = "",
    var rate: String = "",
    var country: String = "",
    var year: String = ""
)
