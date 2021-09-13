import com.brillio.myfirstrestservice.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources")

public class stepdefs{
    @Autowired
    CrudController crudController;
    StudentDTo studentDTo;
    String result;


    @Given("A Student enrolls and fills the application")
    public void aStudentEnrollsAndFillsTheApplication() {
        crudController = new CrudController();
        studentDTo = new StudentDTo();
    }

    @When("Data is collected")
    public void dataIsCollected() {
        StudentDTo studentDTo= new StudentDTo();
        studentDTo.setSid("107");
        studentDTo.setDb1("1985-05-27");
        studentDTo.setAddress("Ylk, Bangalore");
        studentDTo.setFname("Elon");
        studentDTo.setLname("Musk");
        result= crudController.insertStudent(studentDTo);
    }

    @Then("Data is added in the Database")
    public void dataIsAddedInTheDatabase() {
        assertEquals(result,"Data is Inserted");
    }
}
