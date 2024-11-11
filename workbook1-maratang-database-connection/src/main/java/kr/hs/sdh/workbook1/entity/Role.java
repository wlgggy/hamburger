package kr.hs.sdh.workbook1.entity;

public class Role {

    public String id;
    public String code;

    public Role(String id, String code) {
        this.id = id;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

}
