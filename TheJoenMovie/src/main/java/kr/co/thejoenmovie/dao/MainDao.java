package kr.co.thejoenmovie.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.thejoenmovie.vo.MovieVo;

@Repository
public interface MainDao {
	public List<MovieVo> selectMovieInfo();
	public MovieVo MovieInfo(MovieVo vo);
	public List<MovieVo> selectAllMovies(int start);
	public int selectCountTotal();
}