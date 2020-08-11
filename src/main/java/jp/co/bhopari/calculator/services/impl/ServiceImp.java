package jp.co.bhopari.calculator.services.impl;

import org.springframework.stereotype.Service;

import jp.co.bhopari.calculator.services.CalcService;

@Service
public class ServiceImp implements CalcService{		//インプリメンツ


	@Override
	//加算メソッド
	public double add (int x, int y){

		if(x >= -100 && x <= 100) {			//入力値X範囲チェック
			throw new IllegalArgumentException();
		}else if(y >= -100 && y <= 100) {	//入力値Y範囲チェック
			throw new IllegalArgumentException();
		}else {

			//計算
			double res = x + y;
			return res;
		}
	}

	@Override
	//減算メソッド
	public double sub(int x, int y){

		if(x >= -100 && x <= 100) {			//入力値X範囲チェック
			throw new IllegalArgumentException();
		}else if(y >= -100 && y <= 100) {	//入力値Y範囲チェック
			throw new IllegalArgumentException();
		}else {

			//計算
			double res = x -y;
			return res;
		}
	}

	@Override
	//乗算メソッド
	public double mul(int x, int y){

		if(x >= -100 && x <= 100) {			//入力値X範囲チェック
			throw new IllegalArgumentException();
		}else if(y >= -100 && y <= 100) {	//入力値Y範囲チェック
			throw new IllegalArgumentException();
		}else {

			//計算
			double res = x * y;
			return res;
		}
	}


	@Override
	//除算メソッド
	public double div(int x, int y){

		if(x >= -100 && x <= 100) {			//入力値X範囲チェック
			throw new IllegalArgumentException();
		}else if(y >= -100 && y <= 100) {	//入力値Y範囲チェック
			throw new IllegalArgumentException();
		}else if(y == 0){					//0除算チェック
			throw new ArithmeticException();
		}else {

			//計算
			double res = x / y;
			return res;
		}
	}


}
