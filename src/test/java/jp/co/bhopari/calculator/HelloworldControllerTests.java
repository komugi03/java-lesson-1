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

import jp.co.bhopari.calculator.controllers.HelloWorldControllers;
import jp.co.bhopari.calculator.services.TestService;

@SpringBootTest
class HelloworldControllerTests {

	MockMvc mockMvc;


	//コントローラをフィールドに書く
	@Autowired
	HelloWorldControllers controller;

	//モック化したテストサービスを作る
	@MockBean	//Beanだとモックを勝手にDIしてくれる
	TestService testService;

	@BeforeEach	//それぞれのテストの前に実行されるもの
	public void setup() {
		mockMvc = MockMvcBuilders
					.standaloneSetup(controller)
					.build();
	}


	@Test
	public void test() throws Exception {

		//テスト1　モデルの中身が123か確認↓

		//モックアップを設定する。テストサービスのRandom～が呼び出されたときに、123か確認したい。
		when(testService.getRandomNumber())
			.thenReturn(123);

		//リクエストの発行(今回はWebからのリクエスト)
		mockMvc.perform(get("/"))
				.andExpect(model().attribute("message",123))
												//名前	//期待値
				.andExpect(view().name("helloworld"))	//Web特有
				.andExpect(status().isOk());	//Web特有

		//テスト2　TestService#getRandomNumber()が呼ばれていることを確認↓
		verify(testService, times(1)).getRandomNumber();
		//↑で、testServiceというモックの.getRandomNumber()が一回返ってきたことを確認できる

	}

}
