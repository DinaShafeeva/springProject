package ru.itis.first.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="MY_CLASS")
public class MyClass {
    @Column(name="surname")
    private String name;
    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
