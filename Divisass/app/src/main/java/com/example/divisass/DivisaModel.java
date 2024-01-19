package com.example.divisass;

public class DivisaModel {

    public String divisaName;
    public String divisaPrecio;

    public DivisaModel(String divisaName, String divisaPrecio) {
        this.divisaName = divisaName;
        this.divisaPrecio = divisaPrecio;
    }

    public String getDivisaName() {
        return divisaName;
    }

    public String getDivisaPrecio() {
        return divisaPrecio;
    }
}
