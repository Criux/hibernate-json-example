package com.kmarinos.hibernatetest.data;

import com.kmarinos.hibernatetest.data.Question;
import com.kmarinos.hibernatetest.data.QuestionaireForm;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class QuestionaireFormResponse implements Serializable {

  QuestionaireForm questionaireForm;
  Map<String, Object> responses = new HashMap<>();

  public void registerResponse(Question q, Object response) {
    if (questionaireForm.asList().contains(q)) {
      responses.put(q.getUuid(), response);
    }
  }
  public Object getResponse(Question q){
    return responses.get(q.getUuid());
  }
}
