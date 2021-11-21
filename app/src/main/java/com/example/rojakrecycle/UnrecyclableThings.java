package com.example.rojakrecycle;

public class UnrecyclableThings {
    String rMaterial, rMaterialDesc;
    Integer rMaterialImg;

    public UnrecyclableThings(String rMaterial, String rMaterialDesc, Integer rMaterialImg) {
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
