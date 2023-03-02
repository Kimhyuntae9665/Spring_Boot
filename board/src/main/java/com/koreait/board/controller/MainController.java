package com.koreait.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.Service.MainService;
import com.koreait.board.dto.GetTestResponseDto;
import com.koreait.board.dto.PostTestRequestDto;
import com.koreait.board.dto.ResponseDto;

// 해당 클래스를 REST API로 사용되는 Controller로 지정 할 수 있음 
// Controller = react의 Route와 비슷 
@RestController

//  해당 클래스를 특정 Request URL 패턴에서 사용하도록 지정 

@RequestMapping("apis")
public class MainController {



	// # Autowired
	// ? @Component ??? ?? ?? ???? ?? ??? ???? ??? ?? 
	// ? @Service? ?? ????? @Component? ?? ?? ?? 
	@Autowired
	private MainService mainService;
	

	@GetMapping("/")
	public ResponseDto<String> getMain() {
		
		ResponseDto result = mainService.getMain();
		return result;
	}
	
	
	
	
//	PathVariable(path): GET/DELETE 방식에서 사용할 수 있음 
//						URL Path로 클라이언트로부터 데이터를 받아서 변수로 사용할 수 있게 함 
	@GetMapping("/variable/{data}")
	public String getVariable(@PathVariable("data") String dataa) {

		String result = mainService.getVariable(dataa);
		return result;
	}
	
	
//	HTTP 메서드 중 POST 방식의 요청에 대한 처리를 저장할 때 사용 
	@PostMapping("/")
	public String postMain() {

		String result = mainService.postMain();
		return result;
	}
	
	
//	@ RequestBody : POST/PATCH 방식에서 사용 가능 
//					클라이언트로 부터 request body로 데이터를 받고자 할 때 사용 가능  
	@PostMapping("/requestBody")
	public String postRequestBody(@RequestBody String data) {
		
		String result = mainService.postRequestBody(data);

		return result; 
	}
	
	
//	HTTP 메서드 중 PATCH 방식의 요청에 대한 처리를 지정할 때 사용 
	@PatchMapping("/")
	public String patchMain() {
		String result = mainService.patchMain();
		return result;
	}
	
//	Http 메서드 중 DELETE 방식의 요청에 대한 처리를 지정 할 떄 사용
	@DeleteMapping("/")
	public String deleteMain() {
		String result = mainService.deleteMain();
		return result;
	}
	
	
//	request body 혹은 response body로 객체를 담을 떄는 Dto를 사용해서 전송 혹은 수신한다 
	@PostMapping("/test")
	public String postTest(@Valid @RequestBody PostTestRequestDto requestDtoBody) {
		String result = mainService.postTest(requestDtoBody);
		return result;
	}
	
	@GetMapping("/test")
	public GetTestResponseDto getTest(){

		GetTestResponseDto result = mainService.getTest();
		return result;
	}
}
