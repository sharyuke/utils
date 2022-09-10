package com.sharyuke.app.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.sharyuke.app.R
import com.sharyuke.utils.permission.permissionsRequest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        title = "权限"
        findViewById<Button>(R.id.permission_btn).setOnClickListener {
            findViewById<TextView>(R.id.permission_txt).apply {
                append("开始请求权限\n")
                permissionsRequest(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    .onEach {
                        append("权限请求结果:${it.first().isGranted}，是否能再次请求权限：${it.first().shouldShowRational}\n")
                        // 如果不能再次请求选项，请求权限UI就没有弹窗，直接返回false
                    }
                    .launchIn(lifecycleScope)
            }
        }
    }
}