package com.matthew.carvalhodagenais.coinhuntingbuddy.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.matthew.carvalhodagenais.coinhuntingbuddy.data.entities.Hunt
import com.matthew.carvalhodagenais.coinhuntingbuddy.data.entities.HuntGroup

@Dao
interface HuntDAO {
    @Insert
    suspend fun insert(hunt: Hunt)

    @Update
    suspend fun update(hunt: Hunt)

    @Delete
    suspend fun delete(hunt: Hunt)

    @Query("SELECT * FROM hunt_table WHERE hunt_group_id IN (SELECT * FROM hunt_group_table WHERE id = :id)")
    fun getHuntByHuntGroupId(id: Int): LiveData<HuntGroup>
}