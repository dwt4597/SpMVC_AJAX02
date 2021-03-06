package com.biz.ajax0001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.ajax0001.mapper.DeptMapper;
import com.biz.ajax0001.model.DeptVO;

@Service
public class DeptService {

	@Autowired
	DeptMapper dMapper;
	
	public List<DeptVO> getDeptList() {
		return dMapper.selectAll();
	}

	public DeptVO getDept(String d_code) {
		DeptVO deptVO = dMapper.findByDCode(d_code);
		return deptVO;
	}
	
}