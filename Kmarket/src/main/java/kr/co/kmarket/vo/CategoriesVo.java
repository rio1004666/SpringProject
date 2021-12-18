package kr.co.kmarket.vo;

import java.util.List;

import lombok.Data;
@Data
public class CategoriesVo {
	
	private int cate1;
	private int cate2;
	private String tit1;
	private String tit2;
	private List<ProductCate2Vo> cate2List; // 카테고리1에 해당하는 카테고리2가 리스트로 담겨져잇다
	
}
