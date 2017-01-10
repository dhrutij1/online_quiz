package com.quiz.persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * This is a persistence model class that mapped with user_exam database table that hold exam information for a user.
 *
 * @author dhruti
 */
@Entity
@Table(name = "user_exam")
public class UserExam extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "score")
	private Long score;

	@Column(name = "percentage")
	private Long percentage;

	@JoinColumn(name = "exam_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Exam exam;

	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private User user;

	public UserExam() {
	}

	public UserExam(Long id) {
		super(id);
	}

	public UserExam(Exam exam, User user, Date startDate) {
		this.exam = exam;
		this.user = user;
		this.startDate = startDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getPercentage() {
		return percentage;
	}

	public void setPercentage(Long percentage) {
		this.percentage = percentage;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
