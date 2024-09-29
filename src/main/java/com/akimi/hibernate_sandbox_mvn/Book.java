package com.akimi.hibernate_sandbox_mvn;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private Book() {
    }

}
