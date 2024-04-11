package com.kmarinos.hibernatetest.domain.model;

import com.kmarinos.hibernatetest.data.QuestionaireFormResponse;
import com.kmarinos.hibernatetest.domain.mappers.QuestionaireResponseType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CompositeType;

@Entity
@Table(name = "survey_response")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SurveyResponse {

  @Id
  @GeneratedValue
  Long id;
  @ManyToOne
  Survey survey;
  LocalDate filledDate;
  @AttributeOverride(
      name = "modelClass",
      column = @Column(name = "model_class")
  )@AttributeOverride(
      name = "rawData",
      column = @Column(name = "raw_data",columnDefinition = "jsonb")
  )
  @CompositeType(value = QuestionaireResponseType.class)
  private QuestionaireFormResponse replies;

  @Builder
  public SurveyResponse(Survey survey, LocalDate filledDate) {
    this.survey = survey;
    this.filledDate = filledDate;
    this.replies = new QuestionaireFormResponse();
    replies.setQuestionaireForm(survey.getQuestions());
  }

//  public void addReply(Question question,Object reply){
//    replies.put(question,reply);
//  }
}
