package com.example.controller;

import com.example.model.Doctor;
import com.example.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;
    @RequestMapping("/add_doc")
    public String addDoctor(@RequestBody Doctor doctor){
        doctorRepository.save(doctor);
        return "Added Successfull";
    }
    @RequestMapping("/get_doc")
    public List<Doctor> getDOctorList(){
        return doctorRepository.findAll();
    }
    @RequestMapping("/put_doc")
    public String updateDoctor(@RequestParam String name, @RequestParam Long id){
        Doctor doctor=doctorRepository.getById(id);
        doctor.setName(name);
        doctorRepository.save(doctor);
        return "Update Successfull:- "+name;
    }
    @RequestMapping("/delete_doc")
    public String deleteDoctor(@RequestParam Long id){
        doctorRepository.deleteById(id);
        return "Delete Successfull";
    }
}
