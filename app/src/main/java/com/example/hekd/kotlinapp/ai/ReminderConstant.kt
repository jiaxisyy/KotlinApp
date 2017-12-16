package com.example.hekd.kotlinapp.ai

/**
 * Created by hekd on 2017/12/13.
 */
class ReminderConstant {

    companion object {
        /**起床*/
        val TYPE_GETUP = "type_getup"
        /**作业*/
        val TYPE_WORK = "type_work"
        /**生日*/
        val TYPE_BIRTHDAY = "type_birthday"
        /**闹钟周期-每天*/
        val PERIOD_EVERYDAY = "每天"
        /**闹钟周期-每月*/
        val PERIOD_EVERYMONTH = "月"
        /**闹钟周期-仅一次*/
        val PERIOD_ONLYONCE = "一次"
        /**闹钟周期-周一-周日*/
        val PERIOD_WEEK = arrayListOf("周一", "周二", "周三", "周四", "周五", "周六", "周日")


    }
}