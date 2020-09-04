package com.thy.dao;

import com.thy.po.EmpT;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmptMapper {

    public List<EmpT> queryEmpTList();

    public List<Map<String, Object>> queryEmpTSalLevel();


}