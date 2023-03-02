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

// �ش� Ŭ������ REST API�� ���Ǵ� Controller�� ���� �� �� ���� 
// Controller = react�� Route�� ��� 
@RestController

//  �ش� Ŭ������ Ư�� Request URL ���Ͽ��� ����ϵ��� ���� 

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
	
	
	
	
//	PathVariable(path): GET/DELETE ��Ŀ��� ����� �� ���� 
//						URL Path�� Ŭ���̾�Ʈ�κ��� �����͸� �޾Ƽ� ������ ����� �� �ְ� �� 
	@GetMapping("/variable/{data}")
	public String getVariable(@PathVariable("data") String dataa) {

		String result = mainService.getVariable(dataa);
		return result;
	}
	
	
//	HTTP �޼��� �� POST ����� ��û�� ���� ó���� ������ �� ��� 
	@PostMapping("/")
	public String postMain() {

		String result = mainService.postMain();
		return result;
	}
	
	
//	@ RequestBody : POST/PATCH ��Ŀ��� ��� ���� 
//					Ŭ���̾�Ʈ�� ���� request body�� �����͸� �ް��� �� �� ��� ����  
	@PostMapping("/requestBody")
	public String postRequestBody(@RequestBody String data) {
		
		String result = mainService.postRequestBody(data);

		return result; 
	}
	
	
//	HTTP �޼��� �� PATCH ����� ��û�� ���� ó���� ������ �� ��� 
	@PatchMapping("/")
	public String patchMain() {
		String result = mainService.patchMain();
		return result;
	}
	
//	Http �޼��� �� DELETE ����� ��û�� ���� ó���� ���� �� �� ���
	@DeleteMapping("/")
	public String deleteMain() {
		String result = mainService.deleteMain();
		return result;
	}
	
	
//	request body Ȥ�� response body�� ��ü�� ���� ���� Dto�� ����ؼ� ���� Ȥ�� �����Ѵ� 
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
