package vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BorderVO {
	private int num;
	private String id;
	private String title;
	private String writer;
	private LocalDate date;
	private LocalDate mdDate;
	private String content;
	private String rp;
}
