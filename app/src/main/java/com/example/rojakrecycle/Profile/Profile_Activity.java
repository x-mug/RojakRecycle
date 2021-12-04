package com.example.rojakrecycle.Profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.rojakrecycle.R;
import com.example.rojakrecycle.UserData.UserData;
import com.example.rojakrecycle.home.QuizActivity;
import com.example.rojakrecycle.login.LoginActivity;
import com.example.rojakrecycle.navBar.BottomNavigationActivity;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.Executor;

public class Profile_Activity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = View.inflate(getActivity(), R.layout.activity_profile, null);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        TextView userName = (TextView) v.findViewById(R.id.userName);
        TextView name = (TextView) v.findViewById(R.id.name);
        TextView rojakPoint = (TextView) v.findViewById(R.id.rojakpoint);
        TextView phoneNumber = (TextView) v.findViewById(R.id.phone_number);
        TextView email = (TextView) v.findViewById(R.id.email);


        userName.setText(user.getDisplayName());

        // Set Current RojakPoint
        rojakPoint.setText(String.valueOf(UserData.GetInstance().GetRojakPoint()));

        name.setText(user.getDisplayName());
        phoneNumber.setText(user.getPhoneNumber());
        email.setText(user.getEmail());

        TextView logoutBtn = v.findViewById(R.id.LogOutBtn);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance()
                        .signOut(getContext())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);
                            }
                        });
                Log.w("123", "LogOUT");
            }
        });

        return v;
    }
}
