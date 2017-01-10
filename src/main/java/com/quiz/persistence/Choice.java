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
 * This is a persistence model class that mapped with choice_master database table contains options for a question.
 *
 * @author dhruti
 */
@Entity
@Table(name = "choice_master")
public class Choice extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 8044602586172912160L;

	@Column(name = "text")
	private String text;

	@Column(name = "isCorrect")
	private boolean isCorrect;

	@JoinColumn(name = "question_id", referencedColumnName = "id")
	@ManyToOne
	private Question question;

	@OneToMany(mappedBy = "choice")
	private List<UserQuestionAnswer> userQuestionAnswerCollection;

	public Choice() {
	}

	public Choice(Long id) {
		super(id);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<UserQuestionAnswer> getUserQuestionAnswerCollection() {
		return userQuestionAnswerCollection;
	}

	public void setUserQuestionAnswerCollection(List<UserQuestionAnswer> userQuestionAnswerCollection) {
		this.userQuestionAnswerCollection = userQuestionAnswerCollection;
	}
}