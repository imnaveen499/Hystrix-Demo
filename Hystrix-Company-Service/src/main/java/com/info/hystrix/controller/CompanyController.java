package com.info.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.info.hystrix.serviceDelegate.EmployeeServiceDelegate;


@RestController
public class CompanyController {

	
	@Autowired
	EmployeeServiceDelegate employeeServiceDelegate;
	
	
	
	@RequestMapping(value = "/getCompanyDetails/{companyName}", method = RequestMethod.GET)
	public String getEmployee(@PathVariable String companyName) {
		System.out.println("Going to call Employee service to get data!");
		return employeeServiceDelegate.callEmployeeServiceAndGetData(companyName);
	}
	
	
	
	
}
