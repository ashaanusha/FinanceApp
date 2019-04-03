package com.example.financeapp;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddDepositorActivity extends AppCompatActivity {

    TextView save_customer;
    ImageView back;
    Boolean value;
    private DataBaseClass dataBaseClass;
    TextInputEditText name,Mobile_number,Amount,address,Rate_of_interest,Amount_in,Amount_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_depositor);
        dataBaseClass = new DataBaseClass(AddDepositorActivity.this);
        back = findViewById(R.id.back);
        name = findViewById(R.id.name);
        Mobile_number = findViewById(R.id.Mobile_number);
        Amount = findViewById(R.id.Amount);
        address = findViewById(R.id.address);
        Rate_of_interest = findViewById(R.id.Rate_of_interest);
        Amount_in = findViewById(R.id.Amount_in);
        Amount_out = findViewById(R.id.Amount_out);

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
                String Mobile_number_str = Mobile_number.getText().toString().trim();
                String Amount_str = Amount.getText().toString().trim();
                String address_str = address.getText().toString().trim();
                String Rate_of_interest_str = Rate_of_interest.getText().toString().trim();
                String Amount_in_str = Amount_in.getText().toString().trim();
                String Amount_out_str = Amount_out.getText().toString().trim();
                Toast.makeText(AddDepositorActivity.this, "Added Depositors", Toast.LENGTH_SHORT).show();
                if (name_str != null && Mobile_number_str != null && Amount_str!=null && address_str!=null && Rate_of_interest_str!=null && Amount_in_str!=null  && Amount_out_str!=null) {
                    value = true;
                    dataBaseClass.insertValues1(name_str, Mobile_number_str, Amount_str,address_str,Rate_of_interest_str,Amount_in_str,Amount_out_str);
                    Toast.makeText(AddDepositorActivity.this, "Added customer", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddDepositorActivity.this, "plz fill all the details", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
