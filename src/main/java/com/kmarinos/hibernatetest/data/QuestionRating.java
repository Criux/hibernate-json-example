package com.kmarinos.hibernatetest.data;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRating extends Question {

  int totalStars;

  @Builder(builderClassName = "QuestionBuilder",builderMethodName = "smartBuilder")
  public QuestionRating(String prompt, boolean required, int totalStars) {
    super(prompt, required, QuestionType.RATING);
    this.totalStars = totalStars;
  }
}
