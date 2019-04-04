package com.example.financeapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class Added_Customers extends RecyclerView.Adapter<Added_Customers.ViewHolderClass> {
    Context context;
    ArrayList<Map<String,String>> al;
    public Added_Customers(Context context, ArrayList<Map<String,String>> al) {
        this.context= context;
        this.al=al;

    }
    @NonNull
    @Override
    public Added_Customers.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.add_customer_layout,viewGroup,false );
        ViewHolderClass viewHolderClass=new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull Added_Customers.ViewHolderClass viewHolderClass,  final int i) {
        viewHolderClass.name.setText( al.get(i).get("name") );
        viewHolderClass.collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Collect.class);
                intent.putExtra("number",al.get(i).get("mobile"));
                context.startActivity(intent);
            }
        });
        viewHolderClass.Details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Details.class);
                intent.putExtra("number",al.get(i).get("mobile"));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView name;
        LinearLayout collect,Details;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            collect=itemView.findViewById(R.id.collect);
            Details=itemView.findViewById(R.id.Details);


        }
    }
}
