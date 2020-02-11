package com.listenergao.lesson

import com.google.gson.reflect.TypeToken
import com.listenergao.base.http.EntityCallback
import com.listenergao.base.http.HttpClient
import com.listenergao.base.utils.Utils
import com.listenergao.lesson.entity.Lesson
import java.lang.reflect.Type

const val LESSON_PATH = "lessons"

class LessonPresenter {

    private lateinit var activity: LessonActivity

    constructor(activity: LessonActivity) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type: Type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons = entity
                activity.runOnUiThread {
                    activity.showResult(lessons)
                }

            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread {
                    Utils.toast(message)
                }
            }

        })
    }

    fun showPlayback() {
        activity.showResult(lessons.filter {
            it.state == Lesson.State.PLAYBACK
        })
    }

}