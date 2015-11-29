package edu.iut.app;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPerson implements Criteria {

	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> exams) {
		List<ExamEvent> suffisantJuryExams = new ArrayList<ExamEvent>();
		
		for (ExamEvent exam : exams) {
			if (exam.getJury().size() > 2)
				suffisantJuryExams.add(exam);
		}
		return suffisantJuryExams;
	}

}
