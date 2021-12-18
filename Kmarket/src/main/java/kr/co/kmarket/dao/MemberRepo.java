package kr.co.kmarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberVo;

@Repository
public interface MemberRepo extends JpaRepository<MemberVo, String>{/*테이블객체인 MemberVo와 테이블의 PK를 선택한다. */
	
}
