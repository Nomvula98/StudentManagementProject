package com.studentManagementSystem.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends User implements Serializable {

    @ManyToMany
    private List<Subject> subjects = new ArrayList<>();

    public Student() {
    }
}
