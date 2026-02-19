package com.busanit501.jsp_server_project1.springex_new_0219_keep.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("select now()")
    String getTime();
}
