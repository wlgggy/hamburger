package kr.hs.sdh.workbook1.repository;

import kr.hs.sdh.workbook1.entity.Hamburger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LotteriaHamburgerRepositoryTest {


    private Set<Hamburger> hamburgers = new HashSet<>();
    @Test
    void deleteHamburger() {

        Hamburger appleHamburger = new Hamburger(
                "사과 햄버거",
                4500,
                "/",
                true,
                false
        );

        if(this.hamburgers.contains(appleHamburger)) {
            this.hamburgers.remove(appleHamburger);
        }
    }

    @Test
    void saveHamburger() {

        Hamburger appleHamburger = new Hamburger(
                "사과 햄버거",
                4500,
                "/",
                true,
                false
        );

        this.hamburgers.add(appleHamburger);
    }

    @BeforeEach
     void beforeEach() {
        Hamburger appleHamburger = new Hamburger(
                "사과 햄버거",
                4500,
                "/",
                true,
                false
        );
        this.hamburgers.add(appleHamburger);
    }
}