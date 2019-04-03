package com.example.financeapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    public void onBindViewHolder(@NonNull Added_Customers.ViewHolderClass viewHolderClass, int i) {
        viewHolderClass.name.setText( al.get(i).get("name") );
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);

        }
    }
}
