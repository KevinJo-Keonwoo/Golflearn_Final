package com.golflearn.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.golflearn.domain.entity.RoundReviewBoardEntity;

public interface RoundReviewBoardRepository extends JpaRepository<RoundReviewBoardEntity, Long> {
	
	/**
	 * 목록 불러오기 (라운딩리뷰 목록을 최신순으로 보여준다)
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	@Query(value = "SELECT *\r\n"
			+ "     FROM (SELECT rownum r, a.*\r\n"
			+ "           FROM (SELECT *"
			+ "                 FROM round_review_board\r\n"
			+ "                 ORDER BY round_review_board_no DESC\r\n"
			+ "                 ) a\r\n"
			+ "           )\r\n"
			+ "     WHERE r BETWEEN ?1 AND ?2"
			,nativeQuery = true)
	List<RoundReviewBoardEntity> findListByRecent(int startRow, int endRow);
	
	/**
	 * 목록 불러오기 (라운딩리뷰 목록을 조회수순으로 보여준다)
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	@Query(value = "SELECT *\r\n"
			+ "		FROM (SELECT rownum r, a.*\r\n"
			+ "			  FROM (SELECT *"
			+ "					FROM round_review_board\r\n"
			+ "					ORDER BY round_review_board_view_cnt DESC\r\n"
			+ "					) a\r\n"
			+ "			  )\r\n"
			+ "		WHERE r BETWEEN ?1 AND ?2"
			,nativeQuery = true)
	List<RoundReviewBoardEntity> findListByViewCnt(int startRow, int endRow);
	
	/**
	 * 목록 불러오기 (라운딩리뷰 목록을 좋아요순으로 보여준다)
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	@Query(value = "SELECT *\r\n"
			+ "		FROM (SELECT rownum r, a.*\r\n"
			+ "			  FROM (SELECT *"
			+ "					FROM round_review_board\r\n"
			+ "					ORDER BY round_review_board_like_cnt DESC\r\n"
			+ "					) a\r\n"
			+ "			  )\r\n"
			+ "		WHERE r BETWEEN ?1 AND ?2"
			,nativeQuery = true)
	List<RoundReviewBoardEntity> findListByLike(int startRow, int endRow);
	
	
//	페이저블 테스트
//	@Query(value = "SELECT *\r\n"
//			+ "		FROM (SELECT rownum r, a.*\r\n"
//			+ "			  FROM (SELECT *"
//			+ "					FROM round_review_board\r\n"
//			+ "					WHERE user_nickname = ?1\r\n"
//			+ "					ORDER BY round_review_board_like_cnt DESC\r\n"
//			+ "					) a\r\n"
//			+ "			  )\r\n"
//			+ "		WHERE r BETWEEN 1 AND 5"
//			,nativeQuery = true)
//	Page<RoundReviewBoardEntity> testLike(String userNickname, Pageable pageable);
	
//	/**
//	 * 게시글 번호에 맞는 상세내용(게시글, 댓글 모두) 가져오기
//	 * @param roundReviewBoardNo
//	 * @return
//	 */
//	@Query(value = "SELECT rrb.*, rrc.round_review_cmt_dt , rrc.*\r\n"
//			+ "FROM round_review_board rrb LEFT JOIN round_review_comment rrc \r\n"
//			+ "                            ON (rrb.round_review_board_no = rrc.round_review_board_no)               \r\n"
//			+ "WHERE rrb.round_review_board_no = ?1"
//			,nativeQuery = true)
//	RoundReviewBoardEntity findDetail(Long roundReviewBoardNo);
	


	
	/**
	 * 게시글 검색하기
	 * 제목, 내용, 닉네임 중 하나라도 같으면 검색됨
	 * @param word
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	@Query(value = "SELECT *\r\n"
			+ "FROM (SELECT rownum r, a.*\r\n"
			+ "      FROM (SELECT * \r\n"
			+ "            FROM round_review_board\r\n"
			+ "            WHERE round_review_board_title LIKE %?1% OR round_review_board_content LIKE %?1% OR user_nickname LIKE %?1% \r\n"
			+ "            ORDER BY round_review_board_no DESC\r\n"
			+ "            ) a\r\n"
			+ "      )\r\n"
			+ "WHERE r BETWEEN ?2 AND ?3"
			,nativeQuery = true)
	Page<RoundReviewBoardEntity> findByWord(String word, int startRow, int endRow, Pageable pageable);

	@Query(value = "SELECT * \r\n"
			+ "            FROM round_review_board\r\n"
			+ "            WHERE round_review_board_title LIKE %?1% OR round_review_board_content LIKE %?1% OR user_nickname LIKE %?1% \r\n"
			+ "            ORDER BY round_review_board_no DESC\r\n"
			,nativeQuery = true)
	Page<RoundReviewBoardEntity> findByWord2(String word, Pageable pageable);
	
}
