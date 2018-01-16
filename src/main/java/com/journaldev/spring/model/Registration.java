package com.journaldev.spring.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class Registration implements Serializable {

  private static final long serialVersionUID = -7788619177798333712L;

  private int id;
  private String teamName;
  private String teamLeader;
  private String phone;
  private String email;

  private Date createdDate;
  private Date registeredDate;
  private Date waitlistedDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public String getTeamLeader() {
    return teamLeader;
  }

  public void setTeamLeader(String teamLeader) {
    this.teamLeader = teamLeader;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @JsonSerialize(using = DateSerializer.class)
  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @JsonSerialize(using = DateSerializer.class)
  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  @JsonSerialize(using = DateSerializer.class)
  public Date getWaitlistedDate() {
    return waitlistedDate;
  }

  public void setWaitlistedDate(Date waitlistedDate) {
    this.waitlistedDate = waitlistedDate;
  }


}
