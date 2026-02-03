package com.busanit501.jsp_server_project1._0203_todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter // getter 직접 생성안하고, 어노테이션이용하면, 메모리상에 다 만들어져 있다.
@Builder // 객체를 생성시, A a = new A();, 계속 객체를 생성하면서, 이어서 작업합니다.
@ToString // ToString 직접 생성안하고, 어노테이션이용하면, 메모리상에 다 만들어져 있다.
public class _0203_1_TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private  boolean finished;

}
