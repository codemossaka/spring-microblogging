package com.godsonpeya.microblog.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

/**
 * l'entite publication (post)
 */
@Entity
@Table(name = "publication")
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?=null,
    @NotBlank(message = "Le contenu de la publication ne peut pas etre vide")
    var content: String,
    @Column(name="user_id")
    @Pattern(regexp = "^\\d")
    var userId: Long,
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    @JsonIgnore
    val user : User?=null,
    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,
)