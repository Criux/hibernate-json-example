package com.kmarinos.hibernatetest.domain.model;

import com.kmarinos.hibernatetest.domain.mappers.QuestionairQuestionsType;
import com.kmarinos.hibernatetest.data.QuestionaireForm;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CompositeType;

@Entity
@Table(name = "survey")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Survey {

  @Id
  @GeneratedValue
  Long id;
  String name;
  boolean active;
  @AttributeOverride(
      name = "modelClass",
      column = @Column(name = "model_class")
  )@AttributeOverride(
      name = "rawData",
      column = @Column(name = "raw_data",columnDefinition = "jsonb")
  )
  @CompositeType(value = QuestionairQuestionsType.class)
  private QuestionaireForm questions;
}
