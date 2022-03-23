package com.ivoronline.springboot_mockito_crudrepository.respositories;

import com.ivoronline.springboot_mockito_crudrepository.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> { }
