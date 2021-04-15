package com.example.sqlite.SQLite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sqlite.R

class SQLiteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = Database(this)
       /*val database = dbHelper.writableDatabase*/
        val database = dbHelper.readableDatabase
       val int =  dbHelper.onInsert(database, Test("My Title", "My test one"))
        Log.e("Insert", int.toString())
        dbHelper.onInsert(database, Test("My Test 1", "My test two"))
        dbHelper.onInsert(database, Test("My Test", "My test three"))
        dbHelper.onSelect(database)
        dbHelper.onDelete(database)
        
    }
}