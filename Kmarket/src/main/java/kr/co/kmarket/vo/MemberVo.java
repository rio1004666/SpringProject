package kr.co.kmarket.vo;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
/* Entity와 Table는 JPA기술로 테이블 객체를 만들기위한 어노테이션*/
@Data
@Entity
@Table(name="km_member")
public class MemberVo {
	@Id /* PK임을 알려주는 어노테이션 */
	private String uid;
	private String pass;
	private String name;
	private int gender;
	private String hp;
	private String email;
	private int type;
	private int point;
	private int grade;
	private String zip;
	private String addr1;
	private String addr2;
	private String company;
	private String ceo;
	private String bizRegNum;
	private String commRepNum;
	private String tel;
	private String manager;
	private String managerHp;
	private String fax;
	private String ip;
	private String leaveDate;
	private String rdate;
	private int etc1;
	private int etc2;
	private String etc3;
	private String etc4;
	private String etc5;
	
	/* JPA는 테이블 객체를 원칙상 엄격하게 테이블 컬럼과 매칭되야한다.
	   여기서 추기 필드는 만들어진 컬럼에 대한 필드명이므로 따로 빼주어야합니다.*/
	// 추가필드
	@Transient
	private int productCode;
	
}
