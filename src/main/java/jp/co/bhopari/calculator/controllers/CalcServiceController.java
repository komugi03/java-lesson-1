package jp.co.bhopari.calculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jp.co.bhopari.calculator.services.CalcService;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionX;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionY;



/**
 * @author bvs20002
 * コントローラ
 */


@Controller
public class CalcServiceController {

	//CalcService型のcalcServiceを定義
	@Autowired
	private CalcService calcService;

	private static final String NAME_SERVRET = "/calc";

	/**
	 * 初期時（計算ボタンを押さなかった場合）
	 */

	@GetMapping(path = NAME_SERVRET)
	public String calc() {
		return "calcservice";
	}


	/**
	 * 計算実行後
	 * @param model モデル
	 * @param inputX 数値入力ボックスXに入力された値
	 * @param inputY 数値入力ボックスYに入力された値
	 * @param operator 演算方法選択ボックスで選択された演算子
	 * @return 計算結果
	 */

	//サーブレットを指定
	@GetMapping(path = NAME_SERVRET, params = "do")
	public String calc(Model model,
				@ModelAttribute("inputX") String inputX,
				@ModelAttribute("inputY") String inputY,
				@ModelAttribute("operator") Operator operator) {

		int numX = 0;
		int numY = 0;

		//チェック処理
		//何も入力されていない時の例外
		if(inputX == null || inputX.equals("")) {
			model.addAttribute("errorMessage", "エラー：左側のボックスに値を入力してください");
			return "calcservice";
		}
		if(inputY == null || inputY.equals("")) {
			model.addAttribute("errorMessage", "エラー：右側のボックスに値を入力してください");
			return "calcservice";
		}

		//整数ではない時の例外
		try {
			numX = Integer.parseInt(inputX);
		} catch (NumberFormatException e){
			model.addAttribute("errorMessage", "エラー：左側のボックスに整数を入力してください");
			return "calcservice";
		}

		try {
			numY = Integer.parseInt(inputY);
		} catch (NumberFormatException e){
			model.addAttribute("errorMessage", "エラー：右側のボックスに整数を入力してください");
			return "calcservice";
		}


		//メイン処理
		try {
			//計算結果を初期化
			double answerZ = 0;


			//計算サービスの呼び出し(選択された演算子によって分岐)
			switch(operator) {
			case ADD:
				answerZ = calcService.add(numX, numY);
				model.addAttribute("enzanshi", "add");
				break;
			case SUBTRACT:
				answerZ = calcService.subtract(numX, numY);
				model.addAttribute("enzanshi", "subtract");
				break;
			case MULTIPLY:
				answerZ = calcService.multiply(numX, numY);
				model.addAttribute("enzanshi", "multiply");
				break;
			case DIVIDE:
				answerZ = calcService.divide(numX, numY);
				model.addAttribute("enzanshi", "divide");
				break;
			}

			//計算結果を四捨五入し、文字列に変換（ビューに表示するanswerを定義）
			double answerDouble = ((double)Math.round(answerZ * 100))/100;
			String answer = String.valueOf(answerDouble);
			model.addAttribute("answer", answer);


			//メイン処理の例外処理
			//Xが範囲外の時の例外
		} catch (IllegalArgumentExceptionX e) {
			model.addAttribute("errorMessage", "エラー：左側のボックスに-100から 100までの値を入力してください");


			//Yが範囲外の時の例外
		} catch (IllegalArgumentExceptionY e) {
			model.addAttribute("errorMessage", "エラー：右側のボックスに-100から 100までの値を入力してください");


			//0除算例外
		} catch (ArithmeticException e) {
			model.addAttribute("errorMessage", "エラー：0では除算できません");
		}

		//HTMLファイルを指定
		return "calcservice";

	}

}