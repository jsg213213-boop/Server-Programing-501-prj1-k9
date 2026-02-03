package com.busanit501.jsp_server_project1._0203_todo.dao;

import com.busanit501.jsp_server_project1._0203_todo.domain._0203_1_TodoVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class _0203_4_TodoDAO {
    // 여기 클래스, 데이터베이스에 연결하는 기능을 모아둔 클래스.

    // 디비 서버에 연결해서,
    // 현재 시간을 조회하는 쿼리를 전달하고,
    // 현재 시간을 받아서, 가져오기.
    public String getTime() {
        // 현재 시간을 받아둘 임시 변수.
        String now = null;
        // try ~ resource with, 자동 닫기 내포되어 있음.
        // DB 서버에 연결하는 도구(디비 서버 주소, 계정 정보, 나머지 캐시 옵션이 설정되어 있는 객체)
        try(Connection connection = _0203_3_ConnectionUtil.INSTANCE.getConnection();
            // 현재 시간을 조회하는 쿼리를 전달하고
            PreparedStatement preparedStatement = connection.prepareStatement("select now()");
            // 디비 서버에 전달하고, 결과를 받아와서, 담아두기.
            ResultSet resultSet = preparedStatement.executeQuery();
                ){
              // resultSet, 담겨진 시간을 조회
            resultSet.next();
            now = resultSet.getString(1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    } //getTime 닫기

    // try ~ catch 구문 대신에, 어노테이션을 이용해서, @Cleanup
    public String getTime2() throws Exception {
            // @Cleanup와 같은 효과 = connection.close()
            @Cleanup Connection connection = _0203_3_ConnectionUtil.INSTANCE.getConnection();
            // 현재 시간을 조회하는 쿼리를 전달하고
            // @Cleanup와 같은 효과 = preparedStatement.close()
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
            // 디비 서버에 전달하고, 결과를 받아와서, 담아두기.
            // @Cleanup와 같은 효과 = resultSet.close()
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

            // resultSet, 담겨진 시간을 조회
            resultSet.next();
            String now = resultSet.getString(1);

        return now;
    }

    //등록하기.
    // _0203_1_TodoVO vo 여기 객체에는 , 화면에서, 입력한 내용을 담고 있음.
    // 화면상에는 제목만 입력 할 예정(수동), tno 번호(자동), 완료여부(수동), 날짜(수동)
    public void insert(_0203_1_TodoVO vo) throws  Exception {
        // sql 문장 작성,
        String sql = "insert into tbl_todo (title, dueDate, finished) values (?, ? ,?)";
        // 디비 서버에 연결하는 도구 설정.
        @Cleanup Connection connection = _0203_3_ConnectionUtil.INSTANCE.getConnection();
        // sql 문장을 담아 두는 기능
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // values (?, ? ,?) 값 지정 해주기.
        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
        preparedStatement.setBoolean(3, vo.isFinished());
        // sql 문장을 디비 서버에 전달.
        preparedStatement.executeUpdate();
    }


} //_0203_4_TodoDAO 닫기
