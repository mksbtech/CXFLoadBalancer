package com.milan.cxf.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Person")
public class PersonVO
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String firstName;
  private String lastName;
  private String email;
  private Long age;
  
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
  
  public static long getSerialversionuid()
  {
    return 1L;
  }
}
