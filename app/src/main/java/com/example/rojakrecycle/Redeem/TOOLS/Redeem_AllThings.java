package com.example.rojakrecycle.Redeem.TOOLS;

public class Redeem_AllThings {
    Integer RImage, RImage2;
    String RName, RLocation, RExchange, RPoints;

    public Redeem_AllThings (String RName, String RLocation,String RExchange, Integer RImage, String RPoints){
        this.RName = RName;
        this.RLocation = RLocation;
        this.RExchange = RExchange;
        this.RImage = RImage;
        this.RPoints = RPoints;
    }

    public String getRName() {return RName;}
    public String getRLocation() {return RLocation;}
    public String getRExchange() {return RExchange;}
    public String getRPoints() {return RPoints;}
    public Integer getRImage() {return RImage;}
}
