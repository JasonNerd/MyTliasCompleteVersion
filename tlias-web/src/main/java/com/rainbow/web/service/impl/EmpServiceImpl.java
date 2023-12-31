package com.rainbow.web.service.impl;

import com.rainbow.web.dao.EmpMapper;
import com.rainbow.entity.Employee;
import com.rainbow.entity.PageBean;
import com.rainbow.entity.QueryArg;
import com.rainbow.web.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean queryPage(QueryArg arg) {
        PageHelper.startPage(arg.getPage(), arg.getPageSize());
        List<Employee> employees = empMapper.queryPage(arg);
        Page<Employee> employeePage = (Page<Employee>) employees;
        return new PageBean((int)employeePage.getTotal(), employeePage.getResult());
    }

    @Override
    public void delEmpByIds(List<Integer> ids) {
        empMapper.delEmpByIds(ids);
    }

    @Override
    public void addEmp(Employee emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmp(emp);
    }

    @Override
    public Employee getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }

    @Override
    public void updateEmp(Employee emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
    }

    @Override
    public Employee queryEmployee(Employee employee) {
        return empMapper.queryEmployee(employee);
    }
}
