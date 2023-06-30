package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberVO {

	private String name;
	private String id;
	private String pw;
	private String tel;
	private String addr;
}
