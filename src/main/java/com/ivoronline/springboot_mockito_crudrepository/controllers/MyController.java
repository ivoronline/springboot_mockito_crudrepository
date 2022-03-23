package com.ivoronline.springboot_mockito_crudrepository.controllers;

import com.ivoronline.springboot_mockito_crudrepository.entities.Person;
import com.ivoronline.springboot_mockito_crudrepository.respositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired PersonRepository personRepository;

  //==================================================================
  // HELLO
  //==================================================================
  @RequestMapping("GetPerson")
  public String getPerson(@RequestParam Integer id) {
    Person person = personRepository.findById(id).get();
    return person.name + " is " + person.age + " years old";
  }

}
