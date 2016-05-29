package com.milan.cxf.jaxrs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.milan.cxf.jaxrs.exception.AppException;
import com.milan.cxf.vo.PersonVO;

@Path("/personRestService")
public class PersonLBService
{
//  private static Logger LOG = Logger.getLogger(PersonLBService.class.getName());
  
  @GET
  @Path("/getAllPersons")
  @Produces({"application/xml", "application/json"})
  public List<PersonVO> getAllPersons() throws AppException
  {
    return null;
  }
  
  @PUT
  @Path("/createPerson")
  @Consumes({"application/xml", "application/json"})
  @Produces({"application/xml", "application/json"})
  public String createPerson(PersonVO person) throws AppException
  {
     return null;
  }
  
  @GET
  @Path("/getPersonByEmail/{email}")
  @Consumes({"application/xml", "application/json"})
  @Produces({"application/xml", "application/json"})
  public PersonVO getPersonByEmail(@PathParam("email") String email) throws AppException,Exception
  {
      return null;
  }
  

}