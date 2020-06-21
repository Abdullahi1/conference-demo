package com.example.conferencedemo.controllers

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @Value(value = "\${app.version}")
    private lateinit var appVersion : String

    @RequestMapping(value = ["/"] , method = [RequestMethod.GET])
    fun getStatus() : Map<String, String>{
        val map = HashMap<String, String>()
        map["version"] = appVersion
        return map
    }
}