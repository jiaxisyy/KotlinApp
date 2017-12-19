package com.example.hekd.kotlinapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hekd.kotlinapp.R
import kotlinx.android.synthetic.main.fragment_page.view.*

/**
 * Created by hekd on 2017/11/13.
 */
class PageFragment : Fragment() {
    var practiceLayoutRes: Int = 0


    companion object {
        fun newInstance(practiceLayoutRes: Int): PageFragment {
            val fragment = PageFragment()
            val bundle = Bundle()
            bundle.putInt("practiceLayoutRes", practiceLayoutRes)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val arguments = arguments
        practiceLayoutRes = arguments!!.getInt("practiceLayoutRes")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_page, container, false)
        val practiceStub = view.practiceStub
        practiceStub.layoutResource = practiceLayoutRes
        practiceStub.inflate()
        return view
    }
}