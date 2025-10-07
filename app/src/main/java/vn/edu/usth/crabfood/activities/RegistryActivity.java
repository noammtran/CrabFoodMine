package vn.edu.usth.crabfood.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class RegistryActivity extends AppCompatActivity {
    EditText emailReg, passF, passS;
    Button regBtn;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registry);

        emailReg = findViewById(R.id.emailReg);
        passF = findViewById(R.id.passF);
        passS = findViewById(R.id.passS);
        regBtn = findViewById(R.id.regBtn);
        mAuth = FirebaseAuth.getInstance();
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailReg.getText().toString().trim();
                String pass = passF.getText().toString().trim();
                String repass = passS.getText().toString().trim();
                if(pass.equals(repass)){
                    if(isValidEmail(email))
                    {
                        mAuth.createUserWithEmailAndPassword(email, pass)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            Toast.makeText(RegistryActivity.this, "Registry success.",
                                                    Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(RegistryActivity.this, "Registry failed.",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                    else{
                        Toast.makeText(RegistryActivity.this, "Invalid Email",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(RegistryActivity.this, "Incorrect Re-Password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Login(View view)
    {
        startActivity(new Intent(RegistryActivity.this, LoginActivity.class));
    }

    public boolean isValidEmail(String email) {
        return email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}