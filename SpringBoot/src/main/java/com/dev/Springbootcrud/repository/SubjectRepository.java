   package com.dev.Springbootcrud.repository;

import com.dev.Springbootcrud.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByName(String name);
}
