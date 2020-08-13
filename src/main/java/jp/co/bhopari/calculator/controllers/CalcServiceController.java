package jp.co.bhopari.calculator.controllers;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jp.co.bhopari.calculator.services.CalcService;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionX;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionY;

@Controller
public class CalcServiceController {	//コントローラ

	@Autowired
	private CalcService calcService;	//CalcService型のcalcServiceを定義

	@GetMapping("/calc")	//サーブレットを指定
	public String calc(Model model, @ModelAttribute("inputX") String inputX,
			@ModelAttribute("inputY") String inputY, @ModelAttribute("ope") String ope) {

		String errMes = null;

		try {
			//何も入力されていない時の例外
			if(inputX.equals("")) {
				throw new Exception("エラー：左側のボックスに値を入力してください");
			}
			if(inputY.equals("")) {
				throw new Exception("エラー：右側のボックスに値を入力してください");
			}

			//整数ではない時の例外
			int numX = 0;
			int numY = 0;

			try {
				numX = Integer.parseInt(inputX);
			}catch(NumberFormatException e){
				throw new Exception("エラー：左側のボックスに整数を入力してください");
			}

			try {
				numY = Integer.parseInt(inputY);
			}catch(NumberFormatException e){
				throw new Exception("エラー：右側のボックスに整数を入力してください");
			}

			double ansZ = 0;	//計算結果を初期化

			//計算サービスの呼び出し
			switch(ope) {	//選択された演算子によって分岐
			case "＋":
				ansZ = calcService.add(numX, numY);
				break;
			case "－":
				ansZ = calcService.sub(numX, numY);
				break;
			case "×":
				ansZ = calcService.mul(numX, numY);
				break;
			case "÷":
				ansZ = calcService.div(numX, numY);
				break;
			}

			//計算結果を四捨五入し、文字列に変換（ビューに表示するanswerを定義）
			//末尾の0を削除する→DecimalFormat
			DecimalFormat ft = new DecimalFormat("0.##");	//フォーマットの書式を宣言
			String answer = ft.format(ansZ);

			model.addAttribute("answer", answer);	//answerにanswerという名前をつける
			model.addAttribute("flag", true);	//flagという名前にtrueをいれてる？

		}catch(IllegalArgumentExceptionX e) {	//範囲外の時の例外
			errMes = "エラー：左側のボックスに-100から 100までの値を入力してください";
			model.addAttribute("errMes", errMes);	//errMesにerrMesという名前をつける

		}catch(IllegalArgumentExceptionY e) {	//範囲外の時の例外
			errMes = "エラー：右側のボックスに-100から 100までの値を入力してください";
			model.addAttribute("errMes", errMes);	//errMesにerrMesという名前をつける

		}catch(ArithmeticException e) {		//0除算例外
			errMes = "エラー：0では除算できません";
			model.addAttribute("errMes", errMes);	//errMesにerrMesという名前をつける
		}catch(Exception e) {
			errMes = e.getMessage();
			model.addAttribute("errMes", errMes);
		}

		return "calcservice";		//HTMLファイルを指定

		}

}
