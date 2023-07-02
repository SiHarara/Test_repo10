package com.me.service;

import com.me.error.ConflictException;
import com.me.error.NotFoundException;
import com.me.repos.Department;
import com.me.repos.RepositoryDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HomeService {

    @Autowired
    RepositoryDepartment repositoryDepartment;

    public Department findById(int id){
        try {
            return repositoryDepartment.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new NotFoundException(String.format("no recorde for this id {%s} in our database", id));
        }
    }

    public List<Department> findAll(){
        return repositoryDepartment.findAll();
    }

    public void deleteById(int i){
        repositoryDepartment.deleteById(i);
    }

    public Department save(Department d){
        if (repositoryDepartment.findByName(d.getName()) != null){
            throw new ConflictException(String.format("this name {%s} is already exists in database", d.getName()));
        }
        return repositoryDepartment.save(d);
    }



}
