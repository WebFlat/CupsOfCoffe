package com.example.slava.cupsofcoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    //Обьявляем переменные.....................
    TextView tvCups,tvPrice;
    Button submit,increment,decrement,clear;
    public int numberOfCoffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Вывод стоимости.........................

    public void SubmitOrder(View view) {
        submit = (Button) findViewById(R.id.submit);
        clear = (Button) findViewById(R.id.clear);
        switch (view.getId()) {
            case (R.id.submit):
                DisplayCups(numberOfCoffees);
                DisplayPrice(numberOfCoffees * 5);
                break;
            case (R.id.clear):
                DisplayCups(0);
                DisplayPrice(0);
                Toast.makeText(this,"Сброс", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    //Вывод количества чашек........................

    public void DisplayCups(int order){
        tvCups = (TextView)findViewById(R.id.tvCups);
        tvCups.setText(""+ order);

    }



    //Вывод стоимости................................

    public void DisplayPrice(int order) {
        tvPrice=(TextView)findViewById(R.id.tvPrice);
        tvPrice.setText("Всего: " + (NumberFormat.getCurrencyInstance().format(order)) + "\nСпасибо!");
    }


    //Изменение количества чашек......................

    public void changeCups(View view) {
        increment=(Button)findViewById(R.id.increment);
        decrement=(Button)findViewById(R.id.decrement);
        switch (view.getId()){
            case (R.id.increment):
                DisplayCups(numberOfCoffees=++numberOfCoffees);
                break;
            case (R.id.decrement):
                if (numberOfCoffees>=1) {
                    DisplayCups(numberOfCoffees=--numberOfCoffees);
                    break;
                }
                else {
                    Toast.makeText(this,"Ввод мешьше 0 не возможен",Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }
}
