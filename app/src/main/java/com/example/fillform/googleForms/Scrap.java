package com.example.fillform.googleForms;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fillform.R;
import com.example.fillform.constants.Constants;
import com.example.fillform.postRequests.ScrapPostData;



import static android.util.Patterns.EMAIL_ADDRESS;
import static android.util.Patterns.PHONE;

public class Scrap extends AppCompatActivity {

    private Constants constants;
    private  Context context;
    private  EditText name;
    private  EditText phoneNumber;
    private  EditText emailAddress;
    private Button submitForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrap);
        constants = new Constants();
        context = this;
        name = (EditText) findViewById(R.id.personName);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        emailAddress = (EditText) findViewById(R.id.emailAddress);
        submitForm = (Button) findViewById(R.id.submit);

        submitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm(){
        if(TextUtils.isEmpty(name.getText().toString())){
            Toast.makeText(context, "Name is Required.", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(emailAddress.getText().toString())){
            Toast.makeText(context, "Email is Requried.", Toast.LENGTH_LONG).show();
            return;
        }
        if(!EMAIL_ADDRESS.matcher(emailAddress.getText().toString()).matches()){
            Toast.makeText(context, "Please enter valid email address.",Toast.LENGTH_LONG).show();
            return;
        }
        if(!PHONE.matcher(phoneNumber.getText().toString()).matches()){
            Toast.makeText(context, "Please enter valid phone number.", Toast.LENGTH_LONG).show();
            return;

        }
        ScrapPostData scrapPostData = new ScrapPostData();
        scrapPostData.execute(constants.testUrl, name.getText().toString(), emailAddress.getText().toString(), phoneNumber.getText().toString());

    }
}
