package vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CommentVO {
	private int num;
	private String id;
	private String content;
	private String writer;
	private LocalDate date;
	private LocalDate mdDate;
	private int bnum;
}
