package com.springboot.jpa.mappings.repository;

import com.springboot.jpa.mappings.entity.Students;

public interface RepoInterface {
    void save(Students student);
    Students findById(int id);
    void deleteById(int id);
}
