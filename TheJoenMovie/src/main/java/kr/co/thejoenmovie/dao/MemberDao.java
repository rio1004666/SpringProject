package kr.co.thejoenmovie.dao;

import org.springframework.stereotype.Repository;

import kr.co.thejoenmovie.vo.MemberVo;

@Repository
public interface MemberDao {
	public void insertMember(MemberVo mv);
	public MemberVo selectMember(MemberVo mv);
	public int selectCountUid(String uid);
	public int selectCountNick(String nick);
	public int selectCountEmail(String email);
	public int selectCountHp(String hp);
}
