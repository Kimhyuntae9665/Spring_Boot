package com.koreait.board.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.dto.GetTestResponseDto;
import com.koreait.board.dto.PostTestRequestDto;

// �ش� Ŭ������ REST API�� ���Ǵ� Controller�� ���� �� �� ���� 
// Controller = react�� Route�� ��� 
@RestController

//  �ش� Ŭ������ Ư�� Request URL ���Ͽ��� ����ϵ��� ���� 
@RequestMapping("apis")

public class MainController {
	
//	HTTP �޼��� �� GET ����� ��û�� ���� ó���� ������ �� ��� 
	
//	**@GetMapping(path)**
//- REST API�� GET method�� �̿��� Request �� ��path("/")���� �ش��ϴ� end-point�� ���� ������� ���
//	 �������� URL ġ�� ���� ���� GET ������θ� ���� ���� POST ������δ� ���� �Ұ� 
	@GetMapping("/")
	public String getMain() {
		return "Hello World";
	}
	
	
	
	
//	PathVariable(path): GET/DELETE ��Ŀ��� ����� �� ���� 
//						URL Path�� Ŭ���̾�Ʈ�κ��� �����͸� �޾Ƽ� ������ ����� �� �ְ� �� 
	@GetMapping("/variable/{data}")
	public String getVariable(@PathVariable("data") String dataa) {
		return "You input data is "  + dataa;
	}
	
	
//	HTTP �޼��� �� POST ����� ��û�� ���� ó���� ������ �� ��� 
	@PostMapping("/")
	public String postMain() {
		return "POST main Response!!!! ";
	}
	
	
//	@ RequestBody : POST/PATCH ��Ŀ��� ��� ���� 
//					Ŭ���̾�Ʈ�� ���� request body�� �����͸� �ް��� �� �� ��� ����  
	@PostMapping("/requestBody")
	public String postRequestBody(@RequestBody String data) {
		return "Post body data is " + data;
	}
	
	
//	HTTP �޼��� �� PATCH ����� ��û�� ���� ó���� ������ �� ��� 
	@PatchMapping("/")
	public String patchMain() {
		return "Pathch �޼���� ���� �۾��� ������ �޼��� �Դϴ� Ŭ���̾�Ʈ�κ��� �����͸� ���� �� request Bosy�� �޽��ϴ� ";
	}
	
//	Http �޼��� �� DELETE ����� ��û�� ���� ó���� ���� �� �� ���
	@DeleteMapping("/")
	public String deleteMain() {
		return "Delete �޼���� ���� �۾��� ������ �޼����Դϴ�. Ŭ���̾�Ʈ�κ��� �����͸� ���� �� path variable�� �޽��ϴ� ";
	}
	
	
//	request body Ȥ�� response body�� ��ü�� ���� ���� Dto�� ����ؼ� ���� Ȥ�� �����Ѵ� 
	@PostMapping("/test")
	public String postTest(@Valid @RequestBody PostTestRequestDto requestDtoBody) {
		return requestDtoBody.toString();
	}
	
	@GetMapping("/test")
	public GetTestResponseDto getTest(){
		return new GetTestResponseDto(10, "Rooney");
	}
}
