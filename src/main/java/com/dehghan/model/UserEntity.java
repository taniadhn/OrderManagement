package com.dehghan.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    Long id;

    @Column(name = "USER_NAME")
    String username;

    @Column(name = "PASSWORD")
    String password;

}
