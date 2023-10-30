package com.rainbow.web.controller;

import com.rainbow.entity.Employee;
import com.rainbow.entity.PageBean;
import com.rainbow.entity.QueryArg;
import com.rainbow.entity.Result;
import com.rainbow.web.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EmpController {
    @Autowired
    private EmpService service;

    @GetMapping("/emps")
    public Result queryPage(QueryArg arg){
        log.info("分页请求查询, 参数为: {}", arg);
        PageBean pageData = service.queryPage(arg);
        return Result.success(pageData);
    }

//    批量的员工删除, 请求示例: `/emps/1,2,3`
    @DeleteMapping("/emps/{ids}")
    public Result delEmpByIds(@PathVariable List<Integer> ids){
        log.info("批量删除员工, ids={}", ids);
        service.delEmpByIds(ids);
        return Result.success();
    }
//      新增员工
    @PostMapping("/emps")
    public Result addEmp(@RequestBody Employee emp){
        log.info("新增员工: {}", emp);
        service.addEmp(emp);
        return Result.success();
    }
//      依据 id 查询员工
    @GetMapping("/emps/{id}")
    public Result getEmpById(@PathVariable Integer id){
        log.info("依据 id 查询员工信息: {}", id);
        Employee emp = service.getEmpById(id);
        return Result.success(emp);
    }

    @PutMapping("/emps")
    public Result updateEmp(@RequestBody Employee emp){
        log.info("修改员工信息: {}", emp);
        service.updateEmp(emp);
        return Result.success();
    }
}
