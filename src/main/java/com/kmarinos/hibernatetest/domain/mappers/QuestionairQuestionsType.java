package com.kmarinos.hibernatetest.domain.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmarinos.hibernatetest.data.QuestionaireForm;
import com.kmarinos.hibernatetest.data.surveys.QuestionaireQuestionsV1;
import java.io.Serializable;
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
public class QuestionairQuestionsType implements CompositeUserType<QuestionaireForm> {
  @Autowired
  ObjectMapper objectMapper;
  public static class QuestionaireFormMapper {
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
  public Object getPropertyValue(QuestionaireForm component, int property) throws HibernateException {
    switch (property) {
      case 0:
        return component.getClass().getName();
      case 1:
        return objectMapper.writeValueAsString(component);
    }
    return null;
  }

  @SneakyThrows
  @Override
  public QuestionaireForm instantiate(ValueAccess valueAccess, SessionFactoryImplementor sessionFactoryImplementor) {
    return (QuestionaireForm) objectMapper.readValue(valueAccess.getValue(1, String.class), Class.forName(valueAccess.getValue(0, String.class)));
  }

  @Override
  public Class<?> embeddable() {
    return QuestionaireFormMapper.class;
  }

  @Override
  public Class<QuestionaireForm> returnedClass() {
    return QuestionaireForm.class;
  }

  @Override
  public boolean equals(QuestionaireForm questionaireQuestionsV1, QuestionaireForm j1) {
    return Objects.equals(questionaireQuestionsV1, j1);
  }

  @Override
  public int hashCode(QuestionaireForm questionaireQuestionsV1) {
    return questionaireQuestionsV1.hashCode();
  }

  @Override
  public QuestionaireForm deepCopy(QuestionaireForm questionaireQuestionsV1) {
    return questionaireQuestionsV1;
  }

  @Override
  public boolean isMutable() {
    return false;
  }

  @Override
  public Serializable disassemble(QuestionaireForm questionaireQuestionsV1) {
    return (Serializable) questionaireQuestionsV1;
  }

  @Override
  public QuestionaireForm assemble(Serializable serializable, Object o) {
    return (QuestionaireQuestionsV1)serializable;
  }

  @Override
  public QuestionaireForm replace(QuestionaireForm detached, QuestionaireForm managed, Object owner) {
    return detached;
  }
}
