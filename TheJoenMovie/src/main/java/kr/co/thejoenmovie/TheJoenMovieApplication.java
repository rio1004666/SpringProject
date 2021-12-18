package kr.co.thejoenmovie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("kr.co.thejoenmovie.dao")
@SpringBootApplication
public class TheJoenMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheJoenMovieApplication.class, args);
	}
	
	
	

}
