package kr.co.thejoenmovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.thejoenmovie.dao.MovieDao;
import kr.co.thejoenmovie.vo.CheckedSeatVo;
import kr.co.thejoenmovie.vo.CinemaVo;
import kr.co.thejoenmovie.vo.MovieVo;
import kr.co.thejoenmovie.vo.TicketVo;
import kr.co.thejoenmovie.vo.TimeVo;

@Service
public class MovieService {
	@Autowired
	private MovieDao dao;
	
	public List<MovieVo> selectCate1(){
		return  dao.selectCate1();
	}
	
	public List<CinemaVo> selectCate2(String title){
		return dao.selectCate2(title);
	}
	
	public List<TimeVo> selectCate3(String cinema_name){
		return dao.selectCate3(cinema_name);
	}
	public List<TimeVo> selectCate4(String cinema_name,String date){
		return dao.selectCate4(cinema_name,date);
	}
	public void insertTicket(TicketVo tv) {
		dao.insertTicket(tv);
	}
	public void insertSeat(String title,String cinema_name,String date,String time_start,String seat) {
		dao.insertSeat(title,cinema_name,date,time_start,seat);
	}
	
	public List<CheckedSeatVo> selectSeats(CheckedSeatVo sv){
		return dao.selectSeats(sv);
	}
	
}
