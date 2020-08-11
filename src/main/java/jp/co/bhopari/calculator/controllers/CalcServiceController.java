package jp.co.bhopari.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalcServiceController {		//コントローラ

	//チェック処理

	//入力値X入力チェック
	{}catch(NullPointerException e) {}


	//計算

	@GetMapping("/")
	public String show(Model model) {		//表示メソッド
		return "";

	}

}
