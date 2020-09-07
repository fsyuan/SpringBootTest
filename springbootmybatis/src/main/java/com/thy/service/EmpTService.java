package com.thy.service;

import com.thy.po.EmpT;

import java.util.List;
import java.util.Map;

public interface EmpTService {
    List<EmpT> queryEmpT();
    List<Map<String, Object>> queryEmpTSalLevel();
}
