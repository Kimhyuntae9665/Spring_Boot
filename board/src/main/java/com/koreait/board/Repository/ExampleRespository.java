package com.koreait.board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.board.Entity.Example_Entity;


// # @Repository
// ? 해당 인터페이스를 Repository로 사용하도록 지정하는 어노테이션 
@Repository
// ? JpaRepository<T,ID> : 해당 인터페이스를 상속받은 인터페이스를 
// ? JPA QUERY Creation을 사용할 수 있도록하는 인터페이스 
// ? T : 데이터페이스의 테이블을 구현한 Entity class
// ?  ID : 해당 Entity Primary Key의 타입 
public interface ExampleRespository extends JpaRepository<Example_Entity,Integer> {// Generic 에는 기본 datatype을 쓸 수 없다 

    // ^ select * 과 같ㅌ은 의미 findBy Entity 테이블에서 가져온다 
    public Example_Entity findByComment(String comment);
}
