package com.example.controller;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @RequestMapping("/add_std")
    public String add(@RequestBody Student student){
        studentRepository.save(student);
        return "Added Successfull";
    }
    @RequestMapping("/get_std")
    public List<Student> getStudentList(){
        return studentRepository.findAll();
    }
    @RequestMapping("/update_std")
    public String update(@RequestParam String name,@RequestParam Long id){
        Student student=studentRepository.getById(id);
        student.setName(name);
        studentRepository.save(student);
        return "Updated Successfully"+name;
    }
    @RequestMapping("/remove_std")
    public String remove(@RequestParam Long id){
        studentRepository.deleteById(id);
        return "Remove Successfull";
    }
}
