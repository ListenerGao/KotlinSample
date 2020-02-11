/**
 * 使用注解，定义文件中函数使用的类名
 */
@file:JvmName("DpUtil")

package com.listenergao.base.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.listenergao.base.BaseApplication

private val displayMetrics = Resources.getSystem().displayMetrics
/**
 * kotlin中，文件中可以直接定义函数
 */
fun dp2px(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
}

object Utils {

    fun toast(string: String?) {
        toast(string, Toast.LENGTH_SHORT)
    }

    fun toast(string: String?, duration: Int) {
        Toast.makeText(BaseApplication.currentApplication(), string, duration).show()
    }
}