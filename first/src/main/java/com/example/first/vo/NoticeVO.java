package com.example.first.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private String title, content, writer;
	private Date write_date;

	
	
}
