package com.example.sqlite.SQLite

import android.provider.BaseColumns

object TestReaderContact{
    object TestEntry : BaseColumns{
        const val TABLE_NAME = "entry"
        const val COLUMN_TITLE = "title"
        const val COLUMN_NAME_SUBTITLE = "subtitle"
    }
}
