package com.example.conferencedemo.repositories

import com.example.conferencedemo.models.Session
import com.example.conferencedemo.models.Speaker
import org.springframework.data.jpa.repository.JpaRepository

interface SpeakerRepository : JpaRepository<Speaker,Long> {
    fun querySpeakerBySessions(id: Long) : List<Speaker>
}