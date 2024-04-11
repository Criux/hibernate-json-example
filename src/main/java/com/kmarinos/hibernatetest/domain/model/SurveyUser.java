package com.kmarinos.hibernatetest.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
public class SurveyUser {
@Id
  @GeneratedValue
  Long id;
@ManyToOne
Survey survey;
@ManyToOne
RegisteredUser user;
boolean filledOut;
LocalDate showAgainAfterDate;
}
