package com.example.employe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class DetaillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaill);
        TextView id = findViewById(R.id.textView4);
        TextView name = findViewById(R.id.textView5);
        TextView email = findViewById(R.id.editTextTextEmailAddress);
        TextView phone  = findViewById(R.id.editTextPhone3);
        TextView website = findViewById(R.id.textView7);
        TextView address = findViewById(R.id.editTextTextPersonName);
        TextView company = findViewById(R.id.textView8);

        Bundle bundle = getIntent().getExtras();

        String mid = bundle.getString("id");
        String mname = StringUtills.convertToCameCase( bundle.getString("name"));
        String memail = bundle.getString("email");
        String mphone = bundle.getString("phone");
        String maddress = bundle.getString("address");
        String mwebsite = bundle.getString("website");
        String mcompanyName = bundle.getString("company");
        Gson gsonConvert = new Gson();
        Address addressObj = gsonConvert.fromJson(maddress, Address.class);
        Company companyname = gsonConvert.fromJson(mcompanyName,Company.class);




        id.setText( "Employee Id : "+mid);
        name.setText("Name : "+mname);
        email.setText("Email:" +memail);
        phone.setText("phone :"+mphone);
        website.setText("website: "+mwebsite);
        address.setText("Address: "+addressObj.getStreet() +","
                +addressObj.getCity() +", " +addressObj.getSuite() +"," + addressObj.getZipcode());
        company.setText("name:"+companyname.getName());
    }
}