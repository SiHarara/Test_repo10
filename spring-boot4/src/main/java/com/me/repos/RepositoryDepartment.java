package com.me.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDepartment extends JpaRepository<Department, Integer> {

    public Department findByName(String name);

}
