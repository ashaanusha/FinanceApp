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

import java.util.ArrayList;
import java.util.Map;

public class Depositors extends Fragment {
    LinearLayout tap_icon;
    RecyclerView added_depositors;
    ArrayList<Map<String,String>> al;
    FloatingActionButton fb;
    Added_Depositor added_depositor_adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_depositors, container, false);
        fb = view.findViewById(R.id.fab);
        tap_icon=view.findViewById(R.id.tap_icon);
        al= new ArrayList<Map<String,String>>();
        added_depositors=view.findViewById(R.id.added_depositors);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddDepositorActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        DataBaseClass db=new DataBaseClass(getContext());
        al = db.getRetrive1();

        Log.e("array",al.toString());
        if(al.isEmpty())
        {

        }
        else {
            added_depositors.setVisibility(View.VISIBLE);
            tap_icon.setVisibility(View.GONE);
            added_depositors.setLayoutManager(new LinearLayoutManager(getActivity()));
            added_depositor_adapter = new Added_Depositor(getActivity(), al);
        }
        added_depositors.setAdapter( added_depositor_adapter );

    }
}
