package edu.iut.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CriteriaDate implements Criteria {

	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> exams) {
		List<ExamEvent> beforeJulyExams = new ArrayList<ExamEvent>();
		
		Date july = new Date(2016, 7, 1);
		
		for (ExamEvent exam : exams) {
			if (exam.getExamDate().before(july))
				beforeJulyExams.add(exam);
		}
		return beforeJulyExams;
	}

}
