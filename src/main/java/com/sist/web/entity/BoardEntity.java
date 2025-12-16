package com.sist.web.entity;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
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
public class BoardEntity {
	@Id
	private int no;
	
	private int hit;
	private String name,subject,content,pwd;
	private Date regdate;
}
