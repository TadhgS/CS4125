package testclasses;

import static org.junit.Assert.*;

import org.junit.Test;

import staff.Employee;
import staff.Manager;
import staff.staffFactory;

public class TestStaff {

	@Test 
	public void TestStaff(){
		staffFactory fact = staffFactory.getStaffFactory();
		Manager testManager = (Manager) fact.createStaff("Manager");
		Employee testEmp = (Employee) fact.createStaff("Employee");
		testEmp.setValues("Daniel","Password");
		assertTrue(testManager!=null);
		assertTrue(testEmp!=null);
		
	}
	
}
