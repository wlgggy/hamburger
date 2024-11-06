package kr.hs.sdh.workbook1.controller;

import kr.hs.sdh.workbook1.entity.Hamburger;
import kr.hs.sdh.workbook1.service.HamburgerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public final class HamburgerController {

    private final HamburgerService hamburgerService;

    public HamburgerController(HamburgerService hamburgerService) {
        this.hamburgerService = hamburgerService;
    }

    @GetMapping(value = "/lotteria")
    private String lotteria(final Model model) {
        List<Hamburger> hamburgers = hamburgerService.getHamburgers();

        List<Hamburger> newHamburgers = new ArrayList<>();
        for (Hamburger hamburger : hamburgers) {
            if(hamburger.isRecommended() == true){
                newHamburgers.add(hamburger);

            }
        }
        model.addAttribute("hamburgers", newHamburgers);
        return "lotteria";
    }

    @GetMapping(value = "/lotteria-example")
    private String lotteriaExample() { return "lotteria-example"; }

}
