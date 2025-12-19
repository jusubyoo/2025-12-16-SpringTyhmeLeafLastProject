package com.sist.web.entity;
import java.util.*;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
/*
 *  1월 : security(jwt) / sns 연동
 *  	  websocket / 통합 / AI / betch
 *  	  ----------------------------
 *  	  => boot : 실무
 *  
 *  1. JPA (Java persistence API)
 *     1) JAVA ORM(Object Relational Mapping) 의 표준
 *     					  ---------- 관계형 DB
 *     					  = MyBatis 
 *     					  = Hibernate (JPA)
 *     2) 자바 객체와 데이터베이스 테이블 매핑
 *        -------  -------------------
 *           |				|
 *           ----------------
 *           		|
 *           변수,컬럼명 반드시 일치 => update, insert
 *           INSERT INTO table(변수명)
 *           VO / DTO => 유연성
 *           Entity = 반드시 컬럼명과 일치 : JOIN => CRUD
 *     3) 특별한 경우가 아니면 SQL없이 사용이 가능 => DB 연동
 *        --------- 6:4 = select 문장 (SQL), insert/update/delete
 *        									------------- ------
 *        									    save()    delete()
 *     4) ORM
 *     	  => JDBC = DBCP = ORM (MyBatis / JPA)
 *           select * from table_name
 *           findAll() => SQL
 *        => native SQL / JPQL => select 를 하더라도 column 명이 나오는게 아니라
 *                             => 변수와 매칭
 *        => 객체(BoardEntity) = 테이블 자동 매핑
 *           => BoardEntity(X) => Board
 *           = 필드 <=> 컬럼명
 *           = 객체 관계 지정 <=> 테이블 외래키 관계 => 어노테이션
 *     5) 장단점
 *        => SQL 의존도 감소 (객체 중심 개발)
 *        => 개발이 빠르다 (CURD가 자동 처리)
 *        => 캐시, 지연 로딩 => 성능 최적화 
 *        => 복잡한 객체 관계가 있는 경우 이해가 어렵다
 *        => 사용이 잘못되면 성능 저하 (N:1 => N:N)
 *     6) @Entity : 테이블 매칭
 *     7) 생명주기 : JAP 연결 => 메소드 호출 => SQL 제작 => DB 연동
 *     8) 사용법 / Native SQL / JPQL / JOIN / 외래키
 *        => 객체 중심의 설계 
 */
/*
 *  NO      NOT NULL NUMBER         
	NAME    NOT NULL VARCHAR2(51)   
	SUBJECT NOT NULL VARCHAR2(4000) 
	CONTENT NOT NULL CLOB           
	PWD     NOT NULL VARCHAR2(10)   
	REGDATE          DATE           
	HIT              NUMBER   
 */
@Data
@Entity(name="board_2")
@DynamicUpdate
public class BoardEntity {
	@Id
	private int no;

	private String name;
	private String subject;
	private String content;
	
	@Column(insertable = true, updatable = false)
	private String pwd;
	
	@Column(insertable = true, updatable = false)
	private Date regdate;
	private int hit;
}
