
package br.etec.tcc;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {
    Button bt;
    CheckBox ckbNA, ckbHAL;
    RadioGroup RG;
    Intent telaConta;

    // Desenvolvedores //
    /* João Vitor Oliveira Santos , Vitor Hugo Correia , Matheus Vitor Chechetto */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.btSegundaTela);
        RG = findViewById(R.id.main_RG);
        ckbNA = findViewById(R.id.ckbNA);
        ckbHAL = findViewById(R.id.ckbHAL);
        telaConta = new Intent(MainActivity.this, MainActivity.class);



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ckbHAL.isChecked() && ckbNA.isChecked()){

                    telaConta = new Intent(MainActivity.this, MainActivity_TelaConta1.class);

                }else if (ckbNA.isChecked()){

                    telaConta = new Intent(MainActivity.this, MainActivity_TelaConta2.class);

                }else if(ckbHAL.isChecked()){

                    telaConta = new Intent(MainActivity.this, MainActivity_TelaConta3.class);

                }else{

                    telaConta = new Intent(MainActivity.this, MainActivity_TelaConta0.class);

                }
                int i = RG.getCheckedRadioButtonId();
                switch (i) {
                    case R.id.main_rMmol:

                        telaConta.putExtra("ChaveTC", "Mmol");
                        break;
                    case R.id.main_rCmol:

                        telaConta.putExtra("ChaveTC", "Cmol");
                        break;
                    }
                    if(i == R.id.main_rMmol || i == R.id.main_rCmol ){
                        startActivity(telaConta);
                    }else {
                        AlertDialog.Builder cxMsg = new AlertDialog.Builder(MainActivity.this);
                        cxMsg.setMessage("Informe a unidade da Conta");
                        cxMsg.setNeutralButton("OK" ,null );
                        cxMsg.show();
                    }

            }});


    }
}