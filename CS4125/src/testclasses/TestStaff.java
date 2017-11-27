package testclasses;

import static org.junit.Assert.*;

import org.junit.Test;

import staff.Employee;
import staff.Manager;
import staff.staffFactory;

public class TestStaff {

	@Test 
	public void testStaff(){
		staffFactory fact = staffFactory.getStaffFactory();
		Manager testManager = (Manager) fact.createStaff("Manager");
		Employee testEmp = (Employee) fact.createStaff("Employee");
		testEmp.setValues("Kevin","fredty");
		testManager.setValues("Thomas", "L0nd0n16");
		assertTrue(testManager!=null);
		assertTrue(testEmp!=null);
		assertTrue(testManager.add_Employee(testEmp));
		assertTrue(testManager.remove_Employee(testEmp));
		
	}
	
}
