package edu.iut.app;

import java.util.ArrayList;
import java.util.List;

public class CriteriaRoom implements Criteria {

	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> exams) {
		List<ExamEvent> affectedRoomExams = new ArrayList<ExamEvent>();
		
		for (ExamEvent exam : exams) {
			if (exam.getClassroom().getClassRoomNumber() != "not affected")
				affectedRoomExams.add(exam);
		}
		return affectedRoomExams;
	}

}
