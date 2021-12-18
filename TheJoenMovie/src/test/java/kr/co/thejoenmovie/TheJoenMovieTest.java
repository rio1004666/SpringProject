package kr.co.thejoenmovie;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.thejoenmovie.dao.MainDao;
import kr.co.thejoenmovie.vo.MovieVo;

@SpringBootTest
public class TheJoenMovieTest {

	@Autowired
	private MainDao dao;
	
	@Test
	public void selectTest() {
		
		List<MovieVo> list = dao.selectMovieInfo();
		
		
		
		
	}
	
	
}
