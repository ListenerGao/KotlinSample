package com.listenergao.kotlinsample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.listenergao.base.utils.CacheUtils
import com.listenergao.base.utils.Utils
import com.listenergao.kotlinsample.entity.User
import com.listenergao.kotlinsample.widget.CodeView
import com.listenergao.lesson.LessonActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val usernameKey: String = "username"
    private val passwordKey = "password"

    private lateinit var et_username: EditText
    private lateinit var et_password: EditText
    private lateinit var et_code: EditText
    private lateinit var codeView: CodeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)

        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))

        findViewById<Button>(R.id.btn_login).setOnClickListener(this)

        codeView = findViewById(R.id.code_view)
        codeView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v is CodeView) {
//            val codeView = v as CodeView
            v.updateCode()
        } else if (v is Button) {
            login()
        }

    }

    private fun login() {

        val username = et_username.text.toString()
        val password = et_password.text.toString()
        val code = et_code.text.toString()

        val user = User(username, password, code)
        if (verity(user)) {
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey, password)

            startActivity(Intent(this, LessonActivity::class.java))

        }
    }

    private fun verity(user: User): Boolean {
        // user.username != null && user.username.length < 4 编译报错，多线程中是不安全的

        if (user.username?.length ?: 0 < 4) {
            Utils.toast("用户名不合法")
            return false
        }

        if (user.password?.length ?: 0 < 4) {
            Utils.toast("密码不合法")
            return false
        }

        if (codeView.getCurrentCode() != user.code) {
            Utils.toast("验证码输入错误")
            return false
        }

        return true
    }
}