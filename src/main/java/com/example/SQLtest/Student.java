package com.example.SQLtest;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // auto-generate getters and setters
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Uncomment if you want to auto-generate IDs
    private int id;
    @Column(name = "FullName")
    private String name;
    @Column(name = "Email")
    private String email;

    public Student() {
    }

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


}
