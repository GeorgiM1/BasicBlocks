package com.example.android.basicblocks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnLogIn)
    Button logInBtn;
    @BindView(R.id.guest_text)
    TextView guest;
    Users defaultUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);




    }
    @OnClick(R.id.btnLogIn)
    public void v (View view){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
    @OnClick(R.id.guest_text)
    public void  pu (View v ){
        Intent a = new Intent(this, Main3Activity.class);
        defaultUser = new Users();
        defaultUser.setName("Guest");
        defaultUser.setUsername("guest");
        defaultUser.setLastname("Guest");
        defaultUser.setMale(false);
        a.putExtra("DEFAULT_USER", defaultUser);
        startActivity(a);

    }

}
