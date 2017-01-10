package com.quiz.persistence;

import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * This persistence class that mapped with database tables for some common fields.
 * <p>
 * This class can be inherit by other persistence models to mapped fields like id, created_date,
 * updated_date with database table.
 *
 * @author dhruti
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5185757828084916600L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "created_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	@org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
	private Date createdDatetime;

	@Column(name = "updated_date")
	private Date updatedDatetime;

	public BaseEntity() {
	}

	public BaseEntity(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Date getUpdatedDatetime() {
		return updatedDatetime;
	}

	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}
}