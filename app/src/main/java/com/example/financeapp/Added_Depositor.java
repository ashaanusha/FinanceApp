package com.example.financeapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class Added_Depositor extends RecyclerView.Adapter<Added_Depositor.ViewHolderClass>  {
    Context context;
    ArrayList<Map<String,String>> al;
    public Added_Depositor(Context context, ArrayList<Map<String,String>> al) {
        this.context= context;
        this.al=al;

    }
    @NonNull
    @Override
    public Added_Depositor.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.add_depositor_layout,viewGroup,false );
        Added_Depositor.ViewHolderClass viewHolderClass=new Added_Depositor.ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull Added_Depositor.ViewHolderClass viewHolderClass, int i) {
        viewHolderClass.name.setText( al.get(i).get("name1") );
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
