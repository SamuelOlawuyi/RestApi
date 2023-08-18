package com.dev.Springbootcrud.service;

import com.dev.Springbootcrud.entity.Subject;
import com.dev.Springbootcrud.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository repository;

    public Subject saveSubject(Subject subject){
        return repository.save(subject);

    }

    public List<Subject> saveSubjects(List<Subject> subjects){
        return repository.saveAll(subjects);
    }

    public Subject getSubjectById(Long id){
        return repository.findById(id).orElse(null);
    }
    public List<Subject> getSubjects(){
        return repository.findAll();
    }

    public Subject getSubjectByName(String name){
        return repository.findByName(name);
    }

    public Subject updateSubject(Subject subject){
        Subject existingSubject = repository.findById(subject.getId()).orElse(null);

        existingSubject.setName(subject.getName());
        existingSubject.setId(subject.getId());
        existingSubject.setGrade(existingSubject.getGrade());
        existingSubject.setUnit(existingSubject.getUnit());

        return repository.save(existingSubject);
    }

    public String deleteSubject(Long id){
        repository.deleteById(id);
        return "Subject deleted";
    }
}
