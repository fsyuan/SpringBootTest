package com.thy.dao;

import com.thy.po.EmpT;

import java.util.List;
import java.util.Map;

public interface EmptMapper {

    public List<EmpT> queryEmpTList();//po

    public List<Map<String, Object>> queryEmpTSalLevel();//类似VO

    public void insertEmp(EmpT empT);

    public void deleteDeptno(Map map);
}
