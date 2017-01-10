package com.quiz.dto;

import javax.validation.constraints.NotNull;

public class UserAnswerDTO {

	@NotNull(message = "Please select at lease one option")
	private Long choiceId;

	@NotNull(message = "Question Id is missing")
	private Long questionId;

	@NotNull(message = "User Id is missing")
	private Long userId;

	public Long getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(Long choiceId) {
		this.choiceId = choiceId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}