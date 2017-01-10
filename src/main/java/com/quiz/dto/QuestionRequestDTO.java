package com.quiz.dto;

/**
 * Created by Dhruti on 10/01/17.
 */
public class QuestionRequestDTO {
	private Long examId;
	private Long userId;
	private int questionNumber;

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
}


