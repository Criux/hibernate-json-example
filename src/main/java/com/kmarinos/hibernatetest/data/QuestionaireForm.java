package com.kmarinos.hibernatetest.data;

import com.kmarinos.hibernatetest.data.Question;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class QuestionaireForm implements Serializable {

  public List<Question> asList(){
    return Arrays.stream(this.getClass().getDeclaredFields()).filter(f->Question.class.isAssignableFrom(f.getType())).map(f-> {
      try {
        f.setAccessible(true);
        return (Question)f.get(this);
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    }).toList();
  }
}
