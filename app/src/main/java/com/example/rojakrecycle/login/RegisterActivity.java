package com.example.rojakrecycle.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rojakrecycle.UserData.UserData;
import com.example.rojakrecycle.navBar.BottomNavigationActivity;
import com.example.rojakrecycle.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    protected ActivityRegisterBinding binding;
    private static final String TAG = "RegisterActivity: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        binding.cirRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterWithEmailAndPassword();
            }
        });
    }

    private void RegisterWithEmailAndPassword() {
        if(!isEmail(binding.editTextEmail.getText().toString()) || binding.editTextPassword.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Input Error", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(binding.editTextEmail.getText().toString(), binding.editTextPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            updateUI(null);
                        }
                    }
                });
    }

    public static boolean isEmail(String strEmail) {
        String strPattern = "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        if (TextUtils.isEmpty(strPattern)) {
            return false;
        } else {
            return strEmail.matches(strPattern);
        }
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(binding.editTextName.getText().toString())
                    .build();
            user.updateProfile(profileUpdates).addOnCompleteListener(this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(RegisterActivity.this, "Welcome, " + user.getDisplayName(),
                            Toast.LENGTH_SHORT).show();
                    UserData.GetInstance().addPropertyChangeListener(new PropertyChangeListener() {
                        @Override
                        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                            Intent intent = new Intent(RegisterActivity.this, BottomNavigationActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setClass(RegisterActivity.this,BottomNavigationActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            });
        } else {
            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}