package com.sxt.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxt.crud.bean.Department;
import com.sxt.crud.bean.Employee;
import com.sxt.crud.dao.DepartmentMapper;
import com.sxt.crud.dao.EmployeeMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	

	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void TestCrud(){
		/*departmentMapper.insertSelective(new Department(null,"开发部"));
		departmentMapper.insertSelective(new Department(null,"测试部"));
		departmentMapper.insertSelective(new Department(null,"运维部"));
		*/
		//employeeMapper.insertSelective(new Employee(null,"tom","M","tom@163.com",1));
		
		
		EmployeeMapper employeeMapper2 = sqlSession.getMapper(EmployeeMapper.class); 
		for (int i = 0; i < 1000; i++) {
			String uuid=UUID.randomUUID().toString().substring(0, 5)+i;
			employeeMapper2.insertSelective(new Employee(null,uuid,"M",uuid+"tom@163.com",1));
		}
		
	}
	
	
	
	
}
