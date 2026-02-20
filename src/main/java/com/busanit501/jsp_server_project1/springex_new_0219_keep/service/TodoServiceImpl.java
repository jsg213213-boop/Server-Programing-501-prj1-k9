package com.busanit501.jsp_server_project1.springex_new_0219_keep.service;

import com.busanit501.jsp_server_project1.springex_new_0219_keep.domain.TodoVO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.dto.TodoDTO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    // 서비스는, 직접적으로 DB에 insert 기능이 있나요?
    // 아니요. 어떻게 ? 1) 직접 만들기 2) 만들어진 것  가져와서 이용한다.
    // 1) TodoMapper 2) DTO -> VO 변환 도구 : ModelMapper
    // 어떻게 가져오죠? 포함 관계, 다른 클래스의 객체를 가져오고,
    // 연결? 1)오토와이어드 2) 롬복을 이용해서, 생성자 주입 방식.
    //2)을 이용해서, 연결하기.
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    // 화면에서, 입력된 정보를 받기 -> DTO담기 -> VO 변환 -> DB 에 전달.
    @Override
    public void register(TodoDTO todoDTO) {
        log.info("서비스 작업: insert 기능 작업중. ");
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info("서비스 작업: insert 기능 변환된 todoVO : " + todoVO);
        todoMapper.insert(todoVO);

    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }
}
