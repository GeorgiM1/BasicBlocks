package com.example.android.basicblocks;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main4Activity extends AppCompatActivity {
    @BindView(R.id.checkInternetConnection)
    Button checkInternet;
    @BindView(R.id.internetEditText)
    EditText internetEditText;
    @BindView(R.id.backBtn)
            Button back;
    NetworkRe recevier = new NetworkRe();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent broadCast = getIntent();
        ButterKnife.bind(this);



    }
    @OnClick(R.id.checkInternetConnection)
    public void checkNet (View v){
        registerReceiver(recevier, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        if (recevier.isConnected()){
            internetEditText.setText("You are now connected to the Internet");
        }else {
            internetEditText.setText("You are not connected");
        }


    }
    @OnClick (R.id.backBtn)
    public void backPress (View view){
        Intent internetConnectitionIntent = new Intent(this, Main3Activity.class);
        internetConnectitionIntent.putExtra("INTERNET_TEXT", internetEditText.getText().toString());
        setResult(RESULT_OK, internetConnectitionIntent);
        finish();
    }

}
