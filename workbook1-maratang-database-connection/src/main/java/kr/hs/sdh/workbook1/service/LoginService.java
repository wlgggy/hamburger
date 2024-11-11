package kr.hs.sdh.workbook1.service;

import kr.hs.sdh.workbook1.entity.Account;
import kr.hs.sdh.workbook1.entity.Role;
import kr.hs.sdh.workbook1.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Account getMember(String id){
        return this.loginRepository.findMemberById(id);
    }

    public void removeMember(String id){
        this.loginRepository.deleteMemberById(id);
    }

    public Set<Role> getRoles(String memberId){
        List<Role> roles = this.loginRepository.findRoleById(memberId);
//        Set<Role> set = new HashSet<>(roles);
        return new HashSet<>(roles);
    }
}
