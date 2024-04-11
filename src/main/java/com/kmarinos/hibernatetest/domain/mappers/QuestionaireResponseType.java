package com.kmarinos.hibernatetest.domain.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmarinos.hibernatetest.data.QuestionaireForm;
import com.kmarinos.hibernatetest.data.QuestionaireFormResponse;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.HibernateException;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.ValueAccess;
import org.hibernate.type.SqlTypes;
import org.hibernate.usertype.CompositeUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class QuestionaireResponseType implements CompositeUserType<QuestionaireFormResponse> {
  @Autowired
  ObjectMapper objectMapper;
  public static class QuestionaireFormResponseMapper {
    String modelClass;
    @JdbcTypeCode(SqlTypes.JSON)
    String rawData;

    public String getRawData() {
      return rawData;
    }

    public void setRawData(String rawData) {
      this.rawData = rawData;
    }

    public String getModelClass() {
      return modelClass;
    }

    public void setModelClass(String modelClass) {
      this.modelClass = modelClass;
    }
  }
  @SneakyThrows
  @Override
  public Object getPropertyValue(QuestionaireFormResponse component, int property) throws HibernateException {
    switch (property) {
      case 0:
        return component.getQuestionaireForm().getClass().getName();
      case 1:
        return objectMapper.writeValueAsString(component.getResponses());
    }
    return null;
  }

  @SneakyThrows
  @Override
  public QuestionaireFormResponse instantiate(ValueAccess valueAccess, SessionFactoryImplementor sessionFactoryImplementor) {
    QuestionaireFormResponse questionaireFormResponse = new QuestionaireFormResponse();
    questionaireFormResponse.setQuestionaireForm(
        (QuestionaireForm) Class.forName(valueAccess.getValue(0, String.class)).getConstructor().newInstance());
    questionaireFormResponse.setResponses(objectMapper.readValue(valueAccess.getValue(1, String.class), Map.class));
    return questionaireFormResponse;
  }

  @Override
  public Class<?> embeddable() {
    return QuestionaireFormResponseMapper.class;
  }

  @Override
  public Class<QuestionaireFormResponse> returnedClass() {
    return QuestionaireFormResponse.class;
  }

  @Override
  public boolean equals(QuestionaireFormResponse questionaireQuestionsV1, QuestionaireFormResponse j1) {
    return Objects.equals(questionaireQuestionsV1, j1);
  }

  @Override
  public int hashCode(QuestionaireFormResponse questionaireQuestionsV1) {
    return questionaireQuestionsV1.hashCode();
  }

  @Override
  public QuestionaireFormResponse deepCopy(QuestionaireFormResponse questionaireQuestionsV1) {
    return questionaireQuestionsV1;
  }

  @Override
  public boolean isMutable() {
    return false;
  }

  @Override
  public Serializable disassemble(QuestionaireFormResponse questionaireQuestionsV1) {
    return (Serializable) questionaireQuestionsV1;
  }

  @Override
  public QuestionaireFormResponse assemble(Serializable serializable, Object o) {
    return (QuestionaireFormResponse)serializable;
  }

  @Override
  public QuestionaireFormResponse replace(QuestionaireFormResponse detached, QuestionaireFormResponse managed, Object owner) {
    return detached;
  }
}
