package com.example.hekd.kotlinapp.ui.activity

import android.app.Activity
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.example.hekd.kotlinapp.R
import com.example.hekd.kotlinapp.ui.PageFragment

import kotlinx.android.synthetic.main.activity_practicedraw.*

/**
 * Created by hekd on 2017/11/10.
 */
class PracticeDraw2 : AppCompatActivity() {
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
        pageModels.add(PagerModel(R.layout.practice_linear_gradient, R.string.title_linear_gradient))
        pageModels.add(PagerModel(R.layout.practice_radial_gradient, R.string.title_radial_gradient))
        pageModels.add(PagerModel(R.layout.practice_sweep_gradient, R.string.title_sweep_gradient))
        pageModels.add(PagerModel(R.layout.practice_bitmap_shader, R.string.title_bitmap_shader))
        pageModels.add(PagerModel(R.layout.practice_compose_shader, R.string.title_compose_shader))
        pageModels.add(PagerModel(R.layout.practice_lighting_color_filter, R.string.title_lighting_color_filter))
        pageModels.add(PagerModel(R.layout.practice_color_matrix_color_filter, R.string.title_color_matrix_color_filter))
        pageModels.add(PagerModel(R.layout.practice_xfermode, R.string.title_xfermode))
        pageModels.add(PagerModel(R.layout.practice_stroke_cap, R.string.title_stroke_cap))
        pageModels.add(PagerModel(R.layout.practice_stroke_join, R.string.title_stroke_join))
        pageModels.add(PagerModel(R.layout.practice_stroke_miter, R.string.title_stroke_miter))
        pageModels.add(PagerModel(R.layout.practice_path_effect, R.string.title_path_effect))
        pageModels.add(PagerModel(R.layout.practice_shadow_layer, R.string.title_shader_layer))
        pageModels.add(PagerModel(R.layout.practice_mask_filter, R.string.title_mask_filter))
        pageModels.add(PagerModel(R.layout.practice_fill_path, R.string.title_fill_path))
        pageModels.add(PagerModel(R.layout.practice_text_path, R.string.title_text_path))

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
