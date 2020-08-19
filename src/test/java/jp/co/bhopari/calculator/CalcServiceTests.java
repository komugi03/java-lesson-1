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

//加算
	//テストケース①
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_下限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(-101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_下境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(-100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース③
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_上境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース④
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_上限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑤
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_下限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.add(-101, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑥
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_下境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.add(-100, -100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑦
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_上境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.add(100, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑧
	//エラーが投げられてたらOK
	@Test
	public void 加算_範囲外_上限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.add(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

//減算
	//テストケース①
	//エラーが投げられてたらOK
	@Test
	public void 減算_範囲外_下限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(-101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②
	//エラーが投げられてたらOK
	@Test
	public void 減算_範囲外_下境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(-100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース③
	//エラーが投げられてたらOK
	@Test
	public void 減算_範囲外_上境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース④
	//エラーが投げられてたらOK
	@Test
	public void 減算_範囲外_上限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑤
	//エラーが投げられてたらOK
	@Test
	public void 減算_範囲外_下限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(-101, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑥
	//エラーが投げられてたらOK
	@Test
	public void 減算_範囲外_下境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(-100, -100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑦
	//エラーが投げられてたらOK
	@Test
	public void 減算_範囲外_上境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(100, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑧
	//エラーが投げられてたらOK
	@Test
	public void 減算_範囲外_上限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(101, 101);
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