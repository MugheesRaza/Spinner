package com.example.mughees.spinner;

/**
 * Created by Mughees on 21-Feb-2018.
 */

public class Data {

    String spi1;
    String spi2;
    String spi3;
    String spi4;

    public Data(){

    }

    public Data(String id, String spi1, String spi2, String spi3, String spi4) {
        this.spi1 = spi1;
        this.spi2 = spi2;
        this.spi3 = spi3;
        this.spi4 = spi4;
    }

    public String getSpi1() {
        return spi1;
    }

    public String getSpi2() {
        return spi2;
    }

    public String getSpi3() {
        return spi3;
    }

    public String getSpi4() {
        return spi4;
    }
}
