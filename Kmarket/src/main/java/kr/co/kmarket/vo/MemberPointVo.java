package kr.co.kmarket.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberPointVo {
	private int pointId;
	private String uid;
	private int productCode;
	private int price;
	private int point;
	private String rdate;
}
