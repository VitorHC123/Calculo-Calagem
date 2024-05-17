package br.etec.tcc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity_TelaConta2 extends AppCompatActivity {
    TextView txtK, txtCA, txtMG,txtAL,txtH, txtV2, txtPRNT, txtResul;
    Button btCalc;
    double K, CA, MG, H, AL, V2, PRNT, SB, T, V1, r, rp1, rp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tela_conta2);

        txtK = findViewById(R.id.txtK);
        txtCA = findViewById(R.id.txtCA);
        txtMG = findViewById(R.id.txtMG);
        txtH = findViewById(R.id.txtNA);
        txtAL = findViewById(R.id.txtH);
        txtV2 = findViewById(R.id.txtV2);
        txtPRNT = findViewById(R.id.txtPRNT);
        btCalc = findViewById(R.id.btMmol);
        txtResul = findViewById(R.id.txtResultado);


        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                K = Double.parseDouble(txtK.getText().toString());
                CA = Double.parseDouble(txtCA.getText().toString());
                MG = Double.parseDouble(txtMG.getText().toString());
                H = Double.parseDouble(txtH.getText().toString());
                AL = Double.parseDouble(txtAL.getText().toString());
                V2 = Double.parseDouble(txtV2.getText().toString());
                PRNT = Double.parseDouble(txtPRNT.getText().toString());

                String valor = getIntent().getStringExtra("ChaveTC");
                if(valor.equals("Mmol")){

                    SB = K + CA + MG + 0;
                    T = SB + H + AL;
                    V1 = (SB / T) * 100;
                    rp1  = (V2 - V1) * T;
                    r = rp1 / (10 * PRNT);

                }else if(valor.equals("Cmol")){

                    SB = K + CA + MG + 0;
                    T = SB + H + AL;
                    V1 = (SB / T) * 100;
                    rp1  = (V2 - V1) * T;
                    r = rp1 /  PRNT;

                }
                String a = "T/Ha";
                txtResul.setText(String.format("Resultado: %.3f" , r) + " " + a );
            }});
    }
}