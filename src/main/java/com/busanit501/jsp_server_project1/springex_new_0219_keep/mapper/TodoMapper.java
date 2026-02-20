package com.busanit501.jsp_server_project1.springex_new_0219_keep.mapper;

import com.busanit501.jsp_server_project1.springex_new_0219_keep.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    //추가
    // 화면에서, 입력된 정보를 받기 -> DTO담기 -> VO 변환 -> DB 에 전달.
    void insert(TodoVO todoVO);

    // 전체 목록 조회
    List<TodoVO> selectAll();
}
