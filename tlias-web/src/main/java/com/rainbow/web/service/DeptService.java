package com.rainbow.web.service;

import com.rainbow.entity.Department;

import java.util.List;

public interface DeptService {
    List<Department> getAllDepartments();

    void delDeptById(Integer id);

    void add(Department dp);

    Department getDeptById(Integer id);

    void updateDept(Department dp);
}
