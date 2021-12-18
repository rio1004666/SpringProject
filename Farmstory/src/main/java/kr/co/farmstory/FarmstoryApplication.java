package kr.co.farmstory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("kr.co.farmstory.dao")
@SpringBootApplication
public class FarmstoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmstoryApplication.class, args);
	}

}
