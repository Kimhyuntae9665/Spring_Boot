package com.koreait.board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.board.Entity.Example_Entity;


@Repository

public interface ExampleRespository extends JpaRepository<Example_Entity,Integer> {// Generic 에는 기본 datatype을 쓸 수 없다 
    
}
