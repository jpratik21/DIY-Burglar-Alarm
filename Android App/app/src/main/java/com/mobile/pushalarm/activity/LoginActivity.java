package com.mobile.pushalarm.activity;

/**
 * Created by jpratik on 10/17/15.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobile.pushalarm.R;
import com.mobile.pushalarm.helper.ParseUtils;
import com.mobile.pushalarm.helper.PrefManager;

public class LoginActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText inputEmail;
    private Button btnLogin;
    private PrefManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Verifying parse configuration. This is method is for developers only.
        ParseUtils.verifyParseConfiguration(this);

        pref = new PrefManager(getApplicationContext());
        if (pref.isLoggedIn()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

            finish();
        }

        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.email);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }


    private void login() {
        String email = inputEmail.getText().toString();

        if (isValidEmail(email)) {

            pref.createLoginSession(email);

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Please enter valid email address!", Toast.LENGTH_LONG).show();
        }
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                login();
                break;
            default:
        }
    }
}
