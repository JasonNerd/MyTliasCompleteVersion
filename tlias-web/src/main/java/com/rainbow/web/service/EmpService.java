package com.rainbow.web.service;


import com.rainbow.entity.Employee;
import com.rainbow.entity.PageBean;
import com.rainbow.entity.QueryArg;

import java.util.List;

public interface EmpService {
    PageBean queryPage(QueryArg arg);

    void delEmpByIds(List<Integer> ids);

    void addEmp(Employee emp);

    Employee getEmpById(Integer id);

    void updateEmp(Employee emp);

    Employee queryEmployee(Employee employee);
}
