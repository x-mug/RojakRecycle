package com.example.rojakrecycle.Redeem.TOOLS;

import com.example.rojakrecycle.R;
import com.google.android.gms.maps.model.LatLng;

public class Redeem_AllThingsData {

    static String[] RName = {
            "Jaya Grocer", "Lotus Mall", "H & M", "Touch 'N Go"
    };

    static String[] RLocation = {
            "134, Jalan Sunsuria, KL", "789, Jalan Sunsuria", "789, Jalan Sunsuria", "All mobile devices"
    };

    static String[] RExchange = {
            "130 points to RM20 voucher , 250 points to RM50 voucher", "150 points to RM30 voucher, 250 points to RM50 voucher, 500 points to RM120 voucher", "Below 5 kg: 50 points per kg, Above 5 kg: 60 points per kg", "50 points to RM20 voucher, 100 points to RM50 voucher"
    };

    static LatLng[] RLatLng = {
            new LatLng(3.1053190100866708f, 101.46720372898695f),
            new LatLng(2.828931134366895f, 101.70741655304674f),
            new LatLng(3.1091759716624754f, 101.46131993955302f),
            new LatLng( 3.1054860462864577f, 101.46747831071785f)
    };

    static Integer[] RImage = {
            R.drawable.jayagrocer,
            R.drawable.lotusmall,
            R.drawable.handm,
            R.drawable.tng,
    };

    static String[] RPoints = {
            "RM 20 off at Jaya Grocer with 130 points", "RM 30 off at Lotus Mall with 150 points", "Old clothes require at H & M with 50 points per kg", "Rojak Point to Touch 'N Go"
    };

}
