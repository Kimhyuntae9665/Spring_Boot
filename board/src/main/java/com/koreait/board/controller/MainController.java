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

// ?? ???? REST API? ???? Controller? ?? ? ? ?? 
// Controller = react? Route? ?? 
@RestController
//  ?? ???? ?? Request URL ???? ????? ?? 
@RequestMapping("apis")
public class MainController {



	// # Autowired
	// ? @Component annotation ?? class? ???? class ?? 
	// ? @Service? ctrl ?? ???? ????? @Component? ?? ??  
	@Autowired
	private MainService mainService;
	

	@GetMapping("/")
	public ResponseDto<String> getMain() {
		
		ResponseDto result = mainService.getMain();
		return result;
	}
	
	
	
	
//	PathVariable(path): GET/DELETE ???? ??? ? ?? 
//						URL Path? ???????? ???? ??? ??? ??? ? ?? ? 
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
	
	
//	@ RequestBody : POST/PATCH ???? ?? ?? 
//					?????? ?? request body? ???? ??? ? ? ?? ??  
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
	
	//	request body ?? response body? ??? ?? ?? Dto? ???? ?? ?? ???? 
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
