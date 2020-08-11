package jp.co.bhopari.calculator.services; //インターフェース

public interface TestService {
	/**
	 * ランダムな値を生成する。
	 * @return 生成した値。
	 */
	int getRandomNumber();

	int getValue(int x);
}
