package com.kmarinos.hibernatetest.domain.repository;

import com.kmarinos.hibernatetest.domain.model.SurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionaireResponseRepository extends JpaRepository<SurveyResponse,Long> {

}
