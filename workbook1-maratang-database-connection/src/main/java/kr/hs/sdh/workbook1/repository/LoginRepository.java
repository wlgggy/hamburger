package kr.hs.sdh.workbook1.repository;

import kr.hs.sdh.workbook1.entity.Account;
import kr.hs.sdh.workbook1.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginRepository {

    @Select("select * from member where id = #{id}")
    Account findMemberById(String id);

    @Delete("delete from member where id = #{id} ")
    void deleteMemberById(String id);

    @Select("select * from role where id = #{id}")
    List<Role> findRoleById(String id);
}