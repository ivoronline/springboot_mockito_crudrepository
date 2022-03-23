package com.ivoronline.springboot_mockito_crudrepository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

  //PROPERTIES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  name;
  public Integer age;

  //CONSTRUCTORS
  public Person() { }                          //Forced by @Entity
  public Person(String name, Integer age) {    //To simplify Person creation when Mocking
    this.id   = id;
    this.name = name;
    this.age  = age;
  }

}
