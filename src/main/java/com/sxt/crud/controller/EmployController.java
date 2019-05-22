package com.sxt.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxt.crud.bean.Employee;
import com.sxt.crud.service.EmployService;

@Controller
public class EmployController {
	
	@Autowired
	EmployService employService;
	
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		
		PageHelper.startPage(pn,5);
		List<Employee> emps=employService.getAllEmps();
		PageInfo page=new PageInfo(emps,5);
		model.addAttribute("pageInfo", page);
		return "list";
	}
	

}
