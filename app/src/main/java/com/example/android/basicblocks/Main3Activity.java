package com.example.android.basicblocks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main3Activity extends AppCompatActivity {
    @BindView(R.id.textView)
    TextView internetTextView;

    @BindView(R.id.radioGroup)
    RadioGroup gender;

    @BindView(R.id.editGuestSpinner)
    Spinner guestSpinner;
    @BindView(R.id.check_internet)
    Button checkInternet;
    @BindView(R.id.imeIprezime)
    TextView imePrezime;
    @BindView(R.id.genderFemale)
    RadioButton female;
    @BindView(R.id.genderMale)
    RadioButton male;
    @BindView(R.id.imgSex)
    ImageView image;
    @BindView(R.id.btnEditUser)
    Button editUser;
    @BindView(R.id.btnAddUser)
    Button addUser;

    String name;
    String lastname;
    String username;
    ArrayList<Users> spinnerArray;

    ArrayAdapter<Users> adapter;
    public Users user1;

    public int REQUEST_CODE3;
    public int REQUEST_CODE2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);
        spinnerArray = new ArrayList<>();


        Intent e = getIntent();
        if (e.hasExtra("INTERNET_TEXT")){
            internetTextView.setText(e.getStringExtra("INTERNET_TEXT"));
        }else internetTextView.setText("No info about internet");


        if (e.hasExtra("FIRST_BOOLEAN")) {
            user1 = (Users) e.getSerializableExtra("USER_EXTRA");
            imePrezime.setText(user1.name + "\n" + user1.lastname);
            if (user1.isMale) {
                male.setChecked(true);
            } else male.setChecked(false);
            if (!user1.isMale) {
                female.setChecked(true);
            } else female.setChecked(false);
            if (male.isChecked()) {
                image.setImageResource(R.drawable.man);
            } else image.setImageResource(R.drawable.mujer);
            female.setClickable(false);
            male.setClickable(false);
            spinnerArray.add(user1);
            adapter = new ArrayAdapter<Users>(this, android.R.layout.simple_spinner_item, spinnerArray);

            guestSpinner.setAdapter(adapter);
        }
       else if (e.hasExtra("ADD_BOOLEAN")){
            user1 = (Users) e.getSerializableExtra("ADD_USER");

            spinnerArray.add(user1);
            adapter = new ArrayAdapter<Users>(this, android.R.layout.simple_spinner_item, spinnerArray);

            guestSpinner.setAdapter(adapter);
        }



        else if (e.hasExtra("DEFAULT_USER")) {
            user1 = (Users) e.getSerializableExtra("DEFAULT_USER");
            imePrezime.setText(user1.name + "\n" + user1.lastname);
            if (user1.isMale) {
                male.setChecked(true);
            } else male.setChecked(false);
            if (!user1.isMale) {
                female.setChecked(true);
            } else female.setChecked(false);
            if (male.isChecked()) {
                image.setImageResource(R.drawable.man);
            } else image.setImageResource(R.drawable.mujer);
            female.setClickable(false);
            male.setClickable(false);

            spinnerArray.add(user1);
            adapter = new ArrayAdapter<Users>(this, android.R.layout.simple_spinner_item, spinnerArray);

            guestSpinner.setAdapter(adapter);
        }
    }

    @OnClick(R.id.btnEditUser)
    public void v(View vieww) {

        Intent userr1 =  new Intent(this, Main2Activity.class);
        boolean editBoolean = true;
        user1 =(Users) guestSpinner.getSelectedItem();
            userr1.putExtra("EDIT_USER", user1);
            userr1.putExtra("EDIT_BOOLEAN", editBoolean);
        startActivityForResult(userr1,REQUEST_CODE3);

    }
    @OnClick(R.id.btnAddUser)
    public void ccc(View v) {
        boolean adduser = true;
        user1 = new Users();
        Intent act2 = new Intent(this, Main2Activity.class);
        act2.putExtra("ADD_BOOLEAN", adduser);
        act2.putExtra("ADD_USER", user1);
        startActivityForResult(act2, REQUEST_CODE2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE2 && resultCode == RESULT_OK) {


            if (data != null && data.hasExtra("ADD_BOOLEAN")){
                user1 = (Users) data.getSerializableExtra("ADD_USER");
                spinnerArray.add(user1);
                adapter = new ArrayAdapter<Users>(this, android.R.layout.simple_spinner_item, spinnerArray);
                guestSpinner.setAdapter(adapter);

            }
        }
        if (requestCode==REQUEST_CODE3 && resultCode==RESULT_OK){
            if (data != null && data.hasExtra("EDITT_BOOLEAN"))
            user1 = (Users) data.getSerializableExtra("EDITT_USER");
            imePrezime.setText(user1.name + "\n" + user1.lastname);
            if (user1.isMale) {
                male.setChecked(true);
            } else male.setChecked(false);
            if (!user1.isMale) {
                female.setChecked(true);
            } else female.setChecked(false);
            if (male.isChecked()) {
                image.setImageResource(R.drawable.man);
            } else image.setImageResource(R.drawable.mujer);
            female.setClickable(false);
            male.setClickable(false);
            spinnerArray.add(user1);
            adapter = new ArrayAdapter<Users>(this, android.R.layout.simple_spinner_item, spinnerArray);
            guestSpinner.setAdapter(adapter);


        }
    }
    @OnClick(R.id.check_internet)
    public void startBroadcastAct (View v){
        Intent broadcast = new Intent(this, Main4Activity.class);
        startActivityForResult(broadcast, REQUEST_CODE3);
    }


}