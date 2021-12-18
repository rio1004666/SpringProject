package kr.co.farmstory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.farmstory.dao.MemberDao;
import kr.co.farmstory.vo.MemberVo;
import kr.co.farmstory.vo.TermsVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
	public void insertMember(MemberVo vo) {
		dao.insertMember(vo);
	}
	public MemberVo selectMember(String uid, String pass) {
		return dao.selectMember(uid,pass);
	}
	
	
	
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	public int selectCountNick(String nick) {
		return dao.selectCountNick(nick);
	}
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
	
	
	
	public TermsVo selectTerms() {
		return dao.selectTerms();
	}
}
