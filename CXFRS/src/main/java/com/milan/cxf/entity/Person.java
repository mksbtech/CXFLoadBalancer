package com.milan.cxf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="ID")
  private Long id;
  
  @Column(name="FIRST_NAME")
  private String firstName;
  @Column(name="LAST_NAME")
  private String lastName;
  
  @Column(name="EMAIL_ADDRESS",unique=true)
  private String email;
  
  @Column(name="AGE")
  private Long age;
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getFirstName()
  {
    return this.firstName;
  }
  
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  
  public String getLastName()
  {
    return this.lastName;
  }
  
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public Long getAge()
  {
    return this.age;
  }
  
  public void setAge(Long age)
  {
    this.age = age;
  }
}
