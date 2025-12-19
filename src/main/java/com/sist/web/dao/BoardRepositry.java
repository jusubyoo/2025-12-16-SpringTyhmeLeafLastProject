package com.sist.web.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.BoardEntity;
import java.util.*;
import com.sist.web.vo.*;

public interface BoardRepositry extends JpaRepository<BoardEntity, Integer>{
	// 상세보기 : 메소드
	public BoardEntity findByNo(int no);
	// SELECT * FROM board_2 WHERE no=#{no}
	/*
	 *   findByNameContains %name%
	 *   findByNameStartsWith name%
	 *   findByNameEndsWith %name
	 */
	// update, insert, delete, count => 생성되어있다
	// CLOB을 인식하지 못한다 => TO_CHAR
	@Query(value="SELECT no,name,subject,TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit,num "
			+ "FROM (SELECT no,name,subject,regdate,hit,rownum as num "
			+ "FROM (SELECT no,name,subject,regdate,hit "
			+ "FROM board_2 ORDER BY no DESC)) "
			+ "WHERE num BETWEEN :start AND :end",nativeQuery = true)
	// vale, nativeQuery=true => SQL 문장을 그대로 적용
	// 사용하지 않으면 JPQL 로 변환 => 오류 발생
	public List<BoardVO> boardListData(@Param("start") Integer start, @Param("end") Integer end);
	@Query(value="SELECT NVL(MAX(no)+1,1) FROM board_2",nativeQuery = true)
	public int getMax();
	
	// 수정 데이터 읽기 => content 가 CLOB 타입이라 문자열로 변환
	@Query(value="SELECT no,subject,name,TO_CHAR(content) as content "
			+ "FROM board_2 WHERE no=:no",nativeQuery = true)
	public BoardUpdateVO boardUpdateData(@Param("no") int no);
	
	// 수정 => save()
	// 삭제 => delete()
	// 총갯수 => count()
	// 전체 데이터 => findAll()
	// WHERE => findBy(컬럼명)(오라클명령문)
	// 상세보기 => findByNo() => findByFno() = 
	//           ---------- WHERE no=   WHERE fno= 메소드 규칙
}
