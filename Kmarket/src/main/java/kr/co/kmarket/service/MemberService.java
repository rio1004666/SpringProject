package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MemberDao;
import kr.co.kmarket.dao.MemberRepo;
import kr.co.kmarket.dao.MemberTermsRepo;
import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
	@Autowired
	private MemberRepo repo;
	@Autowired
	private MemberTermsRepo repoTerms;
	
	public void insertMember(MemberVo mv) {
		/* Mybatis */
		dao.insertMember(mv);
		/* JPA  */
		/* repo.save(mv); JPA기술로 데이터를 INSERT해주는 메서드 => JPA객체를 상속받았으므로 해당 메서드를 사용합니다.*/
		/* 쿼리문 작성을 하지 않는다. 즉, 어떤 데이터베이스를 사용하느냐에 따라서 쿼리문이 달라질 수 있는데 무관하게 데이터를 엑세스할 수 있다 표준화하였다. */
	
	}
	public MemberVo selectMember(MemberVo mv) {
		/* Mybatis */
		MemberVo memberVo = dao.selectMember(mv);
		/* JPA */
		//MemberVo memberVo = repo.findby(); 
		/* 여기서 조건이 붙기 때문에 정의를 해야한다. 메서드를 */
		/* JPA에서는 쿼리기능이있는 쿼리메서드로 데이터베이스에 액세스합니다. */
		return memberVo;
	}
	public MemberTermsVo selectTerms() {
		/* Mybatis */
		//MemberTermsVo termsVo = dao.selectTerms()
		/* JPA => 치명적인 단점 :  JOIN 연산을 할경우 상당히 복답해진다. */
		/* 단순 쿼리문일 경우 많이 사용할 수 있습니다. */
		MemberTermsVo termsVo = repoTerms.findById(1).get();
		return termsVo;
		
	}

	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
}
