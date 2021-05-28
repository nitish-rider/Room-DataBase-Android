package nks.infotech.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(use:User)


    @Query("SELECT * From user_table ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>
}