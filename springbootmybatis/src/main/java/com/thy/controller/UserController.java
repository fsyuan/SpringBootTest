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

    /**
     * 返回实体,可能为null，返回的是一个json对象
     * 大萨达撒
     * @return
     */
    @RequestMapping("/emp")
    @ResponseBody
    public List<EmpT> queryEmpT() {
        List<EmpT> empTS = empTService.queryEmpT();
        return empTS;
    }

    /**
     * 返回Linux size为0
     *
     * @return
     */
    @RequestMapping("/empSal")
    @ResponseBody
    public List<Map<String, Object>> queryEmpTSal() {
        return empTService.queryEmpTSalLevel();
    }

    /**
     * 返回Map,只返回单行json 不是一个数组
     *
     * @return
     */
    @RequestMapping("/empSalMap")
    @ResponseBody
    public Map<String, Object> queryEmpTSalMap() {
        return empTService.queryEmpTSalLevelMap();
    }

    @RequestMapping("/insedddrtsss")
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





