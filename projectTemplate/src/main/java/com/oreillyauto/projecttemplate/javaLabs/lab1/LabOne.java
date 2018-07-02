package com.oreillyauto.projecttemplate.javaLabs.lab1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LabOne {
	private List<OreillyEmployee> employeeList = new ArrayList<OreillyEmployee>();
	private Payroll payroll = new Payroll();

	public LabOne() {
		OreillyEmployee employeeOne = new OreillyEmployee(1, 30, "Jeffery Brannon", new BigDecimal("20000.00"),
				"Supervisor");
		OreillyEmployee employeeTwo = new OreillyEmployee(1, 30, "Nick Jaross", new BigDecimal("40000.00"), "Manager");
		employeeList.add(employeeOne);
		employeeList.add(employeeTwo);

		System.out.println("Total Payroll: " + payroll.calculatePayroll(employeeList));
		System.out.println("Manager Payroll: " + payroll.calculatePayroll(employeeList, "Manager"));

		System.out.println("Giving A $500 raise to each employee...");
		giveAnnualRaiseForDepartment(new BigDecimal("500.00"));

		System.out.println("Total Payroll: " + payroll.calculatePayroll(employeeList));
		System.out.println("Manager Payroll: " + payroll.calculatePayroll(employeeList, "Manager"));

		System.out.println("Age Check:");

		for (OreillyEmployee employee : employeeList) {
			System.out.println("Name: " + employee.getName() + " Age: " + employee.getAge());
		}

		payroll.happyBirthday(employeeOne);
		System.out.println("Jeffery Had A Birthday!");

		System.out.println("Age Check:");

		for (OreillyEmployee employee : employeeList) {
			System.out.println("Name: " + employee.getName() + " Age: " + employee.getAge());
		}
	}


	private void giveAnnualRaiseForDepartment(BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {
		new LabOne();
	}
}
