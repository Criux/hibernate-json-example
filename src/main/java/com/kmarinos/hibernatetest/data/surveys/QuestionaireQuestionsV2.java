package com.kmarinos.hibernatetest.data.surveys;

import com.kmarinos.hibernatetest.data.Question;
import com.kmarinos.hibernatetest.data.QuestionType;
import com.kmarinos.hibernatetest.data.QuestionaireForm;
import com.kmarinos.hibernatetest.data.StandardQuestion;
import java.io.Serializable;
import lombok.Data;

@Data
public class QuestionaireQuestionsV2 extends QuestionaireForm implements Serializable {

  String text = "Welcome";
  Question q1 = StandardQuestion.builder().prompt("Question 1").required(false).type(QuestionType.RADIO).build();
  Question q2 = StandardQuestion.builder().prompt("Question 2").required(true).type(QuestionType.TEXT_SHORT).build();
}
