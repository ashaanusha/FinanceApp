package com.example.financeapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Added_Depositor extends RecyclerView.Adapter<Added_Depositor.ViewHolderClass>  {
    Context context;
    ArrayList<Map<String,String>> al;
    String number ,msg;
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
        number=al.get(i).get("Mobile_number1");
        msg="name:"+al.get(i).get("name1")+"\nAmount:"+ al.get(i).get("Amount1")+"\nRate_of_interest:"+al.get(i).get("Rate_of_interest1")+"\nAmount_in:"+al.get(i).get("Amount_in1")+"\nAmount_out:"+al.get(i).get("Amount_out1");
        viewHolderClass.whatsApp.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            PackageManager packageManager = context.getPackageManager();
                                                            boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
                                                            if (isWhatsappInstalled) {
                                                                Intent i = new Intent(Intent.ACTION_VIEW);

                                                                try {
                                                                    String url = "https://api.whatsapp.com/send?phone=+91" + number + "&text=" + URLEncoder.encode(msg, "UTF-8");
                                                                    i.setPackage("com.whatsapp");
                                                                    i.setData(Uri.parse(url));
                                                                    if (i.resolveActivity(packageManager) != null) {
                                                                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                        context.startActivity(i);
                                                                    }
                                                                } catch (Exception e) {
                                                                    e.printStackTrace();
                                                                }

                                                            }
                                                            else
                                                            {
                                                                Toast.makeText(context, "WhatsApp not Installed",
                                                                     Toast.LENGTH_SHORT).show();
                                                                Uri uri = Uri.parse("market://details?id=com.whatsapp");
                                                                 Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                                                                 goToMarket.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                                                                 context.startActivity(goToMarket);
//
                                                            }
                                                        }

                                                    });


        viewHolderClass.Message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                    SubscriptionManager localSubscriptionManager = SubscriptionManager.from(context);
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }

                    SmsManager.getDefault().sendTextMessage(number, null, msg, null, null);
                    Toast.makeText(context, "sms sending", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView name;
        ImageView Message,whatsApp;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            Message=itemView.findViewById(R.id.Message);
            whatsApp=itemView.findViewById(R.id.whatsApp);
        }
    }
    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm =context.getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }
}
