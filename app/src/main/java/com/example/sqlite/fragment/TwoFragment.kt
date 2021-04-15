package com.example.sqlite.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sqlite.R
import kotlinx.android.synthetic.main.fragment_two.*

class TwoFragment : Fragment() {

    var didClickStartButton: ((sum: Int) -> Unit)? = null
    private var sum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(" onCreate", " onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
        Log.e(" onCreateView", " onCreateView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(" onViewCreated", "onViewCreated")
        increase.setOnClickListener {
            sum++
            didClickStartButton?.invoke(sum)
        }
    }

    override fun onStart() {
        Log.e("onStart", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e(" onResume", " onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("onPause", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("onStop", "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.e("onDestroyView", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e("onDestroy", "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.e("onDetach", "onDetach")
        super.onDetach()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("onAttach", "onAttach")
    }

    companion object {
       fun newInstance() = TwoFragment()
    }
}