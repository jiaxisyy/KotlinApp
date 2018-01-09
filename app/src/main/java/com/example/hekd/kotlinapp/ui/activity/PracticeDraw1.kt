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
class PracticeDraw1 : AppCompatActivity() {
    val pageModels = arrayListOf<PagerModel>()
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
        pageModels.add(PagerModel(R.layout.practice_color, R.string.title_draw_color))
        pageModels.add(PagerModel(R.layout.practice_circle, R.string.title_draw_circle))
        pageModels.add(PagerModel(R.layout.practice_rect, R.string.title_draw_rect))
        pageModels.add(PagerModel(R.layout.practice_point, R.string.title_draw_point))
        pageModels.add(PagerModel(R.layout.practice_oval, R.string.title_draw_oval))
        pageModels.add(PagerModel(R.layout.practice_line, R.string.title_draw_line))
        pageModels.add(PagerModel(R.layout.practice_round_rect, R.string.title_draw_round_rect))
        pageModels.add(PagerModel(R.layout.practice_arc, R.string.title_draw_arc))
        pageModels.add(PagerModel(R.layout.practice_path, R.string.title_draw_path))
        pageModels.add(PagerModel(R.layout.practice_histogram, R.string.title_draw_histogram))
        pageModels.add(PagerModel(R.layout.practice_pie_chart, R.string.title_draw_pie_chart))

    }

    class PagerModel {
        var practiceLayoutRes: Int = 0
        var titleRes: Int = 0
        constructor(practiceLayoutRes: Int, titleRes: Int) {
            this.practiceLayoutRes = practiceLayoutRes
            this.titleRes = titleRes
        }


    }
}
