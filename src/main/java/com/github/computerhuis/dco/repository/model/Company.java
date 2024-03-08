package com.github.computerhuis.dco.repository.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@DynamicUpdate
@DynamicInsert
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String postalCode;
    private String street;
    private Integer houseNumber;
    private String houseNumberAddition;
    private String city;
    private String kvkNumber;
    private String btwNumber;
    private String website;
    private String comments;
    private LocalDateTime registered;
    private LocalDateTime unregistered;
    private String msaccess;
}
