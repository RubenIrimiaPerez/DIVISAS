package com.example.divisass;

import android.graphics.drawable.Drawable;

public class DivisaModel {

    public String divisaName;
    public String divisaPrecio;
    public Drawable divisaLogo;

    public DivisaModel(String divisaName, String divisaPrecio,Drawable divisaLogo) {
        this.divisaName = divisaName;
        this.divisaPrecio = divisaPrecio;
        this.divisaLogo =divisaLogo;
    }

    public String getDivisaName() {
        return divisaName;
    }

    public String getDivisaPrecio() {
        return divisaPrecio;
    }

    public Drawable getDivisaLogo() {return divisaLogo;}
}
