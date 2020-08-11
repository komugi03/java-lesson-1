package jp.co.bhopari.calculator.services.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import jp.co.bhopari.calculator.services.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt();
	}

	@Override
	public int getValue(int x) {
		if(x == 0) {
			throw new IllegalArgumentException();
		}



		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
