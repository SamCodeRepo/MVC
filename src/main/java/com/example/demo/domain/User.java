package com.example.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
//@ToString
//@EqualsAndHashCode
//@Getter
//@Setter
//@RequiredArgsConstructor
@Entity
//@NoArgsConstructor(force = true)
//@AllArgsConstructor
public class User {

    @Id
    private String username;
    //    @Setter(AccessLevel.PROTECTED)
    private String password;

//    private final String name;

}


