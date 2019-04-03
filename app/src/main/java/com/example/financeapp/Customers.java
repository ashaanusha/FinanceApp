package com.example.financeapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class Customers extends Fragment {
    FloatingActionButton fb;
    LinearLayout tap_icon;
    RecyclerView added_customers;
    ArrayList<Map<String,String>> al;
    Added_Customers added_customers_adapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.activity_customers, container, false );
        fb = view.findViewById(R.id.fab);
        tap_icon=view.findViewById(R.id.tap_icon);
        al= new ArrayList<Map<String,String>>();
        added_customers=view.findViewById(R.id.added_customers);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddCustomerActivity.class);
                startActivity(i);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        DataBaseClass db=new DataBaseClass(getContext());
        al = db.getRetrive();

        Log.e("array",al.toString());
        if(al.isEmpty())
        {

        }
        else {
            added_customers.setVisibility(View.VISIBLE);
            tap_icon.setVisibility(View.GONE);
            added_customers.setLayoutManager(new LinearLayoutManager(getActivity()));
            added_customers_adapter = new Added_Customers(getActivity(), al);
        }
        added_customers.setAdapter( added_customers_adapter );

    }
}
