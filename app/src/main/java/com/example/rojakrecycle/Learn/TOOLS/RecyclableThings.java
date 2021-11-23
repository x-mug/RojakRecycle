package com.example.rojakrecycle.Learn.TOOLS;

import android.content.Intent;

public class RecyclableThings {
    String rMaterial, rMaterialDesc;
    Integer rMaterialImg;


    public RecyclableThings(String rMaterial, String rMaterialDesc, Integer rMaterialImg) {
        this.rMaterial = rMaterial;
        this.rMaterialDesc = rMaterialDesc;
        this.rMaterialImg = rMaterialImg;
    }

    public String getrMaterial() {
        return rMaterial;
    }

    public String getrMaterialDesc() {
        return rMaterialDesc;
    }

    public Integer getrMaterialImg() {
        return rMaterialImg;
    }
}
