package org.iclass.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestControllerMapping {
	private static final Map<RequestKeyValue,Controller> mapping = new HashMap<>();
	
	public static void init() {
		//로그인 기능 : 아래 3개의 컨트롤러를 구현하기 - LoginAction 에서 dao의 login메소드 사용하기
		mapping.put(new RequestKeyValue("/login.hrd", "GET"), new LoginViewController());
		mapping.put(new RequestKeyValue("/login.hrd", "POST"), new LoginActionController());
		mapping.put(new RequestKeyValue("/logout.hrd", "GET"), new LogoutController());
		
	}
	//url,method 필드를 저장하는 key 를 전달받아 HashMap에서 value(컨트롤러)를 리턴
	public static Controller getController(RequestKeyValue key) {
		return mapping.get(key);
	}
}