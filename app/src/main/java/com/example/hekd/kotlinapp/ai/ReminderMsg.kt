package com.example.hekd.kotlinapp.ai

import java.util.*

/**
 * Created by hekd on 2017/12/14.
 *@param type 闹钟提醒类型
 * @param period 周期
 * @param date 日期
 * @param time 时间
 * @param weeks 星期几
 * @param event 事件
 */
data class ReminderMsg(val type: String, val period: String, val date: Date, val time: String, val weeks: ArrayList<String>, val event: String) {



}