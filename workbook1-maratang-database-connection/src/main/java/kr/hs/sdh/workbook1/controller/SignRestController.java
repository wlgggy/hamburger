package kr.hs.sdh.workbook1.controller;

import kr.hs.sdh.workbook1.entity.Account;
import kr.hs.sdh.workbook1.entity.Member;
import kr.hs.sdh.workbook1.service.LoginService;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class SignRestController {

    private final LoginService loginService;

    public SignRestController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/sign-in") // form 데이터 대신에 RequestBody
    private Account login(@RequestBody Member member) {

        String id = member.getId();
        return this.loginService.getMember(id);
    }

    @DeleteMapping("/delete-user")
    public String delete(@RequestParam String userId) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                "http://10.56.148.148:8081/delete-user?userId=" + userId,
                HttpMethod.DELETE,
                null,
                String.class

        ).getBody();

        // this.loginService.removeMember(id);

        // return (id + "˚₊*̥ ✶⋆ 계정이 삭제가 완료되었습니다 ‧˚✶₊*̥ ⋆");
    }

}
