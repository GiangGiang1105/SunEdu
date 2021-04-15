package com.example.sqlite.fragment

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    beginTransaction().apply() {
        func()
        commit()
    }
}

fun AppCompatActivity.addFragment(fragment: Fragment, id: Int) {
    supportFragmentManager.inTransaction {
        add( id, fragment)
        addToBackStack(null)
    }
}

fun AppCompatActivity.replace(fragment: Fragment, id: Int){
    supportFragmentManager.inTransaction {
        replace(id, fragment)
        addToBackStack(null)
    }
}

fun AppCompatActivity.remove(fragment: Fragment){
    supportFragmentManager.inTransaction {
        remove(fragment)
    }
}