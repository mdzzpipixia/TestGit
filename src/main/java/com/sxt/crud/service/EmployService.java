package com.sxt.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.crud.bean.Employee;
import com.sxt.crud.dao.EmployeeMapper;

@Service
public class EmployService {
	@Autowired
	EmployeeMapper employeeMapper;

	public List<Employee> getAllEmps() {
		return employeeMapper.selectByExampleWithDept(null);
	}

}
