package com.dev.Springbootcrud.controller;

import com.dev.Springbootcrud.entity.Subject;
import com.dev.Springbootcrud.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectControl {
    @Autowired
    private SubjectService service;

    @PostMapping("/addSubject")
    public Subject addSubject(@RequestBody Subject subject){
        return service.saveSubject(subject);
    }

    @PostMapping("/addSubjects")
    public List<Subject> addSubject(@RequestBody List<Subject> subjects){
        return service.saveSubjects(subjects);
    }

    @GetMapping("/subject/{id}")
    public Subject findSubjectById(@PathVariable Long id){
        return service.getSubjectById(id);
    }

    @GetMapping("/subject")
    public List<Subject> findAllSubject(){
        return service.getSubjects();
    }
    @GetMapping("/subjectByName/{name}")
    public Subject findSubjectByName(@PathVariable String name){
        return service.getSubjectByName(name);
    }
    @PutMapping("/update")
    public Subject updateSubject(@RequestBody Subject subject){
        return service.updateSubject(subject);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSubject(@PathVariable Long id){
        return service.deleteSubject(id);
    }
}
