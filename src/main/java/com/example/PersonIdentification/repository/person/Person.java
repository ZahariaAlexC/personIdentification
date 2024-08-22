package com.example.PersonIdentification.repository.person;

import com.example.PersonIdentification.repository.address.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "person")
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String block;
    private String scale;
    private String apartment;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

}
