package com.busanit501.jsp_server_project1.service;

import com.busanit501.jsp_server_project1._0204_todo.dto._0204_1_TodoDTO;
import com.busanit501.jsp_server_project1._0204_todo.service._0204_4_TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class _0204_6_TodoServiceTests {
    // 외부 기능을 담당하는 클래스를 가져오기.

    // 서비스 기능을 담당하는 클래스 불러오기.
    // 전역으로 선언만 하구요, 실제 사용은 밑에서 초기화해서, 사용할수 있는 형태로 만들기.
    private _0204_4_TodoService todoService;

    @BeforeEach
    public void ready() {
        // 여기서, 전역으로 선언된 변수를 초기화해서, 사용할수 있게 만들기.
        // 다른 메서드안에서도, todoService를 이용할수 있다.
        todoService = _0204_4_TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        // 1) DB  서버에 일을 시키는 클래스 미리 만들었음.
        // 2) 서비스 클래스 만들어서, 어떤 기능을 하는지를 명확하게 메모화.
        // 3) 서비스에서, 기능들을 만들어서, 1) 클래스에 연결시키기.
        // 준비물) 글쓰기 -> 글 제목, 날짜, 완료 여부
        // 화면에서 데이터 받고서 -> TodoDTO에 담기. -> 서비스에 전달.
        _0204_1_TodoDTO todoDTO = _0204_1_TodoDTO.builder()
                .title("샘플 제목, 오늘 점심 뭐 먹지?")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();

        todoService.register(todoDTO);
    }

}
