package com.busanit501.jsp_server_project1.mapper;


import com.busanit501.jsp_server_project1.springex_new_0219_keep.domain.TodoVO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2 // 로그를 기록 하는데, 어떤 기준으로 하나요? 로그레벨
// info, debug , warning
@ExtendWith(SpringExtension.class) // Junit5 단위 테스트 기능 통합 설정
// 빈을 등록한 파일의 위치를 지정, 단위 테스트 할 때, 해당파일를 참고해서, 테스트해줘.
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    // 해당 객체를 활성화를 못하더래도, 예외를 발생 안시키고, null 로 할당 하겠다.
    private TodoMapper todoMapper;

    @Test
    public void testGetTime() {
        log.info("시간 확인으로 마이바티스 임시 연결 확인 : " + todoMapper.getTime());
    }

    @Test
    public void testInsert() {
        // 준비물, 화면에서 넘겨받은 TodoVO 있다고 가정, 또는 더미 데이터 준비.
        TodoVO todoVO = TodoVO.builder()
                .title("오늘 점심 뭐 먹죠?")
                .dueDate(LocalDate.now())
                .writer("이상용")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(vo -> log.info(vo));

    }
}
