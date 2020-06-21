package com.example.conferencedemo.repositories

import com.example.conferencedemo.models.Session
import org.springframework.data.jpa.repository.JpaRepository

interface SessionRepository : JpaRepository<Session,Long> {
}