package com.kmarinos.hibernatetest.data.surveys;

import com.kmarinos.hibernatetest.data.Question;
import com.kmarinos.hibernatetest.data.QuestionRating;
import com.kmarinos.hibernatetest.data.QuestionType;
import com.kmarinos.hibernatetest.data.QuestionaireForm;
import com.kmarinos.hibernatetest.data.StandardQuestion;
import java.io.Serializable;
import lombok.Data;

@Data
public class QuestionaireQuestionsV1 extends QuestionaireForm implements Serializable {

  Question q1 = QuestionRating.smartBuilder().totalStars(5).prompt("Question 1. Tell us your opinion.").required(false).build();
  Question q2 = StandardQuestion.builder().prompt("Question 2. Your opinion matters.").required(true).type(QuestionType.RATING).build();
}
