package com.example.shivamarora.msend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView phonenoTextView ;
    TextView messageTextView ;
    Button goBack ;
    String status ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        phonenoTextView = (TextView)findViewById(R.id.phoneNoSecond);
        messageTextView = (TextView)findViewById(R.id.messageSecond);
        goBack = (Button)findViewById(R.id.Backbutton);
        String phoneNo = getIntent().getStringExtra("phoneNo");
        String message = getIntent().getStringExtra("message");
        status = getIntent().getStringExtra("status");
        phonenoTextView.setText(phoneNo);
        messageTextView.setText(message);

        Toast.makeText(Main2Activity.this ,"STATUS --- >>>  " +  status , Toast.LENGTH_LONG ).show();

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
