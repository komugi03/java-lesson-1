package jp.co.bhopari.calculator.services.impl;

import org.springframework.stereotype.Service;

import jp.co.bhopari.calculator.services.CalcService;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionX;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionY;

@Service
public class CalcServiceImpl implements CalcService{		//インプリメンツ


	@Override
	//加算メソッド
	public double add (double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		if(x < -100 || x > 100) {			//入力値X範囲チェック
			throw new IllegalArgumentExceptionX("");
		}else if(y < -100 || y > 100) {	//入力値Y範囲チェック
			throw new IllegalArgumentExceptionY("");
		}else {

			//計算
			double res = x + y;
			return res;
		}
	}

	@Override
	//減算メソッド
	public double sub(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		if(x < -100 || x > 100) {			//入力値X範囲チェック
			throw new IllegalArgumentExceptionX("");
		}else if(y < -100 || y > 100) {	//入力値Y範囲チェック
			throw new IllegalArgumentExceptionY("");
		}else {

			//計算
			double res = x -y;
			return res;
		}
	}

	@Override
	//乗算メソッド
	public double mul(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		if(x < -100 || x > 100) {			//入力値X範囲チェック
			throw new IllegalArgumentExceptionX("");
		}else if(y < -100 || y > 100) {	//入力値Y範囲チェック
			throw new IllegalArgumentExceptionY("");
		}else {

			//計算
			double res = x * y;
			return res;
		}
	}


	@Override
	//除算メソッド
	public double div(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY{

		if(x < -100 || x > 100) {			//入力値X範囲チェック
			throw new IllegalArgumentExceptionX("");
		}else if(y < -100 || y > 100) {	//入力値Y範囲チェック
			throw new IllegalArgumentExceptionY("");
		}else if(y == 0) {		//0除算チェック
			throw new ArithmeticException();
		}else {
			//計算
			double res = x / y;
			return res;
		}
	}
}
