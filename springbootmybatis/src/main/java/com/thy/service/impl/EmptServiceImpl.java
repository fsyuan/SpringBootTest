package com.thy.service.impl;

import com.thy.dao.EmptMapper;
import com.thy.po.EmpT;
import com.thy.service.EmpTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EmptServiceImpl implements EmpTService {

    @Autowired
    private EmptMapper emptMapper;

    @Override
    public List<EmpT> queryEmpT() {
        return emptMapper.queryEmpTList();

    }

    @Override
    public List<Map<String, Object>> queryEmpTSalLevel() {
        return emptMapper.queryEmpTSalLevel();
    }


    public Map<String, Object> queryEmpTSalLevelMap() {
        return emptMapper.queryEmpTSalLevelMap();
    }

    @Override
    public void insertEmp() {
        EmpT empT1 = new EmpT();
        empT1.setEmpno("12");
        empT1.setEname("12");
        empT1.setJob("12");
        empT1.setDeptno("12");
        empT1.setMgr("12");
        empT1.setHiredate("2020-01-01");
        empT1.setSal("12");
        empT1.setComm("12");
        emptMapper.insertEmp(empT1);
        deleteDeptno();
    }

    @Override
    public void deleteDeptno() {
        Map map = new HashMap();
        map.put("deptno", "10");
        emptMapper.deleteDeptno(map);
        //开启事物否则发生异常不会回滚
        int a = 1 / 0;
    }
}
