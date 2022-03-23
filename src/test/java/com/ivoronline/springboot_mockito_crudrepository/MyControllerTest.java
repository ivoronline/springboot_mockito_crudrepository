package com.ivoronline.springboot_mockito_crudrepository;

import com.ivoronline.springboot_mockito_crudrepository.controllers.MyController;
import com.ivoronline.springboot_mockito_crudrepository.entities.Person;
import com.ivoronline.springboot_mockito_crudrepository.respositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyControllerTest {

  //PROPERTIES
  @Autowired MyController     myController;
  @SpyBean   PersonRepository personRepositorySpy;

  //=========================================================
  // TEST CONTROLLER
  //=========================================================
  @Test
  void testController() {

    //MOCK METHOD CALL
    when(personRepositorySpy.findById(2)).thenReturn(Optional.of(new Person("Jill", 50)));

    //TEST CONTROLLER'S ENDPOINT
    String john = myController.getPerson(1); //John  is taken from DB.
    String jill = myController.getPerson(2); //There is no Jill in DB. Mocked Person is used.

    //TEST RESULTS
    assertEquals("John is 20 years old", john);   System.out.println(john);
    assertEquals("Jill is 50 years old", jill);   System.out.println(jill);

  }

  //=========================================================
  // TEST REPOSITORY
  //=========================================================
  //This code just repeats what is going on in the Controller
  @Test
  void testRepository() {

    //MOCK METHOD CALLS
    when(personRepositorySpy.findById(2)).thenReturn(Optional.of(new Person("Jill", 50)));

    //CALL METHODS
    Person john = personRepositorySpy.findById(1).get();
    Person jill = personRepositorySpy.findById(2).get();

    //ASSERT RESULTS
    assertEquals("John", john.name);   System.out.println(john.name);
    assertEquals("Jill", jill.name);   System.out.println(jill.name);

  }
}