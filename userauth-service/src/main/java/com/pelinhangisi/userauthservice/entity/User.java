package com.pelinhangisi.userauthservice.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "created_time")
    private LocalDateTime createTime;


}
