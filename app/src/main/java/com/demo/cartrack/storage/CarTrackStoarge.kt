package com.demo.cartrack.storage

import android.content.Context
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.text.TextUtils
import java.sql.SQLException

class CarTrackStoarge(val context: Context) {
    private val TAG: String = CarTrackStoarge::class.java.name
    private var carTrackSQL: CarTrackSQL? = null
    private var database: SQLiteDatabase? = null

    /***
     * Open DataBase
     */

    @Throws(SQLException::class)
    fun openDatabase() {
        try {
            if (carTrackSQL == null) {
                carTrackSQL = CarTrackSQL(context)
            }
            database = carTrackSQL?.writableDatabase
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * Close DataBase
     */
    private fun closeDataBase() {
        if (database != null && database!!.isOpen && carTrackSQL != null)
            carTrackSQL?.close()
    }


    /**
     *  Check user details there or not
     */

    fun checkLoginUser(username: String, pwd: String): Boolean {
        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(pwd)) {
            return false
        }
        return try {
            openDatabase()
            val selectQuery = "Select count(0) from " + StorageConstants.TABLE_LOGIN + " where " + StorageConstants.COLUMN_USER_NAME + "=? AND " + StorageConstants.COLUMN_PASSWORD + "=?"
            val args = arrayOf(username, pwd)
            val count = DatabaseUtils.longForQuery(database, selectQuery, args)
            count != 0L
        } catch (e: Exception) {
            false
        } finally {
            closeDataBase()
        }
    }

    /**
     * Insert user details into DB
     */

     fun insertUserDetailsIntoDataBase(username: String, pwd: String) {
        val sqLiteStatement = database?.compileStatement("insert into " + StorageConstants.TABLE_LOGIN + "(" + StorageConstants.COLUMN_USER_NAME + "," + StorageConstants.COLUMN_PASSWORD + ") VALUES (?,?)")
        sqLiteStatement?.bindString(1, username)
        sqLiteStatement?.bindString(2, pwd)
        sqLiteStatement?.executeInsert()
        sqLiteStatement?.clearBindings()
    }

    /***
     * Storing user details in local DB
     */

    fun storeDetails(username: String, pwd: String): Boolean {
        try {
            openDatabase()
            if (database != null) {
                val stmt = database?.compileStatement("INSERT INTO " + StorageConstants.TABLE_LOGIN +
                        "(" + StorageConstants.COLUMN_USER_NAME + "," + StorageConstants.COLUMN_PASSWORD
                        + "," + StorageConstants.COLUMN_COUNTRY
                        + ")VALUES(?,?,?)")
                stmt?.bindString(1, username)
                stmt?.bindString(2, pwd)
                stmt?.executeInsert()
                stmt?.clearBindings()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        } finally {
            closeDataBase()
        }
        return true
    }

}