package com.koreait.board.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //  getter,setter 포함 
@AllArgsConstructor //모든 인수를 가지는 생성자 
@NoArgsConstructor  // 빈 생성자 == 기본생성자 생성 
@Entity(name = "Exanple") //(name = )안에는 Entity의 별명이 
@Table(name = "Example")
public class Example_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int prime;
    private String comment;
    private int number;
}
