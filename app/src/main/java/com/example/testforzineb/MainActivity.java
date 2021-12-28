package com.example.testforzineb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
 Integer val;
    EditText input1;
    EditText input2;
    Button button;
    RadioGroup radio;
    TextView resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.editTextTextPersonName);
        input2 = findViewById(R.id.editTextTextPersonName2);
        radio=findViewById(R.id.radioGroup);
        resultat = findViewById(R.id.textView);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // RadioButton r=findViewById(radio.getCheckedRadioButtonId());
               // String f=r.getText().toString();
               if(val==1){
                   double W = Double.parseDouble(input1.getText().toString());
                  double Ww = Double.parseDouble(input2.getText().toString());
                  double x=Math.pow(10,Ww/10);
                  double res=W*(Math.log10(1+x) /Math.log10(2));

                   double d = (double) Math.round(res * 100) / 100;

                   resultat.setText("le debit "+Double.toString(d));

               }
               if(val==0){
                  double W = Double.parseDouble(input1.getText().toString());
                 double Ww = Double.parseDouble(input2.getText().toString());

                  double res=W*(Math.log10(1+Ww) /Math.log10(2));
                   double d = (double) Math.round(res * 100) / 100;

                   resultat.setText("le debit "+Double.toString(d));
              }


            }
        });


    }

    public void clicked(View view) {
        boolean checked=((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.radioButton:
                if(checked)
                    val=0;break;
            case R.id.radioButton2:
                if(checked)
                    val=1;break;

        }
    }
}