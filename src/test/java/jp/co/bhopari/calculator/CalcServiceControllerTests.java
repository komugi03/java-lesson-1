package jp.co.bhopari.calculator;

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

//コントローラのテスト
@SpringBootTest
public class CalcServiceControllerTests {

	MockMvc mockMvc;

	//Autowiredでコントローラをnewする
	@Autowired
	CalcServiceController cont;

	//モック化したサービスを作る
	@MockBean
	CalcService calc;	//CalcServiceはインターフェース

	@BeforeEach		//それぞれのテストの前に実行されるもの
	public void setup() {
		mockMvc = MockMvcBuilders
					.standaloneSetup(cont)
					.build();
	}

	@Test
	public void test() throws Exception {

		//テスト1　モデルの中身が123か確認↓

		//モックアップを設定する。テストサービスのaddが呼び出されたときに、123か確認したい。
		//加算
		when(calc.add(100,23))
			.thenReturn(123.0);

		//減算
		when(calc.subtract(100,23))
		.thenReturn(123.0);

		//乗算
		when(calc.multiply(100,23))
		.thenReturn(123.0);

		//除算
		when(calc.divide(100,23))
		.thenReturn(123.0);

		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/calc"))
				.andExpect(model().attribute("answer",123.0))
												//変数名, 期待値
				.andExpect(view().name("CalcService"))	//Web特有 指定のview(CalcService.html)を返すか？
				.andExpect(status().isOk());	//Web特有 HTTPステータスコードのテストなのでstatus()を使う

// 		//テスト2　TestService#getRandomNumber()が呼ばれていることを確認↓
//		verify(calc, times(1)).add();
//		//↑で、testServiceというモックの.getRandomNumber()が一回返ってきたことを確認できる

	}


}