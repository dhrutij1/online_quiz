package com.quiz.repository;

import java.io.Serializable;

/**
 * This is a generice interface that define common database operations.
 *
 * @param <T>
 * @param <ID>
 * @author dhruti
 */
public interface GenericRepository<T, ID extends Serializable> {

	public T save(T entity);

	public T update(T entity);

	public T saveOrUpdate(T entity);

	public T findById(ID id);

	public T findOne(String field, String value);

}
