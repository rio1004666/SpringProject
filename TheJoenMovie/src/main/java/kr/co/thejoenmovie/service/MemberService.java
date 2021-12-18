package kr.co.thejoenmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.thejoenmovie.dao.MemberDao;
import kr.co.thejoenmovie.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
	
	
	
	public void insertMember(MemberVo mv) {
		dao.insertMember(mv);
	}
	public MemberVo selectMember(MemberVo mv) {
		return dao.selectMember(mv);
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
}
