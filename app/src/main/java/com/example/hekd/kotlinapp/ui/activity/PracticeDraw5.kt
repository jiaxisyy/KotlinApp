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
class PracticeDraw5 : AppCompatActivity() {
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
        pageModels.add(PageModel(R.string.title_after_on_draw, R.layout.practice_after_on_draw))
        pageModels.add(PageModel(R.string.title_before_on_draw, R.layout.practice_before_on_draw))
        pageModels.add(PageModel(R.string.title_on_draw_layout, R.layout.practice_on_draw_layout))
        pageModels.add(PageModel(R.string.title_dispatch_draw, R.layout.practice_dispatch_draw))
        pageModels.add(PageModel(R.string.title_after_on_draw_foreground, R.layout.practice_after_on_draw_foreground))
        pageModels.add(PageModel(R.string.title_before_on_draw_foreground, R.layout.practice_before_on_draw_foreground))
        pageModels.add(PageModel(R.string.title_after_draw, R.layout.practice_after_draw))
        pageModels.add(PageModel(R.string.title_before_draw, R.layout.practice_before_draw))

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
