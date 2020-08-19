package jp.co.bhopari.calculator;

/**
 * コントローラの単体テスト
 */

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.bhopari.calculator.controllers.CalcServiceController;
import jp.co.bhopari.calculator.services.CalcService;
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionX;

@SpringBootTest
public class CalcServiceControllerTests {

	MockMvc mockMvc;

	//Autowiredでコントローラをnewする
	@Autowired
	CalcServiceController cont;

	//モック化したサービスを作る
	@MockBean
	CalcService calc;

	//それぞれのテストの前に実行されるもの
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders
				.standaloneSetup(cont)
				.build();
	}

	@Test
	public void test() throws Exception {


		//加算
		//モックアップを設定する。
		when(calc.add(100,23))
		.thenReturn(123.0);

		//テストサービスのaddが呼び出されたときに123か確認
		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc")
				.param("inputX", "100")
				.param("inputY", "23")
				.param("operator", "ADD")
				.param("do", "計算"))
		.andExpect(model().attribute("answer", "123.0"))

		//Web特有 指定のview(CalcService.html)を返すか？
		.andExpect(view().name("calcservice"))

		//Web特有 HTTPステータスコードのテストなのでstatus()を使う
		.andExpect(status().isOk());

		//addメソッドが一度呼び出されたことを確認
		verify(calc, times(1)).add(100, 23);


		//減算
		//モックアップを設定する。
		when(calc.subtract(100,23))
		.thenReturn(77.0);

		//テストサービスのsubtractが呼び出されたときに123か確認
		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc")
				.param("inputX", "100")
				.param("inputY", "23")
				.param("operator", "SUBTRACT")
				.param("do", "計算"))
		.andExpect(model().attribute("answer", "77.0"))

		//Web特有 指定のview(CalcService.html)を返すか？
		.andExpect(view().name("calcservice"))

		//Web特有 HTTPステータスコードのテストなのでstatus()を使う
		.andExpect(status().isOk());

		//addメソッドが一度呼び出されたことを確認
		verify(calc, times(1)).subtract(100, 23);


		//乗算
		//モックアップを設定する。
		when(calc.multiply(100,23))
		.thenReturn(12300.0);

		//テストサービスのsubtractが呼び出されたときに123か確認
		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc")
				.param("inputX", "100")
				.param("inputY", "23")
				.param("operator", "MULTIPLY")
				.param("do", "計算"))
		.andExpect(model().attribute("answer", "12300.0"))

		//Web特有 指定のview(CalcService.html)を返すか？
		.andExpect(view().name("calcservice"))

		//Web特有 HTTPステータスコードのテストなのでstatus()を使う
		.andExpect(status().isOk());

		//addメソッドが一度呼び出されたことを確認
		verify(calc, times(1)).multiply(100, 23);


		//除算
		//モックアップを設定する。
		when(calc.divide(100,23))
		.thenReturn(4.35);

		//テストサービスのsubtractが呼び出されたときに123か確認
		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc")
				.param("inputX", "100")
				.param("inputY", "23")
				.param("operator", "DIVIDE")
				.param("do", "計算"))
		.andExpect(model().attribute("answer", "4.35"))

		//Web特有 指定のview(CalcService.html)を返すか？
		.andExpect(view().name("calcservice"))

		//Web特有 HTTPステータスコードのテストなのでstatus()を使う
		.andExpect(status().isOk());

		//addメソッドが一度呼び出されたことを確認
		verify(calc, times(1)).divide(100, 23);

	}

	/**
	 * 何も入力されていない時の例外チェック
	 * エラーメッセージが投げられていたらテストOK
	 */
	//テストケース①
	@Test
	public void 加算_範囲外_1test() throws Exception{


		//モックアップを設定する。
		when(calc.add(101,23))
		.thenThrow(new IllegalArgumentExceptionX());

		mockMvc.perform(get("/calc")
				.param("inputX", "101")
				.param("inputY", "23")
				.param("operator", "ADD")
				.param("do", "計算"))

		.andExpect(model().attribute("errorMessage", "エラー：左側のボックスに-100から 100までの値を入力してください"));


	}

}