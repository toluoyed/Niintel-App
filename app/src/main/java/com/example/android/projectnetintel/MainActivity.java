package com.example.android.projectnetintel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout rilley;
    RelativeLayout rilley2;
    Handler handler = new Handler();
    Button signInBtn;
    private EditText editText1;
    private EditText editText2;
    private TextView textView1;
    private  TextView textView2;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rilley = (LinearLayout) findViewById(R.id.rilley1);
        rilley2 = (RelativeLayout) findViewById(R.id.rilley2);
        handler.postDelayed(runnable,2000);
        signInBtn = (Button) findViewById(R.id.signInBtn);
        editText1 = (EditText) findViewById(R.id.editTextEmail);
        editText2 = (EditText) findViewById(R.id.editTextPassword);
        textView1 = (TextView) findViewById(R.id.textViewSignUp);
        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),MenuActivity.class));
        }

        signInBtn.setOnClickListener(this);
        textView1.setOnClickListener(this);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rilley.setVisibility(View.VISIBLE);
            rilley2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    public void onClick(View view) {
        if(view == signInBtn){
            userLogin();
        }
        if (view == textView1){
            startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
        }
    }

    private void userLogin() {
        String email= editText1.getText().toString();
        String password= editText2.getText().toString();

        if (TextUtils.isEmpty(email)){

            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();

            return;
        }

        if (TextUtils.isEmpty(password)){

            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();

            return;
        }

        progressDialog.setMessage("Logging in.......");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),MenuActivity.class));
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Wrong email or Password" ,Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}
