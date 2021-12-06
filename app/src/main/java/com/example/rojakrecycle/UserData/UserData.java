package com.example.rojakrecycle.UserData;

import android.util.Log;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

public class UserData {
    private int rojakPoint;
    private String timeStamp;
    private String mobileNum;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private boolean InitComp;

    public void SetTimeStamp(String timeStamp) {
        String oldTimeStamp = this.timeStamp;
        this.timeStamp = timeStamp;
        changes.firePropertyChange("timeStamp", oldTimeStamp, timeStamp);
    }

    public String GetTimeStamp() {
        return timeStamp;
    }

    public void SetRojakPoint(int rojakPoint) {
        int oldRojakPoint = this.rojakPoint;
        this.rojakPoint = rojakPoint;
        changes.firePropertyChange("rojakPoint", oldRojakPoint, rojakPoint);
    }

    public int GetRojakPoint() {
        return rojakPoint;
    }

    public String GetMobileNum() {
        return mobileNum;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changes.removePropertyChangeListener(listener);
    }

    private static UserData instance;

    public void Init() {
        FirebaseDatabase.getInstance().getReference().child("users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    try
                    {
                        instance.rojakPoint = Optional.ofNullable(InsultResult(task.getResult(), "rojakPoint"))
                                .map(Integer::parseInt)
                                .orElse(0);
                    }
                    catch (Exception e)
                    {
                        instance.rojakPoint = 0;
                    }
                    try
                    {
                        instance.timeStamp = (Optional.ofNullable(InsultResult(task.getResult(), "timeStamp"))
                                .map(String::valueOf)
                                .orElse(""));
                    }
                    catch (Exception e)
                    {
                        instance.timeStamp = ("");
                    }
                    try
                    {
                        instance.mobileNum = (Optional.ofNullable(InsultResult(task.getResult(), "mobileNum"))
                                .map(String::valueOf)
                                .orElse(""));
                    }
                    catch (Exception e)
                    {
                        instance.mobileNum = ("");
                    }

                    changes.firePropertyChange("InitComp", InitComp, !InitComp);

                }
            }
        });

        // Auto Save
        addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                FirebaseDatabase
                        .getInstance()
                        .getReference()
                        .child("users")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .child(propertyChangeEvent.getPropertyName())
                        .setValue(propertyChangeEvent.getNewValue())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("QUIZACTIVITY", "DATASAVED");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("QUIZACTIVITY", "DATASAVE FAILED");
                            }
                        });
            }
        });
    }

    public static UserData GetInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }

    private static String InsultResult(DataSnapshot snapshot, String childValue) {
        if (!snapshot.exists())
            return null;

        return snapshot.child(childValue).exists() ? snapshot.child(childValue).getValue().toString() : null;
    }
}
