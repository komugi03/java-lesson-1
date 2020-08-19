package jp.co.bhopari.calculator;

/**
 * サービスのテスト
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.bhopari.calculator.services.IllegalArgumentExceptionX;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionY;
import jp.co.bhopari.calculator.services.impl.CalcServiceImpl;

@SpringBootTest
class CalcServiceTests {

	CalcServiceImpl calc = new CalcServiceImpl() ;

	//テストケース①加算範囲外X下限値
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_下限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(-101, 10);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②加算範囲外X下境界値
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_下境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(-100, 10);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース③加算範囲外X上境界値
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_上境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(100, 10);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース④加算範囲外X上限値
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_上限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(101, 10);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}


	@Test
	public void 加算できてるかtest() throws Exception{
		double expected = 10;
		double actual = calc.add(7, 3);
		assertEquals(expected, actual);
	}

	@Test
	public void 減算できてるかtest() throws Exception{
		double expected = 30;
		double actual = calc.subtract(50, 20);
		assertEquals(expected, actual);
	}

	@Test
	public void 乗算できてるかtest() throws Exception{
		double expected = 35;
		double actual = calc.multiply(7, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void 除算できてるかtest() throws Exception{
		double expected = 32.5;
		double actual = calc.divide(65, 2);
		assertEquals(expected, actual);
	}


	@Test
	//エラーが投げられてたらOK
	public void 加算範囲外Yエラーでるかtest() throws IllegalArgumentExceptionX{
		try {
			calc.add(100, -105);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	@Test
	//エラーが投げられてたらOK
	public void 減算範囲外XYエラーでるかtest(){
		try {
			calc.subtract(100, -105);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	@Test
	//エラーが投げられてたらOK
	public void 乗算範囲外XYエラーでるかtest(){
		try {
			calc.multiply(100, -105);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	@Test
	//エラーが投げられてたらOK
	public void 除算範囲外XYエラーand0除算エラーでるかtest(){
		try {
			calc.divide(100, 0);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}catch(IllegalArgumentExceptionY e) {
		}catch(ArithmeticException e) {
		}
	}

}