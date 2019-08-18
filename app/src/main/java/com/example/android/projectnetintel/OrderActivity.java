package com.example.android.projectnetintel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    Button orderBtn;
    RelativeLayout relativ;

    double deliveryPrice = 2.00;
    double price;
    double subTotal;
    double totPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textView1 = (TextView) findViewById(R.id.foodName);
        textView2 = (TextView) findViewById(R.id.foodDesc);
        textView3 = (TextView) findViewById(R.id.quantText);
        textView4 = (TextView) findViewById(R.id.priceDesText);
        textView5 = (TextView) findViewById(R.id.priceText);
        textView6 = (TextView) findViewById(R.id.deliveryDescText);
        textView7 = (TextView) findViewById(R.id.deliverypriceText);
        textView8 = (TextView) findViewById(R.id.totalPricedescText);
        textView9 = (TextView) findViewById(R.id.totalPriceText);

        orderBtn = (Button) findViewById(R.id.purchaseBtn);

        relativ = (RelativeLayout) findViewById(R.id.relativ);

        Bundle bundle = getIntent().getExtras();
        textView1.setText(bundle.getString("foodName"));
        textView2.setText(bundle.getString("foodDesc"));

        price = bundle.getDouble("foodPrice");
        subTotal = price*bundle.getInt("quantity");

        textView3.setText(String.valueOf(bundle.getInt("quantity")));
        textView5.setText("$"+String.valueOf(subTotal));


        textView7.setText("$"+String.valueOf(deliveryPrice));

        totPrice = subTotal+ deliveryPrice;
        textView9.setText("$"+String.valueOf(totPrice));

        orderBtn.setOnClickListener(this);
        //relativ.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       /* if (view == relativ){
            startActivity(new Intent(getApplicationContext(),PurchaseActivity.class));
        }*/
        if (view == orderBtn){
            startActivity(new Intent(getApplicationContext(),MapsActivity.class));
        }
    }
}
