package kr.co.thejoenmovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.thejoenmovie.service.MovieService;
import kr.co.thejoenmovie.vo.CheckedSeatVo;
import kr.co.thejoenmovie.vo.CinemaVo;
import kr.co.thejoenmovie.vo.MovieVo;
import kr.co.thejoenmovie.vo.SeatVo;
import kr.co.thejoenmovie.vo.TicketVo;
import kr.co.thejoenmovie.vo.TimeVo;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	
	@ResponseBody
	@GetMapping("/getMovieCate")
	public List<MovieVo> getCate1(){
		List<MovieVo> cate1s = service.selectCate1();
		return cate1s;
	}
	
	@ResponseBody
	@GetMapping("/getCinemaCate")
	public List<CinemaVo> getCate2(String title) {
		List<CinemaVo> cate2s = service.selectCate2(title);
		return cate2s;
	}
	
	@ResponseBody
	@GetMapping("/getDateCate")
	public List<TimeVo> getCate3(String cinema_name){
		List<TimeVo> cate3s = service.selectCate3(cinema_name);
		return cate3s;
	}
	
	@ResponseBody
	@GetMapping("/getTimeCate")
	public List<TimeVo> getCate4(String cinema_name, String date){
		List<TimeVo> cate4s = service.selectCate4(cinema_name,date);
		return cate4s;
	}
	
	@ResponseBody
	@PostMapping("/bookTicket")
	public String bookTicket(TicketVo tv) {
		/* 디버깅용 */
//		System.out.println(tv.getMovie_cinema());
//		System.out.println(tv.getMovie_date());
//		System.out.println(tv.getMovie_price());
//		System.out.println(tv.getMovie_seats());
//		System.out.println(tv.getMovie_title());
		service.insertTicket(tv);
		return "result:1";
	}
	@ResponseBody
	@PostMapping("/bookSeat")
	public String bookSeat(SeatVo sv) {
		String title = sv.getTitle();
		String cinema_name = sv.getCinema_name();
		String date = sv.getDate();
		String time_start = sv.getTime_start();
		String[] seats = sv.getSeat();
		/* 디버깅용 */
//		System.out.println(title);
//		System.out.println(cinema_name);
//		System.out.println(date);
//		System.out.println(time_start);
		
		for(String seat : seats) {
			System.out.println(seat);
			service.insertSeat(title,cinema_name,date,time_start,seat);
		}
		return "result:1";
	}
	@ResponseBody
	@PostMapping("/getSeats")
	public List<CheckedSeatVo> getSeats(CheckedSeatVo sv) {
		/* 데이터 확인 */
//		System.out.println(sv.getTitle());
//		System.out.println(sv.getCinema_name());
//		System.out.println(sv.getDate());
//		System.out.println(sv.getTime_start());
		
		List<CheckedSeatVo> seats = service.selectSeats(sv);
		return seats;
	}
	
}
