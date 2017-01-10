package com.quiz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Created by Dhruti on 10/01/17.
 */

@JsonInclude(Include.NON_EMPTY)
public class ResultDTO {

	private Long examId;
	private Long userId;
	private Long userScore;
	private Long totalScore;
	private Long percentage;

	public ResultDTO() {

	}

	public ResultDTO(Long userScore, Long totalScore, Long percentage) {
		this.userScore = userScore;
		this.totalScore = totalScore;
		this.percentage = percentage;
	}

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

	public Long getUserScore() {
		return userScore;
	}

	public void setUserScore(Long userScore) {
		this.userScore = userScore;
	}

	public Long getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Long totalScore) {
		this.totalScore = totalScore;
	}

	public Long getPercentage() {
		return percentage;
	}

	public void setPercentage(Long percentage) {
		this.percentage = percentage;
	}
}
