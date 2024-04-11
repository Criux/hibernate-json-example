package com.kmarinos.hibernatetest;

import com.kmarinos.hibernatetest.data.Question;
import com.kmarinos.hibernatetest.data.surveys.QuestionaireQuestionsV1;
import com.kmarinos.hibernatetest.data.surveys.QuestionaireQuestionsV2;
import com.kmarinos.hibernatetest.domain.model.Survey;
import com.kmarinos.hibernatetest.domain.model.SurveyResponse;
import com.kmarinos.hibernatetest.domain.repository.QuestionaireRepository;
import com.kmarinos.hibernatetest.domain.repository.QuestionaireResponseRepository;
import java.time.LocalDate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RunMe {

  @Bean
  ApplicationRunner start(QuestionaireRepository questionaireRepository, QuestionaireResponseRepository questionaireResponseRepository){
    return args -> {
      persistForms(questionaireRepository);
      persistResponses(questionaireRepository, questionaireResponseRepository);
      SurveyResponse surveyResponse = questionaireResponseRepository.findById(3L).get();
      System.out.println("Done...");
    };
  }

  private static void persistResponses(QuestionaireRepository questionaireRepository,
      QuestionaireResponseRepository questionaireResponseRepository) {
    Survey found1 = questionaireRepository.findById(1L).get();
    SurveyResponse response1_1 = SurveyResponse.builder().survey(found1).filledDate(LocalDate.now()).build();
    for (Question question : found1.getQuestions().asList()) {
      response1_1.getReplies().registerResponse(question,"reply for "+question.getPrompt());
    }
    questionaireResponseRepository.save(response1_1);
    SurveyResponse response1_3 = SurveyResponse.builder().survey(found1).filledDate(LocalDate.now()).build();
    for (Question question : found1.getQuestions().asList()) {
      response1_3.getReplies().registerResponse(question,"reply for "+question.getPrompt());
    }
    questionaireResponseRepository.save(response1_3);

    found1.setQuestions(new QuestionaireQuestionsV2());
    questionaireRepository.save(found1);
    SurveyResponse response1_2 = SurveyResponse.builder().survey(found1).filledDate(LocalDate.now()).build();
    for (Question question : found1.getQuestions().asList()) {
      response1_2.getReplies().registerResponse(question,"reply for "+question.getPrompt());
    }
    questionaireResponseRepository.save(response1_2);
  }

  private void persistForms(QuestionaireRepository questionaireRepository) {
    Survey survey1 = Survey.builder().active(true).name("questionaire 1").questions(new QuestionaireQuestionsV1()).build();
    questionaireRepository.save(survey1);

    Survey survey2 = Survey.builder().active(false).name("questionaire 2").questions(new QuestionaireQuestionsV2()).build();
    questionaireRepository.save(survey2);
  }
}
