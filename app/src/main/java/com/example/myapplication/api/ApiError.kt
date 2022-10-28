package com.example.myapplication.api


/**
 * @author Abhishek Rana
 * @since 8/05/21
 * */
class ApiError constructor(override val message:String) : Exception() {

}