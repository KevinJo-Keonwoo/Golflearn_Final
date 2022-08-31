package com.golflearn.domain.repository;

import com.golflearn.dto.Lesson;
import com.golflearn.exception.AddException;
import com.golflearn.exception.FindException;

public interface LessonRepository {
	/**
	 * 레슨번호로 레슨정보와 후기들을 검색한다
	 * @param lsnNo 레슨번호
	 * @return 레슨객체
	 * @throws FindException 레슨번호에 해당하는 상품이 없으면 "레슨이 없습니다" 상세메시지를 갖는 예외가 발생한다
	 */
	public Lesson selectByLsnNo(int lsnNo) throws FindException;
	
	/**
	 * 프로가 레슨을 승인요청한다
	 * @param Lesson 레슨정보
	 * @throws AddException
	 */
	void insertLsnInfo(Lesson lesson) throws AddException;
	
}
