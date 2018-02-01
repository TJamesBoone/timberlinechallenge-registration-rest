package com.journaldev.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.model.Registration;

/**
 * Handles requests for the Registration service.
 */
@Controller
public class RegistrationController {

  private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

  // Map to store employees, ideally we should use database
  Map<Integer, Registration> empData = new HashMap<Integer, Registration>();

  @CrossOrigin(origins = "*")
  @RequestMapping(value = RegistrationRestURIConstants.GET_REGISTRATION, method = RequestMethod.GET)
  public @ResponseBody Registration getRegistration(@PathVariable("id") int empId) {
    logger.info("Start getRegistration. ID=" + empId);

    return empData.get(empId);
  }

  @RequestMapping(value = RegistrationRestURIConstants.GET_ALL_REGISTRATION,
      method = RequestMethod.GET)
  public @ResponseBody List<Registration> getAllRegistrations() {
    logger.info("Start getAllRegistrations.");
    List<Registration> emps = new ArrayList<Registration>();
    Set<Integer> empIdKeys = empData.keySet();
    for (Integer i : empIdKeys) {
      emps.add(empData.get(i));
    }
    return emps;
  }

  @RequestMapping(value = RegistrationRestURIConstants.CREATE_REGISTRATION,
      method = RequestMethod.POST)
  public @ResponseBody Registration createRegistration(@RequestBody Registration emp) {
    logger.info("Start createRegistration.");
    emp.setCreatedDate(new Date());
    empData.put(emp.getId(), emp);
    return emp;
  }

  @RequestMapping(value = RegistrationRestURIConstants.DELETE_REGISTRATION,
      method = RequestMethod.PUT)
  public @ResponseBody Registration deleteRegistration(@PathVariable("id") int empId) {
    logger.info("Start deleteRegistration.");
    Registration emp = empData.get(empId);
    empData.remove(empId);
    return emp;
  }

}
