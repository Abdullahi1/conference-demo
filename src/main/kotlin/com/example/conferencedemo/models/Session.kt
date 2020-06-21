package com.example.conferencedemo.models

import com.example.conferencedemo.models.Speaker
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity(name = "sessions")
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
class Session {
    /**
     * @return the sessionId
     */
    /**
     * @param sessionId the sessionId to set
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    var sessionId: Long? = null
    /**
     * @return the sessionName
     */
    /**
     * @param sessionName the sessionName to set
     */
    @Column(name = "session_name")
    var sessionName: String? = null
    /**
     * @return the sessionDescription
     */
    /**
     * @param sessionDescription the sessionDescription to set
     */
    @Column(name = "session_description")
    var sessionDescription: String? = null
    /**
     * @return the sessionLength
     */
    /**
     * @param sessionLength the sessionLength to set
     */
    @Column(name = "session_length")
    var sessionLength: Int? = null
    /**
     * @return the speakers
     */
    /**
     * @param speakers the speakers to set
     */
    @ManyToMany
    @JoinTable(name = "session_speakers", joinColumns = [JoinColumn(name = "session_id")], inverseJoinColumns = [JoinColumn(name = "speaker_id")])
    var speakers: List<Speaker>? = null

//    @JsonIgnore
//    @ManyToMany(mappedBy = "sessions")
//    var speakers: List<Speaker>? = null
}