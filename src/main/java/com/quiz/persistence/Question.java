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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * This is a persistence model class that mapped with question_master database table contains questions.
 *
 * @author dhruti
 */
@Entity
@Table(name = "question_master")
public class Question extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "text")
	private String text;

	@Column(name = "point")
	private Long point;

	@JoinColumn(name = "exam_id", referencedColumnName = "id")
	@ManyToOne
	private Exam exam;

	@OneToMany(mappedBy = "question")
	private List<Choice> choiceCollection;

	@OneToMany(mappedBy = "question")
	private List<UserQuestionAnswer> userQuestionAnswerCollection;

	public Question() {
	}

	public Question(Long id) {
		super(id);
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

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<UserQuestionAnswer> getUserQuestionAnswerCollection() {
		return userQuestionAnswerCollection;
	}

	public void setUserQuestionAnswerCollection(List<UserQuestionAnswer> userQuestionAnswerCollection) {
		this.userQuestionAnswerCollection = userQuestionAnswerCollection;
	}

	public List<Choice> getChoiceCollection() {
		return choiceCollection;
	}

	public void setChoiceCollection(List<Choice> choiceCollection) {
		this.choiceCollection = choiceCollection;
	}

}
