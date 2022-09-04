package com.example.mytaskactivity.dbInstance.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.sql.Timestamp
import java.time.Instant.now
import java.time.LocalDate.now
import java.time.LocalDateTime

@Entity(tableName = "tasks")
data class Task(

    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    val task:String,
    val time:String
//    @Embedded
//    val createdAt:LocalDateTime= LocalDateTime.now()
)
