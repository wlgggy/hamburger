package kr.hs.sdh.workbook1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignController {
    @GetMapping(value = "/login")
    private String login(final Model model) {
        return "login";
    }
}
