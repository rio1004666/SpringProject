package kr.co.thejoenmovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.thejoenmovie.dao.MainDao;
import kr.co.thejoenmovie.vo.MovieVo;

@Service
public class MainService {
	@Autowired
	private MainDao dao;
	
	public List<MovieVo> selectMovieInfo(){
		return dao.selectMovieInfo();
	}
	
	public MovieVo MovieInfo(MovieVo vo) {
		return dao.MovieInfo(vo);
	}
	
	public List<MovieVo> selectAllMovies(int start){
		return dao.selectAllMovies(start);
	}
	
	public int selectCountTotal(){
		return dao.selectCountTotal();
	}
	

// 페이지 리스트 시작번호
public int getPageStartNum(int total, int start) {
	return total - start;
}

// 페이지 현재 그룹번호
public int[] getPageGroup(int currentPage, int lastPageNum) {
	int groupCurrent = (int)Math.ceil(currentPage / 10.0);
	int groupStart = (groupCurrent -1) * 10 + 1;
	int groupEnd = groupCurrent * 10;
	
	if(groupEnd > lastPageNum) {
		groupEnd = lastPageNum;
	}
	int[] groups = {groupStart, groupEnd};
	return groups;
}

// 현재 리스트 페이지 번호
public int getCurrentPage(String pg) {
	int currentPage = 1;
	
	if(pg != null) {
		currentPage = Integer.parseInt(pg);
	}
	return currentPage;
	
}

// 현재 리스트 SQL start 번호
public int getLimitStart(int currentPage) {
	return (currentPage - 1) * 10;
}

// 리스트 마지막 페이지 번호
public int getLastPageNum(int total) {
	int lastPageNum = 0;
	if(total % 10 == 0) {
		lastPageNum = total / 10;
	}else {
		lastPageNum = total / 10 + 1;
	}
	
	return lastPageNum;
}
}