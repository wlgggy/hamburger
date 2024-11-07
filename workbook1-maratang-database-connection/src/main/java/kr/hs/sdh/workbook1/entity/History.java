package kr.hs.sdh.workbook1.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class History {

    private final String name;

    private final int price;

    private final LocalDateTime saleDateTime;


    public History(String name, int price ){
        this.name = name;
        this.price = price;
        this.saleDateTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getSaleDateTime() {
        return saleDateTime;
    }

}
