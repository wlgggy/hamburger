package kr.hs.sdh.workbook1.entity;

public class Account {

    String id;
    String password;
    String name;

    public Account(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
}
