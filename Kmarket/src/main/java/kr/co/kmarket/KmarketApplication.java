package kr.co.kmarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan({"kr.co.kmarket.dao","kr.co.kmarket.admin.dao"})
@SpringBootApplication
public class KmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmarketApplication.class, args);
	}

}
