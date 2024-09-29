package com.akimi.hibernate_sandbox_mvn;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    public Long id;
    public String name;

    protected Book() {
    }


}
