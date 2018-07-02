package com.oreillyauto.projecttemplate.javaLabs.lab1;

import java.math.BigDecimal;
import java.util.List;

public class Payroll {

	public BigDecimal calculatePayroll(List<OreillyEmployee> employeeList) {
		BigDecimal sum = new BigDecimal("0.0");
		for (OreillyEmployee employee : employeeList) {
			sum = sum.add(employee.getSalary());
		}
		return sum;
	}
	

	public void happyBirthday(OreillyEmployee employee) {
		employee.setAge(employee.getAge()+1);
		
	}


	public String calculatePayroll(List<OreillyEmployee> employeeList, String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
