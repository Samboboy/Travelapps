package com.dimasadjie.worldtour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dimasadjie.worldtour.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {

    ActivitySignUpBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.signupEmail.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String confirmPassword = binding.signupConfirmPassword.getText().toString();

                if (email.equals("") || password.equals("") || confirmPassword.equals(""))
                    Toast.makeText(SignUp.this, "All field are mandatory", Toast.LENGTH_SHORT).show();
                else {
                    if (password.equals(confirmPassword)){
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if (checkUserEmail == false){
                            Boolean insert = databaseHelper.insertData(email, password);

                            if (insert == true){
                                Toast.makeText(SignUp.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(SignUp.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(SignUp.this, "User already exists, Please login", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SignUp.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    public void login(View view){
        Intent intent = new Intent(SignUp.this, MainActivity.class);
        startActivity(intent);
    }
}