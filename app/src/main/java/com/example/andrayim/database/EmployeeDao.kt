package com.example.andrayim.database

import androidx.room.*

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employee")
    fun getAll(): List<Employee>

    @Query("SELECT * FROM employee WHERE id = :id")
    fun getById(id: Long): Employee

    @Insert
    fun insert(employee:Employee): Long

    @Update
    fun update(employee: Employee)

    @Delete
    fun delete(employee: Employee)
}