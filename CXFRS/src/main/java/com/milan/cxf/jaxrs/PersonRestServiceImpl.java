package com.milan.cxf.jaxrs;

import com.milan.cxf.exception.ServiceException;
import com.milan.cxf.jaxrs.exception.AppException;
import com.milan.cxf.vo.PersonVO;
import com.milan.cxf.service.PersonService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/personRestService")
public class PersonRestServiceImpl
{
  private static Logger LOG = Logger.getLogger(PersonRestServiceImpl.class.getName());
  
  @Autowired
  private PersonService personService;
  
  @GET
  @Path("/getAllPersons")
  @Produces({"application/xml", "application/json"})
  public List<PersonVO> getAllPersons() throws AppException
  {
    List<PersonVO> personList = null;
    try
    {
      personList = this.personService.getAllPersons();
    }
    catch (ServiceException se)
    {
      LOG.log(Level.SEVERE, se.getMessage(), se);
      throw new AppException("BE-500", "Error while retrieving person list", 500);
    }
    return personList;
  }
  
  @PUT
  @Path("/createPerson")
  @Consumes({"application/xml", "application/json"})
  @Produces({"application/xml", "application/json"})
  public String createPerson(PersonVO person) throws AppException
  {
    boolean result = false;
    try
    {
      result = this.personService.createPerson(person);
    }
    catch (ServiceException se)
    {
      LOG.log(Level.SEVERE, se.getMessage(), se);
      result = false;
      throw new AppException("BE-500", "Error while creating person", 500);
      
    }
    if (result) {
      return "Success";
    }
    return "Failure";
  }
  
  @GET
  @Path("/getPersonByEmail/{email}")
  @Consumes({"application/xml", "application/json"})
  @Produces({"application/xml", "application/json"})
  public PersonVO getPersonByEmail(@PathParam("email") String email) throws AppException,Exception
  {
    PersonVO person = null;
    try
    {
      person = this.personService.getPersonByEmail(email);
    }
    catch (ServiceException  se)
    {
      LOG.log(Level.SEVERE, se.getMessage(), se);
      throw new AppException("BE-500", "Not able to retrieve the person with email = "+ email, 500);
    }catch(Exception e)
    {
    	LOG.log(Level.SEVERE, e.getMessage(), e);
        throw new Exception("Internal Server error");
    }
    return person;
  }
  
  public void setPersonService(PersonService personService)
  {
    this.personService = personService;
  }
}
