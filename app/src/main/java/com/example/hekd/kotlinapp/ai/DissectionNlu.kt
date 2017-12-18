package com.example.hekd.kotlinapp.ai

import com.google.gson.Gson
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by hekd on 2017/12/13.
 * 解剖语义
 * 解析优先级:提醒类型>周期>日期>时间>事件
 *
 */
class DissectionNlu {


    companion object {
        /**起床*/
        val STR_GETUP = "起床"

        /**默认意图*/
        val STR_EVENT = "作业"

        fun dissection(s: String) {
            val jsonObject = JSONObject(s)


            //判断提醒类型
            when {
            //起床
                s.contains(STR_GETUP) -> {
                    val msg = pteDissection(s, ReminderConstant.TYPE_GETUP)
                    println(msg.toString())
                }


            }


        }

        /**
         * 周期,时间,事件解析
         * @param s 完整语句
         *
         */
        private fun pteDissection(s: String, type: Int): ReminderMsg {
            /**周几*/
            var weekList = arrayListOf<Int>()
            val gson = Gson()
            val fromJson = gson.fromJson(s, ReminderBean::class.java)
            try {
                val objectBean = fromJson.merged_res!!.semantic_form!!.results!![0].`object`
                /**详细语句*/
                val raw_text = fromJson.merged_res!!.semantic_form!!.raw_text
                /**意图*/
                val _event = objectBean!!._event
                /**大体时间*/
                val _time = objectBean._time
                /**具体时间*/
                var time = objectBean.time
                /**具体日期*/
                var date = objectBean.date
                /**例如周一至周五*/
                val fromTo = "至"
                /**例如周一至周五*/
                val fromTo2 = "到"
                /**例如周一至周五中的"周一"*/
                var s1 = ""
                /**例如周一至周五中的"周五"*/
                var s2 = ""
                /**具体周期*/
                var period = 0
                /**周次个数,例如:有周一则次数+1*/
                var weekCount = 0

                when {// 周期
                    _time!!.contains(ReminderConstant.PERIOD_EVERYDAY.toString()) -> {
                        //每天
                        period = ReminderConstant.PERIOD_EVERYDAY
                    }
                    _time.contains(ReminderConstant.PERIOD_EVERYMONTH.toString()) -> {
                        //每月
                        period = ReminderConstant.PERIOD_EVERYMONTH
                    }

                    _time.contains(ReminderConstant.PERIOD_WEEK[0]) ||
                            _time.contains(ReminderConstant.PERIOD_WEEK[1]) ||
                            _time.contains(ReminderConstant.PERIOD_WEEK[2]) ||
                            _time.contains(ReminderConstant.PERIOD_WEEK[3]) ||
                            _time.contains(ReminderConstant.PERIOD_WEEK[4]) ||
                            _time.contains(ReminderConstant.PERIOD_WEEK[5]) ||
                            _time.contains(ReminderConstant.PERIOD_WEEK[6]) -> {
                        //周几
                        for (i in 0 until ReminderConstant.PERIOD_WEEK.size) {
                            if (raw_text!!.contains(ReminderConstant.PERIOD_WEEK[i])) {
                                weekList.add(i)
                                weekCount++
                            }
                        }
                        //连续周几,例如周一至周五
                        if (weekCount == 2 && raw_text!!.contains(fromTo)) {
                            //获取"至"在其中的角标,截取前面和后面的周期
                            val indexOf = raw_text.indexOf(fromTo)
                            //截取周一
                            s1 = raw_text.substring(indexOf - 2, indexOf)
                            s2 = raw_text.substring(indexOf + 1, indexOf + 3)
                            println("========${s1}至$s2============")
                        }
                        if (weekCount == 2 && raw_text!!.contains(fromTo2)) {
                            //获取"至"在其中的角标,截取前面和后面的周期
                            val indexOf = raw_text.indexOf(fromTo2)
                            //截取周一
                            s1 = raw_text.substring(indexOf - 2, indexOf)
                            s2 = raw_text.substring(indexOf + 1, indexOf + 3)
                            println("========${s1}到$s2============")
                        }
                        period = ReminderConstant.PERIOD_USER_DEFINED
                    }
                    else -> {
                        //仅一次
                        period = ReminderConstant.PERIOD_ONLYONCE
                    }

                }
                println("==========周期->$period=============")
                println("==========周几->$weekList=============")
                println("==========几个数->$weekCount=============")

                if (date == null || time == null) {
                    val (nowDate, nowTime) = getTodayTime()
                    date = nowDate
                    time=nowTime
                }
                return ReminderMsg(type, period, date, time, weekList, _event!!)
            } catch (e: Exception) {
                /**
                 * 解析错误
                 * IndexOutOfBoundsException: Invalid index 0, size is 0
                 */
                //周几
                (0 until ReminderConstant.PERIOD_WEEK.size)
                        .filter { s.contains(ReminderConstant.PERIOD_WEEK[it]) }
                        .forEach { weekList.add(it) }
                println("==========周期对应的数->$weekList=============")
                e.printStackTrace()
                val (nowDate, nowTime) = getTodayTime()
                return ReminderMsg(ReminderConstant.TYPE_GETUP, ReminderConstant.PERIOD_ONLYONCE, nowDate, nowTime, weekList, STR_EVENT)
            }
        }

        private fun getTodayTime(): Pair<String, String> {
            val dateFormatDate = SimpleDateFormat("yyyy-MM-dd")
            val dateFormatTime = SimpleDateFormat("HH:mm")
            val sysDate = Date(System.currentTimeMillis())
            val nowDate = dateFormatDate.format(sysDate)
            val nowTime = dateFormatTime.format(sysDate)
            return Pair(nowDate, nowTime)
        }

    }
}