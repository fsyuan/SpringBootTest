package com.thy.controller;

import com.thy.po.EmpT;
import com.thy.service.EmpTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EmpTService empTService;

    @RequestMapping("/emp")
    @ResponseBody
    public List<EmpT> queryEmpT() {
        List<EmpT> empTS = empTService.queryEmpT();
        return empTS;
    }

    @RequestMapping("/empSal")
    @ResponseBody
    public List<Map<String, Object>> queryEmpTSal() {
        return empTService.queryEmpTSalLevel();
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insertEmp() {
        empTService.insertEmp();
        return "插入成功";
    }

    @RequestMapping("/deptno")
    @ResponseBody
    public String deleteDeptno() {
        empTService.deleteDeptno();
        return "删除成功";
    }
}





