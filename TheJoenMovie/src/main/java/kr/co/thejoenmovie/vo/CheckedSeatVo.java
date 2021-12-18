package kr.co.thejoenmovie.vo;

import lombok.Data;

@Data
public class CheckedSeatVo {
	private String title;
	private String cinema_name;
	private String date;
	private String time_start;
	
	// 좌석을 가져올때 하나씩 가져올때 멤버변수
	private String seat;
}
