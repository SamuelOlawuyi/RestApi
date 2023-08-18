package com.dev.Springbootcrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String unit;
    private double grade;
}
