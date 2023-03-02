package com.koreait.board.Service;

import org.springframework.stereotype.Service;

import com.koreait.board.dto.GetTestResponseDto;
import com.koreait.board.dto.PostTestRequestDto;
import com.koreait.board.dto.ResponseDto;


// # Service 
// ? 실제 비즈니스 로직을 담당하는 레이어 
// ? 일반적인 연산작업
// ? Controller로 사용자의 입력을 받아오면 해당기능을 진행하기 위해 
// ? Repository에서 데이터를 가져와 작업을 진행함 
// ? Service에서 Controller로 넘겨준디 
@Service
public class MainService {

    

    public ResponseDto<String> getMain(){

        ResponseDto<String> result = ResponseDto.setSuccess("sucess", "Hello hoodoo");
        return result;
    }

    
    
   

    // ? 자바에서 자바를 호출 하는 것 
    public String getVariable(String dataa){

        return "You input data is "  + dataa;
    }


    public String postMain(){
        return "POST main Response!";
    }
    public String postRequestBody(String data){

         return "Post body data is " + data;
    }

    public String patchMain(){
        return "Patch 메서드는 수정 작업을 지정한 메서드 입니다 ";
    }

    public String deleteMain(){
        return "delete 메서드는 삭제 작업을 지정한 메서드 입니다 ";

    }

    public String postTest(PostTestRequestDto dto){
        return dto.toString();
    }

    public GetTestResponseDto getTest(){
        return new GetTestResponseDto(10,"Comment");
    }
}
