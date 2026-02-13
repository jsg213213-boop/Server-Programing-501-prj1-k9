package com.busanit501.jsp_server_project1.mapper;


import com.busanit501.jsp_server_project1.springex_0213_keep.mapper.TimeMapper2;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2 // 로그를 기록 하는데, 어떤 기준으로 하나요? 로그레벨
// info, debug , warning
@ExtendWith(SpringExtension.class) // Junit5 단위 테스트 기능 통합 설정
// 빈을 등록한 파일의 위치를 지정, 단위 테스트 할 때, 해당파일를 참고해서, 테스트해줘.
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {

    @Autowired(required = false)
    // 해당 객체를 활성화를 못하더래도, 예외를 발생 안시키고, null 로 할당 하겠다.
    private TimeMapper2 timeMapper2;

    @Test
    public void testGetTime() {
        log.info("시간 확인으로 마이바티스 임시 연결 확인 : " + timeMapper2.getNow());
    }

}
