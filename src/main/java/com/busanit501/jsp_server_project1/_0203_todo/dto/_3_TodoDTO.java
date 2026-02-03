package com.busanit501.jsp_server_project1._0203_todo.dto;

import java.time.LocalDate;

public class _3_TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private  boolean finished;

    // getter/setter/toString, 정의
    // toString,
    // 객체를, 인스턴스를 출력을 하면, 의미없는 메모리 주소가 출력이됨.
    // 저희는 메모리 주소를 알필요가 없고, 실제, 값만 알면됨.
    // toString , 재정의해서, 의미 있는 값으로 표현.
    // 생성 -> 반자동으로 만들기.

    public Long getTno() {
        return tno;
    }

    public void setTno(Long tno) {
        this.tno = tno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "_3_TodoDTO{" +
                "tno=" + tno +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", finished=" + finished +
                '}';
    }
}
