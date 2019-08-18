package com.example.android.projectnetintel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class PurchaseActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    TextView textView2;
    TextView textView3;
    ImageView image;
    ElegantNumberButton quanButton;
    Button button;
    double price ;
    double price2;
    int quantity;
    String foodName1;
    String foodDesc1;
    String  num = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        image = (ImageView) findViewById(R.id.foodImage);
        textView = (TextView) findViewById(R.id.textViewfoodName);
        textView2 = (TextView) findViewById(R.id.textViewfoodDesc);
        textView3 =(TextView) findViewById(R.id.textViewPrice);
        quanButton = (ElegantNumberButton) findViewById(R.id.quantButton);
        button = (Button) findViewById(R.id.orderBtn);

        Bundle bundle = getIntent().getExtras();
        foodName1 = bundle.getString("foodName");
        foodDesc1 = bundle.getString("foodDesc");
        textView.setText(foodName1);
        textView2.setText(foodDesc1);
        image.setImageResource(bundle.getInt("foodImg"));
        price = bundle.getDouble("foodPrice");
        textView3.setText("$"+String.valueOf(price));


        quanButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = quanButton.getNumber();
                quantity = (Integer.valueOf(num));
                price2 = price * quantity;
                button.setVisibility(View.VISIBLE);
                button.setText("Add  "+"$"+String.valueOf(price2));
                Log.e("NUM",num);
            }
        });


        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == button){
            Intent a = new Intent(getApplicationContext(),OrderActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("foodName",foodName1);
            bundle.putString("foodDesc",foodDesc1);
            bundle.putInt("quantity",quantity);
            bundle.putDouble("foodPrice",price);
            a.putExtras(bundle);
            startActivity(a);
        }
    }
}
