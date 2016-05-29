package com.milan.cxf.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.milan.cxf.entity.Person;
import com.milan.cxf.exception.ServiceException;
import com.milan.cxf.vo.PersonVO;

@Service
public class PersonService
{
  @PersistenceContext(unitName="myPersistenceUnit")
  private EntityManager entityManager;
  
  public List<PersonVO> getAllPersons()
    throws ServiceException
  {
    PersonVO personVO = null;
    List<PersonVO> personVOList = new ArrayList<>(5);
    List<Person> personList = this.entityManager.createQuery("select p from Person p").getResultList();
    for (Person p : personList)
    {
      personVO = new PersonVO();
      personVO.setAge(p.getAge());
      personVO.setEmail(p.getEmail());
      personVO.setFirstName(p.getFirstName());
      personVO.setLastName(p.getLastName());
      personVOList.add(personVO);
    }
    return personVOList;
  }
  
  @Transactional
  public boolean createPerson(PersonVO person)
    throws ServiceException
  {
    Person p = new Person();
    boolean result = false;
    p.setEmail(person.getEmail());
    p.setAge(person.getAge());
    p.setFirstName(person.getFirstName());
    p.setLastName(person.getLastName());
    try
    {
      this.entityManager.persist(p);
      this.entityManager.flush();
      
      result = true;
    }
    catch (Exception e)
    {
    	throw new ServiceException("Error in creating person resord in database with email = "+person.getEmail());
    }
    return result;
  }
  
  public PersonVO getPersonByEmail(String email)
    throws ServiceException
  {
    PersonVO personVO = null;
    
    List<Person> personList = entityManager.createQuery("select p from Department p where p.email='" + email + "'").getResultList();
    if(null==personList || personList.isEmpty())
    {
    	throw new ServiceException("No records found in database for email = "+email);
    }
    Person p = personList.get(0);
    personVO = new PersonVO();
    personVO.setAge(p.getAge());
    personVO.setEmail(p.getEmail());
    personVO.setFirstName(p.getFirstName());
    personVO.setLastName(p.getLastName());
    return personVO;
  }
  
  public EntityManager getEntityManager()
  {
    return this.entityManager;
  }
  
  public void setEntityManager(EntityManager entityManager)
  {
    this.entityManager = entityManager;
  }
}

