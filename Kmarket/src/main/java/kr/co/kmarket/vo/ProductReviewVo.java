package kr.co.kmarket.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewVo {
	private int reviewId;
	private int productCode;
	private String content;
	private String uid;
	private int rating;
	private String ip;
	private String rdate;
}
