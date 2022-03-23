package com.ivoronline.springboot_mockito_crudrepository.runners;

import com.ivoronline.springboot_mockito_crudrepository.entities.Person;
import com.ivoronline.springboot_mockito_crudrepository.respositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoadPersons implements CommandLineRunner {

  //PROPERTIES
  @Autowired PersonRepository personRepository;

  //=======================================================================================
  // RUN
  //=======================================================================================
  @Override
  @Transactional
  public void run(String... args) throws Exception {
    System.out.println("Runner");
    personRepository.save(new Person("John" , 20));
    personRepository.save(new Person("John" , 21));
    personRepository.save(new Person("Bill" , 30));
  }

}

