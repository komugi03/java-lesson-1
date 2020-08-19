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


	/**
	 * 加算の範囲チェック
	 * エラーメッセージが投げられていたらテストOK
	 */
	//テストケース①
	@Test
	public void 加算_範囲外_1下限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(-101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②
	@Test
	public void 加算_範囲外_2下境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(-100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース③
	@Test
	public void 加算_範囲外_3上境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース④
	@Test
	public void 加算_範囲外_4上限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.add(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑤
	@Test
	public void 加算_範囲外_5下限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.add(-101, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑥
	@Test
	public void 加算_範囲外_6下境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.add(-100, -100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑦
	@Test
	public void 加算_範囲外_7上境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.add(100, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑧
	@Test
	public void 加算_範囲外_8上限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.add(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	/**
	 * 減算の範囲チェック
	 * エラーメッセージが投げられていたらテストOK
	 */
	//テストケース①
	@Test
	public void 減算_範囲外_下限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(-101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②
	@Test
	public void 減算_範囲外_下境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(-100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース③
	@Test
	public void 減算_範囲外_上境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース④
	@Test
	public void 減算_範囲外_上限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑤
	@Test
	public void 減算_範囲外_下限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(-101, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑥
	@Test
	public void 減算_範囲外_下境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(-100, -100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑦
	@Test
	public void 減算_範囲外_上境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(100, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑧
	@Test
	public void 減算_範囲外_上限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	/**
	 * 乗算の範囲チェック
	 * エラーメッセージが投げられていたらテストOK
	 */
	//テストケース①
	@Test
	public void 乗算_範囲外_下限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(-101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②
	@Test
	public void 乗算_範囲外_下境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(-100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース③
	@Test
	public void 乗算_範囲外_上境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース④
	@Test
	public void 乗算_範囲外_上限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑤
	@Test
	public void 乗算_範囲外_下限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.multiply(-101, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑥
	@Test
	public void 乗算_範囲外_下境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.multiply(-100, -100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑦
	@Test
	public void 乗算_範囲外_上境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.multiply(100, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑧
	@Test
	public void 乗算_範囲外_上限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.multiply(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	/**
	 * 除算の範囲チェック
	 * エラーメッセージが投げられていたらテストOK
	 */
	//テストケース①
	@Test
	public void 除算_範囲外_下限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.divide(-101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②
	@Test
	public void 除算_範囲外_下境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.divide(-100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース③
	@Test
	public void 除算_範囲外_上境界値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.divide(100, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース④
	@Test
	public void 除算_範囲外_上限値Xtest() throws IllegalArgumentExceptionY{
		try {
			calc.divide(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑤
	@Test
	public void 除算_範囲外_下限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.divide(-101, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑥
	@Test
	public void 除算_範囲外_下境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.divide(-100, -100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑦
	@Test
	public void 除算_範囲外_上境界値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.divide(100, 100);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑧
	@Test
	public void 除算_範囲外_上限値Ytest() throws IllegalArgumentExceptionX{
		try {
			calc.divide(101, 101);
			assertTrue(false);
		}catch(IllegalArgumentExceptionY e) {
		}
	}
}