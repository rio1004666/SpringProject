package kr.co.kmarket.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductOrderVo {
	private int orderId;
	private String uid;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int usePoint;
	private int delivery;
	private int total;
	private String orderer;
	private String hp;
	private String zip;
	private String addr1;
	private String addr2;
	private int payment;
	private int complete;
	private String rdate;
	private String completeDate;
	
	
	//추가필드1
	private int[] cartIds;
	private int[] productCodes;
	private int[] productCounts;
	
	//추가필드2
	
	private int productCode;
	private int pCount;
	private int cate1;
	private int cate2;
	private String thumb1;
	private String pName;
	private String pDescript;
	private int pPrice;
	private int pDiscount;
	private int pPoint;
	private int pDelivery;
	private int salePrice;
	private String uName;
	private String uHp;
	private String uZip;
	private String uAddr1;
	private String uAddr2;
	private String uPoint;
	
	
}
