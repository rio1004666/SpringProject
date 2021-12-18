package kr.co.thejoenmovie.vo;

import lombok.Data;

@Data
public class TicketVo {
	private int ticketID;
	private String movie_title;
	private String movie_cinema;
	private String movie_date;
	private String movie_time;
	private String movie_seats;
	private int movie_price;
}
