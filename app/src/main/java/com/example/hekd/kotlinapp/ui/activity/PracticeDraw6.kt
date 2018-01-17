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
class PracticeDraw6 : AppCompatActivity() {
    val pageModels = arrayListOf<PageModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_practicedraw)
        init()
        vp_main.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                val fragment = PageFragment.newInstance(pageModels[position].practiceLayoutRes)
                return fragment
            }

            override fun getCount(): Int = pageModels.size

            override fun getPageTitle(position: Int): CharSequence = getString(pageModels[position].titleRes)
        }
        tb_main.setupWithViewPager(vp_main)
    }

    private fun init() {
        pageModels.add(PageModel(R.string.title_translation, R.layout.practice_translation))
        pageModels.add(PageModel(R.string.title_rotation, R.layout.practice_rotation))
        pageModels.add(PageModel(R.string.title_scale2, R.layout.practice_scale2))
        pageModels.add(PageModel(R.string.title_alpha, R.layout.practice_alpha))
        pageModels.add(PageModel(R.string.title_multi_properties, R.layout.practice_multi_properties))
        pageModels.add(PageModel(R.string.title_duration, R.layout.practice_duration))
        pageModels.add(PageModel(R.string.title_interpolator, R.layout.practice_interpolator))
        pageModels.add(PageModel(R.string.title_object_animator, R.layout.practice_object_animator))

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
