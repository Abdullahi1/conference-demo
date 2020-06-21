package com.example.conferencedemo.controllers

import com.example.conferencedemo.models.Session
import com.example.conferencedemo.models.Speaker
import com.example.conferencedemo.repositories.SessionRepository
import com.example.conferencedemo.repositories.SpeakerRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/speakers")
class SpeakersController {

    @Autowired
    lateinit var speakerRepository: SpeakerRepository

    @GetMapping
    fun list() :  List<Speaker>{
        return speakerRepository.findAll()
    }

    @RequestMapping(value = ["{id}"], method = [RequestMethod.GET])
    fun get(@PathVariable id: Long) : Speaker {
        return speakerRepository.getOne(id)
    }

    @PostMapping
    fun create(@RequestBody speaker : Speaker) : Speaker {
        return speakerRepository.saveAndFlush(speaker)
    }

    @RequestMapping(value = ["{id}"], method = [RequestMethod.PUT])
    fun update(@PathVariable id: Long, @RequestBody session: Speaker): Speaker {
        val existingSession : Speaker = speakerRepository.getOne(id)
        BeanUtils.copyProperties(session, existingSession, "speaker_id")
        return speakerRepository.saveAndFlush(existingSession)
    }

    @DeleteMapping
    @RequestMapping("{id}")
    fun delete(@PathVariable id: Long){
        return speakerRepository.deleteById(id)
    }

//    fun getSpeakerBySessionId(@Query)
}