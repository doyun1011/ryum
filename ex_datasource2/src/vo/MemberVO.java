package vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String name;
	private String pw;
	private String tel;
	private String addr;
}
