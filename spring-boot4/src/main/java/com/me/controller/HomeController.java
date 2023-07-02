package com.me.controller;

import com.me.repos.Department;
import com.me.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/database/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(homeService.findById(id), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Department>> getAllDept(){
        return new ResponseEntity<>(homeService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Department> save(@RequestBody Department d){
        return new ResponseEntity<>(homeService.save(d), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable(value = "id") int id){
        homeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
