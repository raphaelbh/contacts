package com.zup.apipoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ApipocApplicationTests {

	@Test()
	void contextLoads() {
		Assertions.assertDoesNotThrow(this::doNotThrowException);
	}

	private void doNotThrowException(){
	}

}
