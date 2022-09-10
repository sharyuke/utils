package com.sharyuke.app.ui

import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.sharyuke.app.R

class ToolsRegexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools_regex)
        title = "正则表达式"
        val pattenView = findViewById<EditText>(R.id.tool_regex_patten)
        val inputView = findViewById<EditText>(R.id.tool_regex_input)
        val resultView = findViewById<TextView>(R.id.tool_regex_matches)

        inputView.doAfterTextChanged {
            val patten = pattenView.text.toString()
            val input = it.toString()
            if (!TextUtils.isEmpty(patten) && !TextUtils.isEmpty(input)) {
                resultView.text = Regex(patten).matchEntire(input)?.groupValues.toString()
            }
        }
    }
}