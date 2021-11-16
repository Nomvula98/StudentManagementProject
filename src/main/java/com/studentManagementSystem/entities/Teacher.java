package com.studentManagementSystem.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher extends User implements Serializable {
    @ManyToMany
    private List<Subject> subjects = new ArrayList<>();

    public Teacher() {
    }
}
