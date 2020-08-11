package jp.co.bhopari.calculator.controllers;	//コントローラ

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.bhopari.calculator.services.TestService;

@Controller
public class HelloWorldControllers {

	@Autowired
	private TestService testService;

	@GetMapping("/")
	public String show(Model model) {

		//"message"にtestService.getRandomNumber()を入れてる
		model.addAttribute("message", testService.getRandomNumber());
		//↑test～をコメントアウトして100にしてみると、テストが赤くなる
		//↑test～をコメントアウトして123にしてみると、テスト1はくぐりぬけてもテスト2でひっかかるからが赤くなる

		return "helloworld";
	}

}
