package com.example.financeapp;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddCustomerActivity extends AppCompatActivity {

    TextView save_customer;
    ImageView back;
    Boolean value;
    private DataBaseClass dataBaseClass;

    TextInputEditText name,father_name,occupation,mobile,address,amount,netamount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_customer);
        dataBaseClass = new DataBaseClass(AddCustomerActivity.this);
        back = findViewById(R.id.back);
        name=findViewById(R.id.name);
        father_name=findViewById(R.id.father_name);
        occupation=findViewById(R.id.occupation);
        mobile=findViewById(R.id.mobile);
        address=findViewById(R.id.address);
        amount=findViewById(R.id.amount);
        netamount=findViewById(R.id.netamount);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save_customer = findViewById(R.id.save_customer);
        save_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_str = name.getText().toString().trim();
                String father_name_str = father_name.getText().toString().trim();
                String occupation_str = occupation.getText().toString().trim();
                String mobile_str = mobile.getText().toString().trim();
                String address_str = address.getText().toString().trim();
                String amount_str = amount.getText().toString().trim();
                String netamount_str = netamount.getText().toString().trim();
                if (name_str != null && father_name_str != null && occupation_str!=null && mobile_str!=null && address_str!=null && amount_str!=null  && netamount_str!=null) {
                    value = true;
                    dataBaseClass.insertValues(name_str, father_name_str, occupation_str,mobile_str,address_str,amount_str,netamount_str);
                    Toast.makeText(AddCustomerActivity.this, "Added customer", Toast.LENGTH_SHORT).show();
               finish();
                }
                else
                {
                    Toast.makeText(AddCustomerActivity.this, "plz fill all the details", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
