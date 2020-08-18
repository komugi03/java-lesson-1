package jp.co.bhopari.calculator.services;

/**
 * @author bvs20002
 * 計算機能を提供するサービス
 */
//インターフェース
public interface CalcService {

	//計算

	/**
	 * 与えられた数を加算する。
	 * @param x 数値入力ボックスXに入力された値
	 * @param y 数値入力ボックスYに入力された値
	 * @return 計算結果
	 * @throws IllegalArgumentExceptionX 与えられた値 x が、-100～100の範囲外だった場合に出るエラー
	 * @throws IllegalArgumentExceptionY 与えられた値 y が、-100～100の範囲外だった場合に出るエラー
	 */
	double add(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY;

	/**
	 * 与えられた数を減算する。
	 * @param x 数値入力ボックスXに入力された値
	 * @param y 数値入力ボックスYに入力された値
	 * @return 計算結果
	 * @throws IllegalArgumentExceptionX 与えられた値 x が、-100～100の範囲外だった場合に出るエラー
	 * @throws IllegalArgumentExceptionY 与えられた値 y が、-100～100の範囲外だった場合に出るエラー
	 */
	double subtract(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY;

	/**
	 * 与えられた数を乗算する。
	 * @param x 数値入力ボックスXに入力された値
	 * @param y 数値入力ボックスYに入力された値
	 * @return 計算結果
	 * @throws IllegalArgumentExceptionX 与えられた値 x が、-100～100の範囲外だった場合に出るエラー
	 * @throws IllegalArgumentExceptionY 与えられた値 y が、-100～100の範囲外だった場合に出るエラー
	 */
	double multiply(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY;

	/**
	 * 与えられた数を除算する。
	 * @param x 数値入力ボックスXに入力された値
	 * @param y 数値入力ボックスYに入力された値
	 * @return 計算結果
	 * @throws IllegalArgumentExceptionX 与えられた値 x が、-100～100の範囲外だった場合に出るエラー
	 * @throws IllegalArgumentExceptionY 与えられた値 y が、-100～100の範囲外だった場合に出るエラー
	 */
	double divide(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY;

}
