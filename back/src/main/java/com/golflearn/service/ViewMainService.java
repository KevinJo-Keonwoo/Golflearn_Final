package com.golflearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golflearn.domain.LessonRepository;
import com.golflearn.dto.Lesson;
import com.golflearn.exception.FindException;

@Service(value="viewMainService")
public class ViewMainService {
	@Autowired
	private LessonRepository repository; // 아직 안받아옴
	
	public List<Lesson> viewLesson() throws FindException {
		List<Lesson> lessons = repository.selectAll();
		return lessons;
	}	
	
	public List<Lesson> filterLesson(int[] locNoArr) throws FindException {
		List<Lesson> filteredLessons = repository.selectSidogu(locNoArr);
		return filteredLessons;
	}
	
}
