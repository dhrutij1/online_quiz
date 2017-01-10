package com.quiz.persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * This is a persistence model class that mapped with exam_master database table contains exam details.
 *
 * @author dhruti
 */
@Entity
@Table(name = "exam_master")
public class Exam extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "active")
	private boolean active;

	@Column(name = "duration")
	private Long duration;

	@OneToMany(mappedBy = "exam")
	private List<Question> questionCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "exam")
	private List<UserExam> userExamCollection;

	public Exam() {
	}

	public Exam(Long id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<UserExam> getUserExamCollection() {
		return userExamCollection;
	}

	public void setUserExamCollection(List<UserExam> userExamCollection) {
		this.userExamCollection = userExamCollection;
	}

	public List<Question> getQuestionCollection() {
		return questionCollection;
	}

	public void setQuestionCollection(List<Question> questionCollection) {
		this.questionCollection = questionCollection;
	}
}