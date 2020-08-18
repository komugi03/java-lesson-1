package jp.co.bhopari.calculator.services.impl;
/**
 * @author bvs20002
 * 計算機能を提供するサービス
 */

import org.springframework.stereotype.Service;

import jp.co.bhopari.calculator.services.CalcService;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionX;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionY;

//実装したクラス
@Service
public class CalcServiceImpl implements CalcService{

	//加算メソッドの数値入力ボックスX、Yにそれぞれ入力できる範囲の最大値と最小値
	private static final int ADD_X_MAX = 100;
	private static final int ADD_X_MIN = -100;
	private static final int ADD_Y_MAX = 100;
	private static final int ADD_Y_MIN = -100;

	//減算メソッドの数値入力ボックスX、Yにそれぞれ入力できる範囲の最大値と最小値
	private static final int SUBTRACT_X_MAX = 100;
	private static final int SUBTRACT_X_MIN = -100;
	private static final int SUBTRACT_Y_MAX = 100;
	private static final int SUBTRACT_Y_MIN = -100;

	//乗算メソッドの数値入力ボックスX、Yにそれぞれ入力できる範囲の最大値と最小値
	private static final int MULTIPLY_X_MAX = 100;
	private static final int MULTIPLY_X_MIN = -100;
	private static final int MULTIPLY_Y_MAX = 100;
	private static final int MULTIPLY_Y_MIN = -100;

	//除算メソッドの数値入力ボックスX、Yにそれぞれ入力できる範囲の最大値と最小値
	private static final int DIVIDE_X_MAX = 100;
	private static final int DIVIDE_X_MIN = -100;
	private static final int DIVIDE_Y_MAX = 100;
	private static final int DIVIDE_Y_MIN = -100;

	/**
	 * {@inheritDoc}
	 */
	@Override
	//加算メソッド
	public double add(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		//入力値X範囲チェック
		if (x < ADD_X_MIN || x > ADD_X_MAX) {
			throw new IllegalArgumentExceptionX();

		//入力値Y範囲チェック
		} else if (y < ADD_Y_MIN || y > ADD_Y_MAX) {
			throw new IllegalArgumentExceptionY();
		}

		//計算
		double res = x + y;
		return res;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	//減算メソッド
	public double subtract(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		//入力値X範囲チェック
		if (x < SUBTRACT_X_MIN || x > SUBTRACT_X_MAX) {
			throw new IllegalArgumentExceptionX();

		//入力値Y範囲チェック
		} else if (y < SUBTRACT_Y_MIN || y > SUBTRACT_Y_MAX) {
			throw new IllegalArgumentExceptionY();
		}

		//計算
		double res = x -y;
		return res;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	//乗算メソッド
	public double multiply(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		//入力値X範囲チェック
		if (x < MULTIPLY_X_MIN || x > MULTIPLY_X_MAX) {
			throw new IllegalArgumentExceptionX();

		//入力値Y範囲チェック
		} else if (y < MULTIPLY_Y_MIN || y > MULTIPLY_Y_MAX) {
			throw new IllegalArgumentExceptionY();
		}

		//計算
		double res = x * y;
		return res;

	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	//除算メソッド
	public double divide(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		//入力値X範囲チェック
		if (x < DIVIDE_X_MIN || x > DIVIDE_X_MAX) {
			throw new IllegalArgumentExceptionX();

		//入力値Y範囲チェック
		} else if (y < DIVIDE_Y_MIN || y > DIVIDE_Y_MAX) {
			throw new IllegalArgumentExceptionY();
		//0除算チェック
		} else if (y == 0) {
			throw new ArithmeticException();
		}

		//計算
		double res = x / y;
		return res;

	}
}
