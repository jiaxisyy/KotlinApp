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
class PracticeDraw4 : AppCompatActivity() {
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
        pageModels.add(PageModel(R.string.title_clip_rect, R.layout.practice_clip_rect))
        pageModels.add(PageModel(R.string.title_clip_path, R.layout.practice_clip_path))
        pageModels.add(PageModel(R.string.title_translate, R.layout.practice_translate))
        pageModels.add(PageModel(R.string.title_scale, R.layout.practice_scale))
        pageModels.add(PageModel(R.string.title_rotate, R.layout.practice_rotate))
        pageModels.add(PageModel(R.string.title_skew, R.layout.practice_skew))
        pageModels.add(PageModel(R.string.title_matrix_translate, R.layout.practice_matrix_translate))
        pageModels.add(PageModel(R.string.title_matrix_scale, R.layout.practice_matrix_scale))
        pageModels.add(PageModel(R.string.title_matrix_rotate, R.layout.practice_matrix_rotate))
        pageModels.add(PageModel(R.string.title_matrix_skew, R.layout.practice_matrix_skew))
        pageModels.add(PageModel(R.string.title_camera_rotate, R.layout.practice_camera_rotate))
        pageModels.add(PageModel(R.string.title_camera_rotate_fixed, R.layout.practice_measure_text2))
        pageModels.add(PageModel(R.string.title_camera_rotate_hitting_face, R.layout.practice_camera_rotate_hitting_face))
        pageModels.add(PageModel(R.string.title_flipboard, R.layout.practice_flipboard))

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
