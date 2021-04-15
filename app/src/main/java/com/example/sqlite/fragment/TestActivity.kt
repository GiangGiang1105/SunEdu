package com.example.sqlite.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sqlite.R
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity(), OneFragment.OnFragmentInteractionListener {

    private val oneFragment = OneFragment.newInstance()
    private val twoFragment = TwoFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        addFragment(oneFragment, R.id.frame)
        fragment_one.setOnClickListener {
            replace(oneFragment, R.id.frame)
        }
        fragment_two.setOnClickListener {
            replace(twoFragment, R.id.frame)
        }
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is TwoFragment) {
            (fragment as TwoFragment)?.let {
                it.didClickStartButton = {
                    textView.text = it.toString()
                }
            }
        }
    }

    override fun onChangerSum(sum: Int) {
        textView.text = sum.toString()
    }
}