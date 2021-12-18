package kr.co.kmarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Repository
public interface MemberDao {
	public MemberTermsVo selectTerms();
	public void insertMember(MemberVo mv);
	public MemberVo selectMember(MemberVo mv);
	public int selectCountUid(String uid);
	public int selectCountEmail(String email);
	public int selectCountHp(String hp);
}
