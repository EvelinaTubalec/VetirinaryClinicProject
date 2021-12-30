package com.leverx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "animals")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"notes"})
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @OneToMany(mappedBy="animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Note> notes;

    @ManyToOne
    @JoinColumn(name="owner_id", nullable=false)
    private Owner owner;

    public Animal(String name, Integer age, Owner owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }
}
