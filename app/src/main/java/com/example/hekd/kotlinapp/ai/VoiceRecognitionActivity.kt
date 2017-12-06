package com.example.hekd.kotlinapp.ai

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.speech.RecognitionListener
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.baidu.speech.EventListener
import com.baidu.speech.EventManager
import com.baidu.speech.EventManagerFactory
import com.baidu.speech.asr.SpeechConstant
import com.example.hekd.kotlinapp.R
import kotlinx.android.synthetic.main.activity_voice.*
import org.json.JSONObject


/**
 * Created by hekd on 2017/12/5.
 */
class VoiceRecognitionActivity : Activity(), View.OnClickListener, EventListener {
    var eventManager: EventManager? = null
    var dialogReminder: TextView? = null


    override fun onEvent(name: String?, p1: String?, p2: ByteArray?, p3: Int, p4: Int) {


        if (name.equals(SpeechConstant.CALLBACK_EVENT_ASR_READY)) {
            // 引擎就绪，可以说话，一般在收到此事件后通过UI通知用户可以说话了
            initDialog()
        }
        if (name.equals(SpeechConstant.CALLBACK_EVENT_ASR_FINISH)) {
            // 识别结束
            println("识别结束++++++++++++++++++++++++")
        }


        if (p1 != null && p1.contains("result_type")) {
            val jsonObject = JSONObject(p1)
            val resultType = jsonObject.get("result_type")
            if (resultType == "final_result") {
                println("=============最终===============" + p1)
                dialogReminder!!.text = jsonObject.get("best_result").toString()
            }
        }
        // ... 支持的输出事件和事件支持的事件参数见“输入和输出参数”一节

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            btn_voiceStart.id -> {
                // asr params(反馈请带上此行日志):{"accept-audio-data":false,"disable-punctuation":false,"accept-audio-volume":true,"pid":1736}
                // 其中{"accept-audio-data":false,"disable-punctuation":false,"accept-audio-volume":true,"pid":1736}为ASR_START 事件的参数
                val json = "{\"accept-audio-data\":false,\"disable-punctuation\":false,\"accept-audio-volume\":true,\"pid\":1536}"
                eventManager!!.send(SpeechConstant.ASR_START, json, null, 0, 0)
            }
        }
    }


    val handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            println("============================")
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice)
        initListener()
        initBaiDuSDK()
    }

    /**
     *
     * 语音初始化
     */
    private fun initBaiDuSDK() {
        eventManager = EventManagerFactory.create(this, "asr")
        eventManager!!.registerListener(this)
    }

    /**
     *
     * 监听注册
     */
    private fun initListener() {
        btn_voiceStart.setOnClickListener(this)
    }

    /**
     * 初始化语音设置弹窗提示界面
     */
    private fun initDialog() {
        val inflate = LayoutInflater.from(this).inflate(R.layout.dialog_voice_reminder, null, false)
        val dialog = Dialog(this, R.style.input_dialog)
        //返回键失效
        //dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        dialog.setContentView(inflate, layoutParams)
        dialogReminder = inflate.findViewById(R.id.tv_dialog_reminder) as TextView?
        if (!dialog.isShowing) {
            dialog.show()
        }
    }
}