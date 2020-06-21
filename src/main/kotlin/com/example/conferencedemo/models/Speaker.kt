package com.example.conferencedemo.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Type
import javax.persistence.*

@Entity(name = "speakers")
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
class Speaker {
    /**
     * @return the speakerId
     */
    /**
     * @param speakerId the speakerId to set
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speaker_id")
    var speakerId: Long? = null
    /**
     * @return the firstName
     */
    /**
     * @param firstName the firstName to set
     */
    @Column(name = "first_name")
    var firstName: String? = null
    /**
     * @return the lastName
     */
    /**
     * @param lastName the lastName to set
     */
    @Column(name = "last_name")
    var lastName: String? = null
    /**
     * @return the title
     */
    /**
     * @param title the title to set
     */
    @Column(name = "title")
    var title: String? = null
    /**
     * @return the company
     */
    /**
     * @param company the company to set
     */
    @Column(name = "company")
    var company: String? = null
    /**
     * @return the speakerBio
     */
    /**
     * @param speakerBio the speakerBio to set
     */
    @Column(name = "speaker_bio")
    var speakerBio: String? = null
    /**
     * @return the speakerPhoto
     */
    /**
     * @param speakerPhoto the speakerPhoto to set
     */
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "speaker_photo")
    var speakerPhoto: ByteArray? = null
    /**
     * @return the sessions
     */
    /**
     * @param sessions the sessions to set
     */
    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    var sessions: List<Session>? = null

//    @ManyToMany
//    @JoinTable(name = "session_speakers", joinColumns = [JoinColumn(name = "session_id")], inverseJoinColumns = [JoinColumn(name = "speaker_id")])
//    var sessions : List<Session>? = null


}