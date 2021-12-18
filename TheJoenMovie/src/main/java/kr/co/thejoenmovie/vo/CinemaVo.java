package kr.co.thejoenmovie.vo;

import lombok.Data;

@Data
public class CinemaVo {
	
	private String cinema_code;
	private String cinema_local;
	private String cinema_name;
	private int cinema_screen_total;
	private int cinema_seat_total;
	private String cinema_add;
	private String cinema_tel;
	
	// 추가필드
	private String title;
}
