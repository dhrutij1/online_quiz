package com.quiz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * Created by Dhruti on 10/01/17.
 */

@JsonInclude(Include.NON_EMPTY)
public class QuestionDTO {

	private Long id;
	private String text;
	private Long point;
	private List<ChoiceDTO> options;
	private UserAnswerDTO userAnswer;
	private boolean isLastQuestion;
	private int nextQuestion;
	private int currentQuestion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public List<ChoiceDTO> getOptions() {
		return options;
	}

	public void setOptions(List<ChoiceDTO> options) {
		this.options = options;
	}

	public boolean isLastQuestion() {
		return isLastQuestion;
	}

	public void setLastQuestion(boolean isLastQuestion) {
		this.isLastQuestion = isLastQuestion;
	}

	public UserAnswerDTO getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(UserAnswerDTO userAnswer) {
		this.userAnswer = userAnswer;
	}

	public int getNextQuestion() {
		return nextQuestion;
	}

	public void setNextQuestion(int nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	public int getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(int currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

}

