package com.example.android.basicblocks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.name)
    EditText nameEditText;
    @BindView(R.id.LastName)
    EditText lastnameEditTxt;
    @BindView(R.id.Username)
    EditText userameEditTxt;
    @BindView(R.id.nextBtn)
    Button nextButton;
    @BindView(R.id.femaleBtn)
    RadioButton femaleButton;
    @BindView(R.id.maleBtn)
    RadioButton maleButton;
    @BindView(R.id.radioGroupGender)
    RadioGroup radioGroup;

    Users user;
    RadioButton checkedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        Intent editedUser = getIntent();

//        if (extras != null) {
        if (editedUser.hasExtra("EDIT_BOOLEAN")) {
            user = (Users) editedUser.getSerializableExtra("EDIT_USER");
            nameEditText.setText(user.name);
            lastnameEditTxt.setText(user.lastname);
            userameEditTxt.setText(user.username);
            maleButton.setChecked(user.isMale);
//            }
        } else if(editedUser.hasExtra("BOOLEAN")){
            user = new Users();
        }


    }

    @OnClick(R.id.nextBtn)

    public void v1(View v) {

        Intent intent = getIntent();
        user = new Users();

        if (intent.hasExtra("EDIT_BOOLEAN")) {
            user.setUsername(userameEditTxt.getText().toString());
            user.setLastname(lastnameEditTxt.getText().toString());
            user.setName(nameEditText.getText().toString());
            if (maleButton.isChecked()) {
                user.setMale(true);
            } else user.setMale(false);
            if (femaleButton.isChecked()) {
                user.setMale(false);
            } else user.setMale(true);
            Intent editIntent = new Intent(this, Main3Activity.class);
            editIntent.putExtra("EDITT_USER", user);
            editIntent.putExtra("EDITT_BOOLEAN", true);
            setResult(RESULT_OK,editIntent);
            finish();

        }
        if (intent.hasExtra("ADD_BOOLEAN")){
            user = new Users();
            user.setUsername(userameEditTxt.getText().toString());
            user.setLastname(lastnameEditTxt.getText().toString());
            user.setName(nameEditText.getText().toString());
            if (maleButton.isChecked()) {
                user.setMale(true);
            } else user.setMale(false);
            if (femaleButton.isChecked()) {
                user.setMale(true);
            } else user.setMale(true);
            Intent addUse = new Intent(this, Main3Activity.class);
            addUse.putExtra("ADD_USER", user);
            addUse.putExtra("ADD_BOOLEAN", true);
            setResult(RESULT_OK,addUse);
            finish();
        }else {
            user.setUsername(userameEditTxt.getText().toString());
            user.setLastname(lastnameEditTxt.getText().toString());
            user.setName(nameEditText.getText().toString());
            if (maleButton.isChecked()) {
                user.setMale(true);
            } else user.setMale(false);
            if (femaleButton.isChecked()) {
                user.setMale(false);
            } else user.setMale(true);


            Intent i = new Intent(this, Main3Activity.class);
            boolean firstuser = true;
            i.putExtra("USER_EXTRA", user);
            i.putExtra("FIRST_BOOLEAN", firstuser);
            startActivity(i);
        }
    }

}
