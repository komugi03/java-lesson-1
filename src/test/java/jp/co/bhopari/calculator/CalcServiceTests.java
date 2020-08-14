package jp.co.bhopari.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.bhopari.calculator.services.IllegalArgumentExceptionX;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionY;
import jp.co.bhopari.calculator.services.impl.CalcServiceImpl;

@SpringBootTest	//サービスのテスト→モックはいらない?
class CalcServiceTests {

	CalcServiceImpl calc = new CalcServiceImpl() ;

	@Test
	public void 加算できてるかtest() throws Exception{
		double expected = 10;
		double actual = calc.add(7, 3);
		assertEquals(expected, actual);
	}

	@Test
	public void 減算できてるかtest() throws Exception{
		double expected = 30;
		double actual = calc.sub(50, 20);
		assertEquals(expected, actual);
	}

	@Test
	public void 乗算できてるかtest() throws Exception{
		double expected = 35;
		double actual = calc.mul(7, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void 除算できてるかtest() throws Exception{
		double expected = 32.5;
		double actual = calc.div(65, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void 加算範囲外XYエラーでるかtest(){	//エラーが投げられてたらOK
		try {
			calc.add(100, -105);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	@Test
	public void 減算範囲外XYエラーでるかtest(){	//エラーが投げられてたらOK
		try {
			calc.sub(100, -105);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}catch(IllegalArgumentExceptionY e) {
		}
	}
	@Test
	public void 乗算範囲外XYエラーでるかtest(){	//エラーが投げられてたらOK
		try {
			calc.mul(100, -105);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	@Test
	public void 除算範囲外XYエラーand0除算エラーでるかtest(){	//エラーが投げられてたらOK
		try {
			calc.div(100, 0);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}catch(IllegalArgumentExceptionY e) {
		}catch(ArithmeticException e) {
		}
	}


}