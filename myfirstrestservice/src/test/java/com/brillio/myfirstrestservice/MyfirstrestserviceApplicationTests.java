package com.brillio.myfirstrestservice;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class MyfirstrestserviceApplicationTests {
	@Autowired
	MyRestController restController;
	@Autowired
	CrudController crudController;

	@Test
	@Order(1)
	public void testDTOClassAvailableOrNot(){
		try {
			StudentDTo studentDTo = new StudentDTo();
		} catch (Exception e) {
			fail();
		}
		}
	@Test
	@Order(2)
	public void testDTOClassAvailableOrNot1() {
		try {
			StudentDTo studentDTo = new StudentDTo();
			studentDTo.getAddress();
			studentDTo.getDb1();
		} catch (Exception e) {
			fail();
		}
	}
		@Test
		@Order(3)
		public void testRestController(){
			try {
				List<Student1DTO> list = restController.getAllStudentsMarks();
				assertNotNull(list);
			} catch (Exception e) {
				fail();
			}
	}
		@Test
		@Order(4)
		public void testRestController2(){
			try {
				List<Student1DTO> list = restController.getAllStudentsMarks();
				assertEquals(list.get(0).getSid(),"101");
			} catch (Exception e) {
				fail();
			}
		}
	@Test
	@Order(5)
	public void testRestController3(){
		try {
			Optional<StudentDTo> list = restController.getAnyStudent("5000");
			assertEquals(list, Optional.empty());
		} catch (Exception e) {
			fail();
		}
	}
	@Test
	@Order(6)
	public void testCrudControllerInsertion(){
		try {
			StudentDTo studentDTo = new StudentDTo();
			studentDTo.setSid("106");
			studentDTo.setAddress("axyy,ranchi");
			studentDTo.setFname("MS");
			studentDTo.setLname("Dhoni");
			studentDTo.setDb1("1991-07-07");
			String result = crudController.insertStudent(studentDTo);
			assertEquals(result, "Data is Inserted");
		} catch (Exception e){
			fail();
		}
	}
	@Test
	@Order(7)
	public void testCrudControllerUpdate(){
		try {
			StudentDTo studentDTo = new StudentDTo();
			studentDTo.setSid("106");
			studentDTo.setAddress("Mumbai,Maharashtra");
			studentDTo.setFname("Rohit");
			studentDTo.setLname("Sharma");
			studentDTo.setDb1("1981-07-06");
			String result = crudController.updateStudent(studentDTo);
			assertEquals(result, "Data is Updated");
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(8)
	public void testCrudControllerDelete(){
		try {
			String result = crudController.deleteStudent("106");
			assertEquals(result, "Data is Deleted");
		} catch (Exception e){
			fail();
		}
	}

}

