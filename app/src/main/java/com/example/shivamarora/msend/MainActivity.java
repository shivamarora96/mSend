package com.example.shivamarora.msend;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    //Members ________________________________________________

    EditText phoneNumberEditText ;
    EditText messageEditText ;
    Button send ;
    String message;
    String status ;



    //ONCREATE__________________________________________________


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   //Declaration_________________________________________________

        phoneNumberEditText = (EditText)findViewById(R.id.phoneNo);
        messageEditText = (EditText)findViewById(R.id.message);
        send = (Button)findViewById(R.id.button);
        final String baseUrl = "https://webaroo-send-message-v1.p.mashape.com";


        //ToolBAR_________________________________________________

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


      //SEND_BUTTON________________________________________________

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitTask(baseUrl);
            }
        });


        //Ending of Oncreate____________________________________________
    }




//StartingActivityTwo____________________________________________________

    private void StartingActivityTwo() {
        Intent i = new Intent(MainActivity.this , Main2Activity.class);
        i.putExtra("phoneNo" , phoneNumberEditText.getText().toString() );
        i.putExtra("message" , message);
        i.putExtra("status" ,status );
        startActivity(i);
    }


    //Downloading_Data_Using_RetroFit____________________________________________

    private void RetrofitTask(String baseUrl) {
        Retrofit retrofit = new  Retrofit.Builder().addConverterFactory( GsonConverterFactory.create(new GsonBuilder().create())).baseUrl(baseUrl).build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Number  phoneNumber = Long.parseLong(phoneNumberEditText.getText().toString());
        String inputMessage = messageEditText.getText().toString();

        Call<ApiResponse> call = apiInterface.getResponse(inputMessage , phoneNumber);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                 if(response.isSuccessful())
                 {  status = response.body().getStatus();
                    message = response.body().getData().getMessage();
                     StartingActivityTwo();
                     }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                     Toast.makeText(MainActivity.this ,  " ==>> Sending Failed !! Check Phone No  <<== " , Toast.LENGTH_LONG).show();
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
