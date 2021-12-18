package kr.co.thejoenmovie.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.thejoenmovie.vo.CheckedSeatVo;
import kr.co.thejoenmovie.vo.CinemaVo;
import kr.co.thejoenmovie.vo.MovieVo;
import kr.co.thejoenmovie.vo.TicketVo;
import kr.co.thejoenmovie.vo.TimeVo;

@Repository
public interface MovieDao {
	public List<MovieVo> selectCate1();
	public List<CinemaVo> selectCate2(String title);
	public List<TimeVo> selectCate3(String cinema_name);
	public List<TimeVo> selectCate4(String cinema_name, String date);
	public void insertTicket(TicketVo tv);
	public void insertSeat(String title,String cinema_name,String date,String time_start,String seat);
	public List<CheckedSeatVo> selectSeats(CheckedSeatVo sv);
}
