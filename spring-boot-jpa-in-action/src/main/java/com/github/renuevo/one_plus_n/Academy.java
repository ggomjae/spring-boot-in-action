package com.github.renuevo.one_plus_n;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Academy {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade =  CascadeType.ALL)
    @JoinColumn(name="academy_id")
    private Set<Subject> subjectSet = new LinkedHashSet<>();

    @Builder
    public Academy(String name, Set<Subject> subjects) {
        this.name = name;
        if(subjects != null) this.subjectSet = subjects;
    }

    public void addSubject(Subject subject){
        this.subjectSet.add(subject);
        subject.updateAcademy(this);
    }

}
