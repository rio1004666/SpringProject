package kr.co.kmarket;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/* 프로젝트 전체가 아닌 개별적으로 테스트를 해보기 위해서 다른 컴포넌트들간의 영향없이 테스트를 진행해보는 영역입니다. */
/* 로그기록을 통해서 문제를 해결하기 위해 데이터를 추적하거나 사용자들의 데이터들을 조회하고 유용하게 활용하기 위한 기록입니다. */
@SpringBootTest
public class LoggingTest {
	
	public void logTest1() {
		System.out.println("로그출력1");
	}
	/* Test어노테이션을 붙이면 이 부분이 실행된다. */
	/* 사용자 ip주소까지 기록하려면 사용자 정의 로그 설정을 따로 만들어주어야합니다 */
	@Test
	public void logTest2()
	{
		Logger logger = LoggerFactory.getLogger(this.getClass()); // 현재클래스 LoggingTest를 가리킵니다.
		/* */
		logger.trace("로그 - trace");
		logger.debug("로그 - debug");
		/* info단계부터 출력하도록 되어있습니다. */
		logger.info("로그 - info");
		logger.warn("로그 - warn");
		logger.error("로그 - error"); /* 에러가 났을 경우 출력하는 로그레벨 */
		/*너무 레벨이 높으면 불필요한 데이터가 쌓이므로 관리가 필요하다 그래서 기본적인 로그레벨을 info로 잡는 것이 좋다. */
	}
	
}
