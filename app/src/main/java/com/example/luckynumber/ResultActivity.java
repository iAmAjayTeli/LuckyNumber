
package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView ans=(TextView) findViewById(R.id.result);
        Button share= (Button) findViewById(R.id.share);

        Intent intent=getIntent();
        String name=intent.getStringExtra("NameOfPerson");

        int luckyNumber= RandomNumber();
        ans.setText(" "+luckyNumber);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               shareData(name, luckyNumber);
            }
        });



    }

    public int  RandomNumber(){
        return new Random().nextInt(11);
    }

    public void shareData(String username, int randomNumber){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //Additional info
        i.putExtra(Intent.EXTRA_SUBJECT, username+" got his lucky number");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is "+randomNumber);

        startActivity(Intent.createChooser(i, "choose a Platform"));

    }

}