package com.jovanovic.stefan.sqlitetutorial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Account_CustomAdapter extends RecyclerView.Adapter<Account_CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList account_username, account_password, account_id;

    Account_CustomAdapter(Activity activity, Context context,
                  ArrayList account_id,
                  ArrayList account_username,
                  ArrayList account_password
    ){
        this.activity = activity;
        this.context = context;
        this.account_id = account_id;
        this.account_username = account_username;
        this.account_password = account_password;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.account_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
//        holder.book_title_txt.setText(String.valueOf(book_title.get(position)));
//        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
        holder.account_id_txt.setText(String.valueOf(account_id.get(position)));
        holder.account_username_txt.setText(String.valueOf(account_username.get(position)));
        holder.account_password_txt.setText(String.valueOf(account_password.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
//                intent.putExtra("id", String.valueOf(book_id.get(position)));
//                intent.putExtra("title", String.valueOf(book_title.get(position)));
//                intent.putExtra("author", String.valueOf(book_author.get(position)));
//                intent.putExtra("pages", String.valueOf(book_pages.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return account_username.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView account_id_txt, account_username_txt, account_password_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            account_id_txt = itemView.findViewById(R.id.account_id_txt);
            account_username_txt = itemView.findViewById(R.id.account_username_txt);
            account_password_txt = itemView.findViewById(R.id.account_password_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
