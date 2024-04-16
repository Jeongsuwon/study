package ex.board;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	private int bno;
	private String title, content, writer;
	private Date updateDate, regDate;
}
