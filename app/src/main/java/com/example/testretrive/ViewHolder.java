package com.example.testretrive;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {


    View mView;



    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView= itemView;

    }

    public void  setDetails(Context ctx,String date ,String amount ,String url, String work){

        TextView mDate = mView.findViewById(R.id.date);
        TextView mAmount = mView.findViewById(R.id.amount);
        TextView mWork = mView.findViewById(R.id.work);
        ImageView mImage = mView.findViewById(R.id.imageView);


        //set data to views
        mDate.setText("Date= "+date);
        mAmount.setText("Amount= "+amount);
        mWork.setText("Work= "+work);
        Picasso.get().load(url).into(mImage);






    }

}
