package com.quiz.mapper;

import com.quiz.dto.ExamDTO;
import org.springframework.stereotype.Component;

/**
 * This is a mapper class that map Exam data transportation object to exam persistence object.
 *
 * @author dhruti
 */
@Component
public class ExamMapper {

	public ExamDTO convertToExamDTO(Exam exam) {
		ExamDTO examDTO = new ExamDTO();

		examDTO.setId(exam.getId());
		examDTO.setTitle(exam.getTitle());
		examDTO.setDescription(exam.getDescription());
		examDTO.setActive(exam.isActive());
		examDTO.setDuration(exam.getDuration());

		return examDTO;
	}
}
