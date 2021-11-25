package com.example.rojakrecycle.UserData;

import com.firebase.ui.auth.data.model.User;
import com.google.firebase.database.DatabaseReference;

public class UserData {
    private static UserData instance;

    public DatabaseReference databaseRef;

    public int curRojakPoint = 0;

    public static UserData GetInstance()
    {
        if(instance == null)
            instance = new UserData();
        return instance;
    }
}
