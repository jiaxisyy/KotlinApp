package com.example.hekd.kotlinapp.ai

import com.google.gson.Gson
import org.json.JSONObject

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

        fun dissection(s: String){
            val jsonObject = JSONObject(s)

            val gson = Gson()

            //判断提醒类型
            when {
            //起床
                s.contains(STR_GETUP) -> {

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
                        val time = objectBean.time
                        /**具体日期*/
                        val date = objectBean.date

                        /**具体周期*/
                        var period = ""
                        /**周次个数,例如:有周一则次数+1*/
                        var weekCount = 0
                        /**周几*/
                        var weekList = arrayListOf<Int>()
                        when {// 周期
                            _time!!.contains(ReminderConstant.PERIOD_EVERYDAY) -> {
                                //每天
                                period = ReminderConstant.PERIOD_EVERYDAY
                            }
                            _time.contains(ReminderConstant.PERIOD_EVERYMONTH) -> {
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



                            }


                            else -> {
                                //仅一次
                                period = ReminderConstant.PERIOD_ONLYONCE
                            }

                        }
                        println("==========周期->$period=============")
                        println("==========周几->$weekList=============")
                        println("==========几个数->$weekCount=============")
                    } catch (e: Exception) {
                        /**
                         * 解析错误
                         * IndexOutOfBoundsException: Invalid index 0, size is 0
                         */
                        e.printStackTrace()
                    }

                }


            }


        }

    }
}