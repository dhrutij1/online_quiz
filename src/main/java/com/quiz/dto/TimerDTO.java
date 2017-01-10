package com.quiz.dto;

/**
 * Created by Dhruti on 10/01/17.
 */
public class TimerDTO {

	private Long examId;
	private Long userId;
	private Long duration;

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

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

}
