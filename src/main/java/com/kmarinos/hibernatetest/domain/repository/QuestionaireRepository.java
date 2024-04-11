package com.kmarinos.hibernatetest.domain.repository;

import com.kmarinos.hibernatetest.domain.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionaireRepository extends JpaRepository<Survey,Long> {

}
