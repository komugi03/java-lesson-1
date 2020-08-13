package jp.co.bhopari.calculator;

import org.junit.jupiter.api.BeforeEach;
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
	CalcService calcService;	//CalcServiceはインターフェース

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(cont).build();



}
