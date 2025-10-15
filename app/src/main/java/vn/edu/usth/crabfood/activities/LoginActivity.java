package vn.edu.usth.crabfood.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.usth.crabfood.DataHelper;
import vn.edu.usth.crabfood.MainActivity;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import vn.edu.usth.crabfood.R;

public class LoginActivity extends AppCompatActivity {

    EditText emailText,passText;
    Button loginBtn;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        emailText = findViewById(R.id.emailText);
        passText = findViewById(R.id.passText);
        loginBtn = findViewById(R.id.loginBtn);
        mAuth = FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailText.getText().toString().trim();
                String password = passText.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    DataHelper.userID = String.valueOf(mAuth.getCurrentUser().getUid());
                                    DataHelper.fetchData();
                                    Toast.makeText(LoginActivity.this, "Login success.",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Registry(View view) {
        startActivity(new Intent(LoginActivity.this, RegistryActivity.class));
    }

    public void MainActivity(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}