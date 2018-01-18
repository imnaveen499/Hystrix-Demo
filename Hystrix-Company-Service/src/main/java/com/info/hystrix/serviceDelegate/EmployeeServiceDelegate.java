package com.info.hystrix.serviceDelegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeServiceDelegate {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@HystrixCommand(fallbackMethod = "callEmployeeServiceAndGetData_Fallback")
	public String callEmployeeServiceAndGetData(String companyName) {
		System.out.println("Getting Employee details for " + companyName);
		String response = restTemplate.exchange("http://localhost:8888/getEmployeeDetailsForCompany/{companyName}",
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}, companyName).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Company Name -  " + companyName + " :::  Employee Details " + response + " -  "
				+ new Date();
	}

	@SuppressWarnings("unused")
	private String callEmployeeServiceAndGetData_Fallback(String schoolname) {
		System.out.println("Employee Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Employee Service at this moment. Service will be back shortly - "
				+ new Date();
	}

}
