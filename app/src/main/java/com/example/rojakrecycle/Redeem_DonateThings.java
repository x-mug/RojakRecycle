package com.example.rojakrecycle;

public class Redeem_DonateThings {
    Integer RImage;
    String RName, RLocation, RExchange, RPoints;;

    public Redeem_DonateThings(String RName, String RLocation, String RExchange, Integer RImage,String RPoints){
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
