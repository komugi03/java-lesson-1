package jp.co.bhopari.calculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.bhopari.calculator.services.TestService;

@SpringBootTest
class CalculatorApplicationTests {

	@Mock
	TestService testService;	//インターフェースを使うことを宣言？

//	@Test
//	void test1() {
//		assertTrue(true);
//
//	}
//
//	@Test
//	void test2() {
//		int v1 = testService.getRandomNumber();
//		int v2 = testService.getRandomNumber();
//		int v3 = testService.getRandomNumber();
//		assertTrue(v1 != v2 && v2 != v3 && v1 != v3);
//	}

	@Test
	void test3() {	//エラー発生したらOK
		when(testService.getValue(0))	//0で呼んだとき、例外を投げる。
			.thenThrow(new IllegalArgumentException());

		when(testService.getValue(1))
			.thenReturn(5);

//		when(testService.getValue(anyInt()))	//何らかの値が入ったとき
//			.thenReturn(1);
//
//		when(testService.getValue(AdditionalMatchers.not(1)))	//0じゃないとき
//			.thenReturn(1);

		try{
			testService.getValue(0);
			assertTrue(false);
		}catch(IllegalArgumentException e) {
		}

		//1のとき5が帰ってきたらOK
		assertEquals(testService.getValue(1), 5);

	}

}
