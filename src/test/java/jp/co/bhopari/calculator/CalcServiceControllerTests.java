package jp.co.bhopari.calculator;

import static org.mockito.ArgumentMatchers.*;

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
import jp.co.bhopari.calculator.services.IllegalArgumentExceptionY;
/**
 * @author bvs20002
 * コントローラの単体テスト
 */

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

	//初期時（計算ボタンを押さなかった場合）
	@Test
	public void 初期画面表示() throws Exception{

		//リクエストの発行
		mockMvc.perform(get("/calc")
				.param("inputX", "100")
				.param("inputY", "100")
				.param("operator", "ADD"))

			//Web特有 指定のview(CalcService.html)を返すか？
			.andExpect(view().name("calcservice"))

			//Web特有 HTTPステータスコードのテストなのでstatus()を使う
			.andExpect(status().isOk());

	}

	//X入力チェックnull
	@Test
	public void 未入力エラー確認_X_null() throws Exception {
		//モックアップの設定
		when(calc.add(anyInt(), anyInt()))
			.thenReturn(0.0);

		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc")
				.param("inputX", (String)null)
				.param("inputY", "23")
				.param("operator", "ADD")
				.param("do", "計算"))
			.andExpect(model().attribute("errorMessage", "エラー：左側のボックスに値を入力してください"))

			//Web特有 指定のview(CalcService.html)を返すか？
			.andExpect(view().name("calcservice"))

			//Web特有 HTTPステータスコードのテストなのでstatus()を使う
			.andExpect(status().isOk());

		//addメソッドが呼ばれていないことを確認
		verify(calc, times(0)).add(anyInt(), anyInt());
	}

	//X入力チェック("")
	@Test
	public void 未入力エラー確認_X_値なし() throws Exception {
		//モックアップの設定
		when(calc.add(anyInt(), anyInt()))
			.thenReturn(0.0);

		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc")
				.param("inputX", "")
				.param("inputY", "23")
				.param("operator", "ADD")
				.param("do", "計算"))
			.andExpect(model().attribute("errorMessage", "エラー：左側のボックスに値を入力してください"))

			//Web特有 指定のview(CalcService.html)を返すか？
			.andExpect(view().name("calcservice"))

			//Web特有 HTTPステータスコードのテストなのでstatus()を使う
			.andExpect(status().isOk());

		//addメソッドが呼ばれていないことを確認
		verify(calc, times(0)).add(anyInt(), anyInt());
	}


	//Y入力チェックnull
	@Test
	public void 未入力エラー確認_Y_null() throws Exception {
		//モックアップの設定
		when(calc.add(anyInt(), anyInt()))
			.thenReturn(0.0);

		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc")
				.param("inputX", "100")
				.param("inputY", (String)null)
				.param("operator", "ADD")
				.param("do", "計算"))
			.andExpect(model().attribute("errorMessage", "エラー：右側のボックスに値を入力してください"))

			//Web特有 指定のview(CalcService.html)を返すか？
			.andExpect(view().name("calcservice"))

			//Web特有 HTTPステータスコードのテストなのでstatus()を使う
			.andExpect(status().isOk());

		//addメソッドが呼ばれていないことを確認
		verify(calc, times(0)).add(anyInt(), anyInt());
	}

	//Y入力チェック("")
	@Test
	public void 未入力エラー確認_Y_値なし() throws Exception {
		//モックアップの設定
		when(calc.add(anyInt(), anyInt()))
			.thenReturn(0.0);

		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc")
				.param("inputX", "100")
				.param("inputY", "")
				.param("operator", "ADD")
				.param("do", "計算"))
		.andExpect(model().attribute("errorMessage", "エラー：右側のボックスに値を入力してください"))

			//Web特有 指定のview(CalcService.html)を返すか？
			.andExpect(view().name("calcservice"))

			//Web特有 HTTPステータスコードのテストなのでstatus()を使う
			.andExpect(status().isOk());

		//addメソッドが呼ばれていないことを確認
		verify(calc, times(0)).add(anyInt(), anyInt());
	}

	//X整数チェック
	@Test
	public void 非整数エラー確認_X() throws Exception {
		//モックアップの設定
		when(calc.add(anyInt(), anyInt()))
			.thenReturn(0.0);

		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc")
				.param("inputX", "99.9")
				.param("inputY", "23")
				.param("operator", "ADD")
				.param("do", "計算"))
			.andExpect(model().attribute("errorMessage", "エラー：左側のボックスに整数を入力してください"))

			//Web特有 指定のview(CalcService.html)を返すか？
			.andExpect(view().name("calcservice"))

			//Web特有 HTTPステータスコードのテストなのでstatus()を使う
			.andExpect(status().isOk());

		//addメソッドが呼ばれていないことを確認
		verify(calc, times(0)).add(anyInt(), anyInt());
	}

	//Y整数チェック
	@Test
	public void 非整数エラー確認_Y() throws Exception {
		//モックアップの設定
		when(calc.add(anyInt(), anyInt()))
			.thenReturn(0.0);

		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc")
				.param("inputX", "100")
				.param("inputY", "99.9")
				.param("operator", "ADD")
				.param("do", "計算"))
			.andExpect(model().attribute("errorMessage", "エラー：右側のボックスに整数を入力してください"))

			//Web特有 指定のview(CalcService.html)を返すか？
			.andExpect(view().name("calcservice"))

			//Web特有 HTTPステータスコードのテストなのでstatus()を使う
			.andExpect(status().isOk());

		//addメソッドが呼ばれていないことを確認
		verify(calc, times(0)).add(anyInt(), anyInt());
	}


	//加算サービスを呼び出せているか
	@Test
	public void 加算_サービス呼び出し() throws Exception {

		//モックアップの設定
		when(calc.add(100,23))
			.thenReturn(123.0);

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
	}

	//減算サービスを呼び出せているか
	@Test
	public void 減算_サービス呼び出し減算() throws Exception {

		//モックアップの設定
		when(calc.subtract(100,23))
			.thenReturn(77.0);

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

		//subtractメソッドが一度呼び出されたことを確認
		verify(calc, times(1)).subtract(100, 23);
	}

	//乗算サービスを呼び出せているか
	@Test
	public void 乗算_サービス呼び出し() throws Exception {

		//モックアップの設定
		when(calc.multiply(100,23))
			.thenReturn(12300.0);

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

		//multiplyメソッドが一度呼び出されたことを確認
		verify(calc, times(1)).multiply(100, 23);
	}

	//除算サービスを呼び出せているか
	@Test
	public void 除算_サービス呼び出し除算() throws Exception {

		//モックアップの設定
		when(calc.divide(100,23))
			.thenReturn(4.35);

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

		//divideメソッドが一度呼び出されたことを確認
		verify(calc, times(1)).divide(100, 23);

	}

	//UnsupportedOperationExceptionが出るか
		@Test
		public void UnsupportedOperationExceptionが出るか() throws Exception {

			//リクエストの発行(今回はWebからのリクエスト)
			mockMvc.perform(get("/calc")
					.param("inputX", "100")
					.param("inputY", "23")
					.param("operator", "UUU")
					.param("do", "計算"))
				.andExpect(model().attribute("errorMessage", "エラー：サポート外です"))

				//Web特有 指定のview(CalcService.html)を返すか？
				.andExpect(view().name("calcservice"))

				//Web特有 HTTPステータスコードのテストなのでstatus()を使う
				.andExpect(status().isOk());

			//divideメソッドが一度呼び出されたことを確認
			verify(calc, times(1)).divide(100, 23);

		}

	//X範囲外チェック
	@Test
	public void 範囲外_X() throws Exception{

		//モックアップの設定
		when(calc.add(101,23))
			.thenThrow(new IllegalArgumentExceptionX());

		//リクエストの発行
		mockMvc.perform(get("/calc")
				.param("inputX", "101")
				.param("inputY", "23")
				.param("operator", "ADD")
				.param("do", "計算"))

			.andExpect(model().attribute("errorMessage", "エラー：左側のボックスに-100から 100までの値を入力してください"))

			//Web特有 指定のview(CalcService.html)を返すか？
			.andExpect(view().name("calcservice"))

			//Web特有 HTTPステータスコードのテストなのでstatus()を使う
			.andExpect(status().isOk());

		//addメソッドが一度呼び出されたことを確認
		verify(calc, times(1)).add(101, 23);
	}

	//Y範囲外チェック
	@Test
	public void 範囲外_Y() throws Exception{

		//モックアップの設定
		when(calc.add(100,101))
			.thenThrow(new IllegalArgumentExceptionY());

		//リクエストの発行
		mockMvc.perform(get("/calc")
				.param("inputX", "100")
				.param("inputY", "101")
				.param("operator", "ADD")
				.param("do", "計算"))

			.andExpect(model().attribute("errorMessage", "エラー：右側のボックスに-100から 100までの値を入力してください"))
			//Web特有 指定のview(CalcService.html)を返すか？
			.andExpect(view().name("calcservice"))

			//Web特有 HTTPステータスコードのテストなのでstatus()を使う
			.andExpect(status().isOk());

		//addメソッドが一度呼び出されたことを確認
		verify(calc, times(1)).add(100, 101);

	}

	//0除算チェック
	@Test
	public void 除算_0除算() throws Exception{

		//モックアップの設定
		when(calc.divide(100,0))
			.thenThrow(new ArithmeticException());

		//リクエストの発行
		mockMvc.perform(get("/calc")
				.param("inputX", "100")
				.param("inputY", "0")
				.param("operator", "DIVIDE")
				.param("do", "計算"))

			.andExpect(model().attribute("errorMessage", "エラー：0では除算できません"))

			//Web特有 指定のview(CalcService.html)を返すか？
			.andExpect(view().name("calcservice"))

			//Web特有 HTTPステータスコードのテストなのでstatus()を使う
			.andExpect(status().isOk());

		//divideメソッドが一度呼び出されたことを確認
		verify(calc, times(1)).divide(100, 0);

	}

}