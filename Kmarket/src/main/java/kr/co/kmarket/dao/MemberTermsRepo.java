package kr.co.kmarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

/* JPA 는 자바진영의 ORM 기술 표준*/
/* SQL중심 개발에서 객체 중심 개발 */
/* ORM은 객체 관계 매핑*/
/* Hibornate, OpenJPA는 JPA의 ORM 기술 */
import kr.co.kmarket.vo.MemberTermsVo;
/* 약관테이블에 해당하는 객체를 매핑시켜주기로함 */
/* 제네릭타입으로 PK에 해당하는 컬럼이 없다면 만들어주기로 한다. */
public interface MemberTermsRepo extends JpaRepository<MemberTermsVo, Integer>{

}
