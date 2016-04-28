package com.example.asus.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

        import com.koushikdutta.async.future.FutureCallback;
        import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {
    Button myButton;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button) findViewById(R.id.myButton);
        txtResult=(TextView) findViewById(R.id.txtResult);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ion.with(getApplicationContext())
                        .load("http://10.0.3.2/android/get_timer.php")
                        .asString()
                        .setCallback(new FutureCallback<String>() {
                            @Override
                            public void onCompleted(Exception e, String result) {
                                txtResult.setText(result);
                            }
                        });
            }
        });

    }
}


