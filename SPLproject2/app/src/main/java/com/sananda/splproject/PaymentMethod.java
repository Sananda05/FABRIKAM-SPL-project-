package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PaymentMethod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        Button confirm=findViewById(R.id.confirm);
        RadioGroup payment = findViewById(R.id.payment);
        RadioButton online = findViewById(R.id.online);
        RadioButton deliveryCash=findViewById(R.id.deliveryCash);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PaymentMethod.this, ReadyOrderList.class);
                startActivity(intent);
            }
        });
    }

    public void paymentButton(View view) {
        boolean checked= ((RadioButton)view).isChecked();

        switch (view.getId())
        {
            case R.id.online:
                if(checked);
                break;
            case R.id.deliveryCash:
                break;
        }
    }
}
