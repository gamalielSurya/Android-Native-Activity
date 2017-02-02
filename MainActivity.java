package com.surya.gamaliel.hitungluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ePanjang, eLebar;
    Button bHitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ePanjang = (EditText) findViewById(R.id.pedit);
        eLebar = (EditText) findViewById(R.id.ledit);
        hasil = (TextView) findViewById(R.id.hasil);
        bHitung = (Button) findViewById(R.id.hitung);

        bHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((TextUtils.isEmpty(ePanjang.getText()))||(TextUtils.isEmpty(eLebar.getText()))) {
                    Toast.makeText(MainActivity.this, "inputan harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        String p = ePanjang.getText().toString().trim();
                        String l = eLebar.getText().toString().trim();

                        double dp = Double.parseDouble(p);
                        double dl = Double.parseDouble(l);

                        if((dp<=0)||(dl<=0)) {
                            Toast.makeText(MainActivity.this, "inputan harus > 0", Toast.LENGTH_SHORT).show();
                            hasil.setText("hasil akan muncul disini...");
                        } else {
                            double temp = dp * dl;
                            hasil.setText("Luas : "+temp);
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
