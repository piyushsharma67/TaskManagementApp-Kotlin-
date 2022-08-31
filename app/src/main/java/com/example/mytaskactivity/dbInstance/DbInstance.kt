package com.example.mytaskactivity.dbInstance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mytaskactivity.dbInstance.dao.TaskDao
import com.example.mytaskactivity.dbInstance.entities.Task


@Database(entities = [Task::class], version = 1)
abstract class DbInstance: RoomDatabase() {

    abstract fun taskDao():TaskDao



    companion object{

        @Volatile
        private var instance:DbInstance?=null

        fun getDbInstance(context:Context):DbInstance{
            if(instance!=null){
                return instance!!
            }else {
                instance= Room.databaseBuilder(context,DbInstance::class.java,"tasktable").build()
                return instance!!
            }
        }
    }
}