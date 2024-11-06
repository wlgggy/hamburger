package kr.hs.sdh.workbook1.controller;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import kr.hs.sdh.workbook1.entity.Hamburger;
import kr.hs.sdh.workbook1.entity.History;
import kr.hs.sdh.workbook1.service.HamburgerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HamburgerRestController {
    private final HamburgerService hamburgerService;

    public HamburgerRestController(final HamburgerService hamburgerService) {
        this.hamburgerService = hamburgerService;
    }

    @GetMapping("/lotteria-menus")
    private List<Hamburger> lotteriaMenus(@RequestParam(defaultValue = "") String hamburgerName) {
        List<Hamburger> hamburgers = hamburgerService.getHamburgers();
        List<Hamburger> filterHamburgers = new ArrayList<>();

        for (int i = 0; i < hamburgers.size(); i++) {
            Hamburger hamburger = hamburgers.get(i);

            if (hamburger.getName().contains(hamburgerName)) {
                filterHamburgers.add(hamburger);
            }
        }

        return filterHamburgers;
    }

    @PostMapping("/lotteria-add-menu")
    private void lotteriaAddMenu(
            Hamburger hamburger,
            @RequestParam(value = "image") MultipartFile multipartFile,
            HttpServletResponse httpServletResponse
    ) throws IOException {
        this.hamburgerService.setHamburger(hamburger, multipartFile);
        httpServletResponse.sendRedirect("lotteria-example");
    }

    @DeleteMapping("/lotteria-delete-menu")
    private void lotteriaDeleteMenu(@RequestParam final String hamburgerName){
        hamburgerService.removeHamburger(hamburgerName);
    }

    @PostMapping("/hamburger-sell")
    private String saleHamburger(History history) {
        return ("판매완료 &ㅁ&");
    }

    // lotteria-delete-menu?hamburgerName
}
