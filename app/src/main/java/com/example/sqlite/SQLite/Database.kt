package com.example.sqlite.SQLite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class Database(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TEST)
        Log.e("onCreate database", "onCreate database")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_TEST)
        Log.e("onUpgrade database", "onUpgrade database")
    }

    override fun close() {
        Log.e("Close database", "Close database")
        super.close()
    }

    override fun getDatabaseName(): String {
        return super.getDatabaseName()
    }

    override fun setWriteAheadLoggingEnabled(enabled: Boolean) {
        super.setWriteAheadLoggingEnabled(enabled)
    }

    override fun setLookasideConfig(slotSize: Int, slotCount: Int) {
        super.setLookasideConfig(slotSize, slotCount)
    }

    override fun setOpenParams(openParams: SQLiteDatabase.OpenParams) {
        //đặt các thông số cấu hình để mở database
        Log.e("setOpenParams", "" + openParams)
        super.setOpenParams(openParams)
    }

    override fun setIdleConnectionTimeout(idleConnectionTimeoutMs: Long) {
        super.setIdleConnectionTimeout(idleConnectionTimeoutMs)
    }

    override fun getWritableDatabase(): SQLiteDatabase {
        Log.e("getWritableDatabase", "getWritableDatabase")
        return super.getWritableDatabase()
    }

    override fun getReadableDatabase(): SQLiteDatabase {
        Log.e("getReadableDatabase", "getReadableDatabase")
        return super.getReadableDatabase()
    }

    override fun onConfigure(db: SQLiteDatabase?) {
        Log.e("onConfigure database ", "onConfigure database ")
        super.onConfigure(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    override fun onOpen(db: SQLiteDatabase?) {
        Log.e("onOpen database", "onOpen database")
        super.onOpen(db)
    }

    fun onInsert(db: SQLiteDatabase?, test: Test): Long? {
        val values = ContentValues().apply {
            put(TestReaderContact.TestEntry.COLUMN_TITLE, test.title)
            put(TestReaderContact.TestEntry.COLUMN_NAME_SUBTITLE, test.subtitle)
        }
        return db?.insert(TestReaderContact.TestEntry.TABLE_NAME, null, values)
    }

    fun onSelect(db: SQLiteDatabase): MutableList<Test> {
        var result = mutableListOf<Test>()
        val projection = arrayOf(
            BaseColumns._ID,
            TestReaderContact.TestEntry.COLUMN_TITLE,
            TestReaderContact.TestEntry.COLUMN_NAME_SUBTITLE
        )
        val selection = "${TestReaderContact.TestEntry.COLUMN_TITLE} = ?"
        val selectionArgs = arrayOf("//")
        val sortOrder = "${TestReaderContact.TestEntry.COLUMN_NAME_SUBTITLE} DESC"
        val cursor = db.query(
            TestReaderContact.TestEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder
        )
        with(cursor) {
            while (moveToNext()) {
                val title = getString(getColumnIndex(TestReaderContact.TestEntry.COLUMN_TITLE))
                val subtitle =
                    getString(getColumnIndex(TestReaderContact.TestEntry.COLUMN_NAME_SUBTITLE))
                val test = Test(title, subtitle)
                result.add(test)
            }
            close()
        }
        return result
    }

    fun onDelete(db: SQLiteDatabase?): Int? {
        val selection = "${TestReaderContact.TestEntry.COLUMN_TITLE} LIKE ?"
        val selectionArgs = arrayOf("MyTitle")
        return db?.delete(TestReaderContact.TestEntry.TABLE_NAME, selection, selectionArgs)
    }

    companion object {
        const val DATABASE_NAME = "TestDatabase.db"
        const val DATABASE_VERSION = 1
        const val SQL_CREATE_TEST =
            "CREATE TABLE ${TestReaderContact.TestEntry.TABLE_NAME}(${BaseColumns._ID} INTEGER PRIMARY KEY, " +
                    "${TestReaderContact.TestEntry.COLUMN_TITLE} TEXT, " +
                    "${TestReaderContact.TestEntry.COLUMN_NAME_SUBTITLE} TEXT)"
        const val SQL_DELETE_TEST = "DROP TABLE IF EXISTS ${TestReaderContact.TestEntry.TABLE_NAME}"
    }
}