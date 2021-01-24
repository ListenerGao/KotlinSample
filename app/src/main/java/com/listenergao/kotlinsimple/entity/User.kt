package com.listenergao.kotlinsimple.entity

data class User constructor(var username: String?, var password: String?, var code: String?) {

    /**
     * 次级构造函数，直接在类中写的构造函数为主构造函数，一个类中只允许一个主构造函数，
     * 可以有多个次级构造函数
     *
     */
    constructor() : this(null, null, null)

}