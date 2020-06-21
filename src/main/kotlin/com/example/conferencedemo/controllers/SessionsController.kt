package com.example.conferencedemo.controllers

import com.example.conferencedemo.models.Session
import com.example.conferencedemo.repositories.SessionRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/sessions")
class SessionsController {

    @Autowired
    lateinit var sessionRepository : SessionRepository

    @GetMapping
    fun list() :  List<Session>{
        return sessionRepository.findAll()
    }

    @RequestMapping(value = ["{id}"], method = [RequestMethod.GET])
    fun get(@PathVariable id: Long) : Session{
        return sessionRepository.getOne(id)
    }

    @PostMapping
    fun create(@RequestBody session :Session) : Session{
        return sessionRepository.saveAndFlush(session)
    }

    @RequestMapping(value = ["{id}"], method = [RequestMethod.PUT])
    fun update(@PathVariable id: Long, @RequestBody session: Session): Session{
        val existingSession : Session = sessionRepository.getOne(id)
        BeanUtils.copyProperties(session, existingSession, "session_id")
        return sessionRepository.saveAndFlush(existingSession)
    }

    @DeleteMapping
    @RequestMapping("{id}")
    fun delete(@PathVariable id: Long){
        return sessionRepository.deleteById(id)
    }

}