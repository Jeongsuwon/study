package com.example.first.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int id;
	private String title, content, writer, user_id;
	private Date write_date;

	
	
}
