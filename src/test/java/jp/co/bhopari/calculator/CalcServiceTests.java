package jp.co.bhopari.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.bhopari.calculator.services.IllegalArgumentExceptionX;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionY;
import jp.co.bhopari.calculator.services.impl.CalcServiceImpl;

/**
 *  計算機能を提供するサービスの単体テスト
 */

@SpringBootTest
class CalcServiceTests {

	CalcServiceImpl calc = new CalcServiceImpl() ;

	/**
	 * 加算の範囲チェック
	 * ①～⑤⑧⑨⑫～⑯：エラーメッセージが投げられていたらテストOK
	 * ⑥⑦⑩⑪：正確に計算ができていたらテストOK
	 */
	//テストケース①
	@Test
	public void 加算_範囲外_1test() throws IllegalArgumentExceptionY{
		try {
			calc.add(-101, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②
	@Test
	public void 加算_範囲外_2test() throws IllegalArgumentExceptionX{
		try {
			calc.add(-100, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース③
	@Test
	public void 加算_範囲外_3test() throws IllegalArgumentExceptionX{
		try {
			calc.add(100, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース④
	@Test
	public void 加算_範囲外_4test() throws IllegalArgumentExceptionY{
		try {
			calc.add(101, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑤
	@Test
	public void 加算_範囲外_5test() throws IllegalArgumentExceptionY{
		try {
			calc.add(-101, -100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑥
	@Test
	public void 加算_範囲外_6test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = -200;
		double actual = calc.add(-100, -100);
		assertEquals(expected, actual);
	}

	//テストケース⑦
	@Test
	public void 加算_範囲外_7test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = 0;
		double actual = calc.add(100, -100);
		assertEquals(expected, actual);
	}

	//テストケース⑧
	@Test
	public void 加算_範囲外_8test() throws IllegalArgumentExceptionY{
		try {
			calc.add(101, -100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}


	//テストケース⑨
	@Test
	public void 加算_範囲外_9test() throws IllegalArgumentExceptionY{
		try {
			calc.add(-101, 100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑩
	@Test
	public void 加算_範囲外_10test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = 0;
		double actual = calc.add(-100, 100);
		assertEquals(expected, actual);
	}

	//テストケース⑪
	@Test
	public void 加算_範囲外_11test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = 200;
		double actual = calc.add(100, 100);
		assertEquals(expected, actual);
	}

	//テストケース⑫
	@Test
	public void 加算_範囲外_12test() throws IllegalArgumentExceptionY{
		try {
			calc.add(101, 100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑬
	@Test
	public void 加算_範囲外_13test() throws IllegalArgumentExceptionY{
		try {
			calc.add(-101, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑭
	@Test
	public void 加算_範囲外_14test() throws IllegalArgumentExceptionX{
		try {
			calc.add(-100, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑮
	@Test
	public void 加算_範囲外_15test() throws IllegalArgumentExceptionX{
		try {
			calc.add(100, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑯
	@Test
	public void 加算_範囲外_16test() throws IllegalArgumentExceptionY{
		try {
			calc.add(101, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}
	/**
	 * 減算の範囲チェック
	 * ①～⑤⑧⑨⑫～⑯：エラーメッセージが投げられていたらテストOK
	 * ⑥⑦⑩⑪：正確に計算ができていたらテストOK
	 */
	//テストケース①
	@Test
	public void 減算_範囲外_1test() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(-101, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②
	@Test
	public void 減算_範囲外_2test() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(-100, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース③
	@Test
	public void 減算_範囲外_3test() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(100, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース④
	@Test
	public void 減算_範囲外_4test() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(101, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑤
	@Test
	public void 減算_範囲外_5test() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(-101, -100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑥
	@Test
	public void 減算_範囲外_6test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = 0;
		double actual = calc.subtract(-100, -100);
		assertEquals(expected, actual);
	}

	//テストケース⑦
	@Test
	public void 減算_範囲外_7test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = 200;
		double actual = calc.subtract(100, -100);
		assertEquals(expected, actual);
	}

	//テストケース⑧
	@Test
	public void 減算_範囲外_8test() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(101, -100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}


	//テストケース⑨
	@Test
	public void 減算_範囲外_9test() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(-101, 100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑩
	@Test
	public void 減算_範囲外_10test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = -200;
		double actual = calc.subtract(-100, 100);
		assertEquals(expected, actual);
	}

	//テストケース⑪
	@Test
	public void 減算_範囲外_11test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = 0;
		double actual = calc.subtract(100, 100);
		assertEquals(expected, actual);
	}

	//テストケース⑫
	@Test
	public void 減算_範囲外_12test() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(101, 100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑬
	@Test
	public void 減算_範囲外_13test() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(-101, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑭
	@Test
	public void 減算_範囲外_14test() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(-100, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑮
	@Test
	public void 減算_範囲外_15test() throws IllegalArgumentExceptionX{
		try {
			calc.subtract(100, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑯
	@Test
	public void 減算_範囲外_16test() throws IllegalArgumentExceptionY{
		try {
			calc.subtract(101, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	/**
	 * 乗算の範囲チェック
	 * ①～⑤⑧⑨⑫～⑯：エラーメッセージが投げられていたらテストOK
	 * ⑥⑦⑩⑪：正確に計算ができていたらテストOK
	 */
	//テストケース①
	@Test
	public void 乗算_範囲外_1test() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(-101, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②
	@Test
	public void 乗算_範囲外_2test() throws IllegalArgumentExceptionX{
		try {
			calc.multiply(-100, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース③
	@Test
	public void 乗算_範囲外_3test() throws IllegalArgumentExceptionX{
		try {
			calc.multiply(100, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース④
	@Test
	public void 乗算_範囲外_4test() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(101, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑤
	@Test
	public void 乗算_範囲外_5test() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(-101, -100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑥
	@Test
	public void 乗算_範囲外_6test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = 10000;
		double actual = calc.multiply(-100, -100);
		assertEquals(expected, actual);
	}

	//テストケース⑦
	@Test
	public void 乗算_範囲外_7test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = -10000;
		double actual = calc.multiply(100, -100);
		assertEquals(expected, actual);
	}

	//テストケース⑧
	@Test
	public void 乗算_範囲外_8test() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(101, -100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}


	//テストケース⑨
	@Test
	public void 乗算_範囲外_9test() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(-101, 100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑩
	@Test
	public void 乗算_範囲外_10test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = -10000;
		double actual = calc.multiply(-100, 100);
		assertEquals(expected, actual);
	}

	//テストケース⑪
	@Test
	public void 乗算_範囲外_11test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = 10000;
		double actual = calc.multiply(100, 100);
		assertEquals(expected, actual);
	}

	//テストケース⑫
	@Test
	public void 乗算_範囲外_12test() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(101, 100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑬
	@Test
	public void 乗算_範囲外_13test() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(-101, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑭
	@Test
	public void 乗算_範囲外_14test() throws IllegalArgumentExceptionX{
		try {
			calc.multiply(-100, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑮
	@Test
	public void 乗算_範囲外_15test() throws IllegalArgumentExceptionX{
		try {
			calc.multiply(100, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑯
	@Test
	public void 乗算_範囲外_16test() throws IllegalArgumentExceptionY{
		try {
			calc.multiply(101, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	/**
	 * 除算の範囲チェック
	 * ①～⑤⑧⑨⑫～⑯：エラーメッセージが投げられていたらテストOK
	 * ⑥⑦⑩⑪：正確に計算ができていたらテストOK
	 */
	//テストケース①
	@Test
	public void 除算_範囲外_1test() throws IllegalArgumentExceptionY{
		try {
			calc.divide(-101, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース②
	@Test
	public void 除算_範囲外_2test() throws IllegalArgumentExceptionX{
		try {
			calc.divide(-100, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース③
	@Test
	public void 除算_範囲外_3test() throws IllegalArgumentExceptionX{
		try {
			calc.divide(100, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース④
	@Test
	public void 除算_範囲外_4test() throws IllegalArgumentExceptionY{
		try {
			calc.divide(101, -101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑤
	@Test
	public void 除算_範囲外_5test() throws IllegalArgumentExceptionY{
		try {
			calc.divide(-101, -100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑥
	@Test
	public void 除算_範囲外_6test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = 1;
		double actual = calc.divide(-100, -100);
		assertEquals(expected, actual);
	}

	//テストケース⑦
	@Test
	public void 除算_範囲外_7test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = -1;
		double actual = calc.divide(100, -100);
		assertEquals(expected, actual);
	}

	//テストケース⑧
	@Test
	public void 除算_範囲外_8test() throws IllegalArgumentExceptionY{
		try {
			calc.divide(101, -100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}


	//テストケース⑨
	@Test
	public void 除算_範囲外_9test() throws IllegalArgumentExceptionY{
		try {
			calc.divide(-101, 100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑩
	@Test
	public void 除算_範囲外_10test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = -1;
		double actual = calc.divide(-100, 100);
		assertEquals(expected, actual);
	}

	//テストケース⑪
	@Test
	public void 除算_範囲外_11test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		double expected = 1;
		double actual = calc.divide(100, 100);
		assertEquals(expected, actual);
	}

	//テストケース⑫
	@Test
	public void 除算_範囲外_12test() throws IllegalArgumentExceptionY{
		try {
			calc.divide(101, 100);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑬
	@Test
	public void 除算_範囲外_13test() throws IllegalArgumentExceptionY{
		try {
			calc.divide(-101, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//テストケース⑭
	@Test
	public void 除算_範囲外_14test() throws IllegalArgumentExceptionX{
		try {
			calc.divide(-100, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑮
	@Test
	public void 除算_範囲外_15test() throws IllegalArgumentExceptionX{
		try {
			calc.divide(100, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionY e) {
		}
	}

	//テストケース⑯
	@Test
	public void 除算_範囲外_16test() throws IllegalArgumentExceptionY{
		try {
			calc.divide(101, 101);
			assertTrue(false);
		} catch (IllegalArgumentExceptionX e) {
		}
	}

	//0除算
	@Test
	public void 除算_0除算_1test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY, ArithmeticException{

			double expected = 1;
			double actual = calc.divide(100, 100);
			assertEquals(expected, actual);

	}

	@Test
	public void 除算_0除算_2test() throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{
		try {
			calc.divide(100, 0);
			assertTrue(false);
		} catch (ArithmeticException e) {
		}
	}

}