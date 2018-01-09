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
class PracticeDraw3 : AppCompatActivity() {
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
        pageModels.add(PageModel(R.string.title_draw_text, R.layout.practice_draw_text))
        pageModels.add(PageModel(R.string.title_static_layout, R.layout.practice_static_layout))
        pageModels.add(PageModel(R.string.title_set_text_size, R.layout.practice_set_text_size))
        pageModels.add(PageModel(R.string.title_set_typeface, R.layout.practice_set_typeface))
        pageModels.add(PageModel(R.string.title_set_fake_bold_text, R.layout.practice_set_fake_bold_text))
        pageModels.add(PageModel(R.string.title_set_strike_thru_text, R.layout.practice_set_strike_thru_text))
        pageModels.add(PageModel(R.string.title_set_underline_text, R.layout.practice_set_underline_text))
        pageModels.add(PageModel(R.string.title_set_text_skew_x, R.layout.practice_set_text_skew_x))
        pageModels.add(PageModel(R.string.title_set_text_scale_x, R.layout.practice_set_text_scale_x))
        pageModels.add(PageModel(R.string.title_set_text_align, R.layout.practice_set_text_align))
        pageModels.add(PageModel(R.string.title_get_font_spacing, R.layout.practice_get_font_spacing))
        pageModels.add(PageModel(R.string.title_measure_text, R.layout.practice_measure_text))
        pageModels.add(PageModel(R.string.title_get_text_bounds, R.layout.practice_get_text_bounds))
        pageModels.add(PageModel(R.string.title_get_font_metrics, R.layout.practice_get_font_metrics))

    }

    class PageModel {
        var practiceLayoutRes: Int = 0
        var titleRes: Int = 0


        constructor( titleRes: Int,practiceLayoutRes: Int) {
            this.practiceLayoutRes = practiceLayoutRes
            this.titleRes = titleRes
        }


    }
}
