package com.example.hekd.kotlinapp.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.example.hekd.kotlinapp.R
import com.example.hekd.kotlinapp.ui.PageFragment
import kotlinx.android.synthetic.main.activity_practicedraw.*

/**
 * Created by hekd on 2017/11/10.
 */
class PracticeDraw7 : AppCompatActivity() {
    val pageModels = arrayListOf<PageModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_practicedraw)
        init()
        vp_main.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment =
                    PageFragment.newInstance(pageModels[position].practiceLayoutRes)

            override fun getCount(): Int = pageModels.size

            override fun getPageTitle(position: Int): CharSequence = getString(pageModels[position].titleRes)
        }
        tb_main.setupWithViewPager(vp_main)
    }

    private fun init() {
        pageModels.add(PageModel( R.string.title_argb_evaluator, R.layout.practice_argb_evaluator))
        pageModels.add(PageModel( R.string.title_hsv_evaluator, R.layout.practice_hsv_evaluator))
        pageModels.add(PageModel( R.string.title_of_object, R.layout.practice_of_object))
        pageModels.add(PageModel( R.string.title_property_values_holder, R.layout.practice_property_values_holder))
        pageModels.add(PageModel( R.string.title_animator_set, R.layout.practice_animator_set))
        pageModels.add(PageModel(R.string.title_keyframe, R.layout.practice_keyframe))
    }

    class PageModel {
        var practiceLayoutRes: Int = 0
        var titleRes: Int = 0


        constructor(titleRes: Int, practiceLayoutRes: Int) {
            this.practiceLayoutRes = practiceLayoutRes
            this.titleRes = titleRes
        }


    }
}
