package service;

import db.MemberDao;
import vo.MemberVO;

public class CheckupService {
	private MemberDao memberDao;

	public CheckupService() {
		this.memberDao = new MemberDao();
	}

	public void regMember(MemberVO member) {
		// 회원 등록 로직
		memberDao.register(member);
	}

	public int checkId(String id) {
		// 아이디 중복 검사 로직
		return memberDao.getId(id);
	}

	public int checkTel(String tel) {
		// 전화번호 중복 검사 로직
		return memberDao.getTel(tel);
	}
}
