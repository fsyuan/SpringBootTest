package com.thy.service.impl;

import com.thy.dao.EmptMapper;
import com.thy.po.EmpT;
import com.thy.service.EmpTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
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
}
