package kr.co.kmarket.vo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVo {
	private int productCode;
	private int cate1;
	private int cate2;
	private String name;
	private String descript;
	private String company;
	private String seller;
	private int price;
	private int discount;
	private int point;
	private int stock;
	private int sold;
	private int delivery;
	private int hit;
	private int score;
	private int review;
	private String thumb1;
	private String thumb2;
	private String thumb3;
	private String detail;
	private String status;
	private String dutyFree;
	private String receipt;
	private String bizClass;
	private String origin;
	private String ip;
	private String rdate;
	
	// 추가필드
	private int start;
	private String tit1;
	private String tit2;
	private int salePrice;
	private int order = 1; // int의 기본값은 0이고 1을 셋팅하지않으면 정렬을 수행하지 않고 기본적인 순서로만 나온다.
	
	private int etc1;
	private int etc2;
	private String etc3;
	private String etc4;
	private String etc5;
	
	
	
	// 추가필드 파일첨부시에 담은 멤버들
	private MultipartFile thumbFile1;
	private MultipartFile thumbFile2;
	private MultipartFile thumbFile3;
	private MultipartFile detailFile4;
	// 첨부한 파일들을 리스트로 반환
	public List<MultipartFile> getFiles() {
		List<MultipartFile> files = Arrays.asList(thumbFile1, thumbFile2, thumbFile3, detailFile4);
		return files;
	}
		
}
