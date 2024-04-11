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
public class Question implements Serializable {

  String prompt;
  boolean required;
  QuestionType type;
  public String getUuid (){
    return String.valueOf(prompt.hashCode());
  }
}
