package com.listenergao.lesson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.reflect.TypeToken;
import com.listenergao.base.http.EntityCallback;
import com.listenergao.base.http.HttpClient;
import com.listenergao.base.utils.Utils;
import com.listenergao.lesson.entity.Lesson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class LessonPresenter {
    private static final String LESSON_PATH = "lessons";

    private LessonActivity activity;

    LessonPresenter(LessonActivity activity) {
        this.activity = activity;
    }

    private List<Lesson> lessons = new ArrayList<>();

    private final Type type = new TypeToken<List<Lesson>>() {
    }.getType();

    void fetchData() {
        HttpClient.INSTANCE.get(LESSON_PATH, type, new EntityCallback<List<Lesson>>() {
            @Override
            public void onSuccess(@NonNull final List<Lesson> lessons) {
                LessonPresenter.this.lessons = lessons;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        activity.showResult(lessons);
                    }
                });
            }

            @Override
            public void onFailure(@Nullable final String message) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Utils.toast(message);
                    }
                });
            }
        });
    }

    void showPlayback() {
        List<Lesson> playbackLessons = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getState() == Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson);
            }
        }
        activity.showResult(playbackLessons);
    }
}