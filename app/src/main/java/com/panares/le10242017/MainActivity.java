package com.panares.le10242017;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    Button btn_save;
    Button btn_display;
    TextView tv_display;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = (EditText) findViewById(R.id.editText2);
        et_password = (EditText) findViewById(R.id.editText3);
        btn_save = (Button) findViewById(R.id.button);
        btn_display = (Button) findViewById(R.id.button2);
        tv_display = (TextView) findViewById(R.id.textView3);
        preferences = (getPreferences(Context.MODE_PRIVATE));

    }

    public void saveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", et_username.getText().toString());
        editor.putString("password", et_password.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();

    }

    public void loadInfo(View view){
        String user = preferences.getString("username","");
        String pwd = preferences.getString("password","");
        tv_display.setText("The password of " + user + " is " + pwd);
    }
}
