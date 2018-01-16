package com.journaldev.spring;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.journaldev.spring.controller.RegistrationRestURIConstants;
import com.journaldev.spring.model.Registration;

public class TestSpringRestExample {

  public static final String SERVER_URI = "http://localhost:9090/Registration-Rest";

  public static void main(String args[]) {

    System.out.println("*****");
    testCreateEmployee();
    System.out.println("*****");
    testGetEmployee();
    System.out.println("*****");
    testGetAllEmployee();
  }

  private static void testGetAllEmployee() {
    RestTemplate restTemplate = new RestTemplate();
    // we can't get List<Registration> because JSON converter doesn't know the type of
    // object in the list and hence convert it to default JSON object type LinkedHashMap
    @SuppressWarnings({"unchecked", "rawtypes"})
    List<LinkedHashMap> registrations = restTemplate
        .getForObject(SERVER_URI + RegistrationRestURIConstants.GET_ALL_REGISTRATION, List.class);
    System.out.println(registrations.size());
    for (@SuppressWarnings("rawtypes") LinkedHashMap map : registrations) {
      System.out.println("ID=" + map.get("id") + ",Name=" + map.get("name") + ",CreatedDate="
          + map.get("createdDate"));
    }
  }

  private static void testCreateEmployee() {
    RestTemplate restTemplate = new RestTemplate();
    Registration emp = new Registration();
    emp.setId(1);
    emp.setTeamName("Timberline Trainers");
    Registration response = restTemplate.postForObject(
        SERVER_URI + RegistrationRestURIConstants.CREATE_REGISTRATION, emp, Registration.class);
    printEmpData(response);
  }

  private static void testGetEmployee() {
    RestTemplate restTemplate = new RestTemplate();
    Registration emp = restTemplate.getForObject(SERVER_URI + "/registration/1", Registration.class);
    printEmpData(emp);
  }

  public static void printEmpData(Registration emp) {
    System.out.println(
        "ID=" + emp.getId() + ",Name=" + emp.getTeamName() + ",CreatedDate=" + emp.getCreatedDate());
  }
}
