package kr.hs.sdh.workbook1.entity;

import java.beans.ConstructorProperties;

public class Member {

    private final String id;

    private String password;

    @ConstructorProperties(value = {
            "id",
            "password"
    })

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void getPassword() {
        this.password = password;
    }
}
