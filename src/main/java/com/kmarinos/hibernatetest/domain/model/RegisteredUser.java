package com.kmarinos.hibernatetest.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RegisteredUser {
@Id
  @GeneratedValue
  Long id;
String username;
}
