package com.example.sqlite.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sqlite.R
import kotlinx.android.synthetic.main.fragment_one.*

class OneFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null
    private var sum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        increase.setOnClickListener {
            sum++
            mListener?.onChangerSum(sum)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        }
    }

    companion object {

        fun newInstance() = OneFragment()
    }

    interface OnFragmentInteractionListener {
        fun onChangerSum(sum: Int)
    }
}