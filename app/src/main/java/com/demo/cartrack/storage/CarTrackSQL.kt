package com.demo.cartrack.storage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.demo.cartrack.storage.StorageConstants.COLUMN_DATE
import com.demo.cartrack.storage.StorageConstants.COLUMN_ID
import com.demo.cartrack.storage.StorageConstants.COLUMN_PASSWORD
import com.demo.cartrack.storage.StorageConstants.COLUMN_USER_NAME
import com.demo.cartrack.storage.StorageConstants.TABLE_LOGIN

class CarTrackSQL(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 4) {


    override fun onCreate(db: SQLiteDatabase) {
        try {
            try {
                db.execSQL(CREATE_LOGIN_TABLE)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "car_track_storage"
        private const val CREATE_LOGIN_TABLE =
            "create table " + TABLE_LOGIN + "(" + COLUMN_ID + " integer primary key autoincrement not null," + COLUMN_DATE + " TEXT not null," +
                    COLUMN_USER_NAME + " TEXT not null," + COLUMN_PASSWORD + " TEXT not null);"

    }
}