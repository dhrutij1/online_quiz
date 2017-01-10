package com.quiz.persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * This is a persistence model class that mapped with user database table contains user details.
 *
 * @author dhruti
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Basic(optional = false)
	@Column(name = "email")
	private String email;

	@Basic(optional = false)
	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "user")
	private List<UserQuestionAnswer> userQuestionAnswerCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserExam> userExamCollection;

	public User() {
	}

	public User(Long id) {
		super(id);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserQuestionAnswer> getUserQuestionAnswerCollection() {
		return userQuestionAnswerCollection;
	}

	public void setUserQuestionAnswerCollection(List<UserQuestionAnswer> userQuestionAnswerCollection) {
		this.userQuestionAnswerCollection = userQuestionAnswerCollection;
	}

	public List<UserExam> getUserExamCollection() {
		return userExamCollection;
	}

	public void setUserExamCollection(List<UserExam> userExamCollection) {
		this.userExamCollection = userExamCollection;
	}
}