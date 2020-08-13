package jp.co.bhopari.calculator.services;

public interface CalcService {	//インターフェース

	//計算

	double add(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY;
	double sub(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY;
	double mul(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY;
	double div(double x, double y) throws IllegalArgumentExceptionX, IllegalArgumentExceptionY;

}
