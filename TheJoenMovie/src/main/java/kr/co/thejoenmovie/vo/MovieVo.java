package kr.co.thejoenmovie.vo;

import lombok.Data;

@Data 
public class MovieVo {
	private int movie_num;
	private String title;
	private float score;
	private String genre;
	private String grade;
	private String director;
	private String actor;
	private String rtime;
	private String rdate;
	private String poster;
	private String cinema_name;
	

	// 추가필드
	private String story;
	private String cinema_code;
	private String review_title;
	private String review_id;
	private String review_date;
	private String review_text;
	private String keyword;
}
