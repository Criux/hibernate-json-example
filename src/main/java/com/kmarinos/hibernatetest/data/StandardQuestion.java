package com.kmarinos.hibernatetest.data;

import lombok.Builder;
import lombok.Data;


public class StandardQuestion extends Question{
  @Builder
  public StandardQuestion(String prompt, boolean required, QuestionType type) {
    super(prompt, required, type);
  }
}
