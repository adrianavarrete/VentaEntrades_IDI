package com.example.marlen.ventaentrades_idi;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class infoCompra extends AppCompatActivity implements View.OnClickListener {

    TextView titolObra, preu;
    EditText correu;
    long num;
    DbHelper baseDades;
    RadioButton CJove, CAturat, CUniv;
    ImageView done;
    int  numbutaquesIni, entrades;
    String data;
    double aux2 = 0.0, preuObra = 0.0;
    DecimalFormat preuTotal = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_compra);

        baseDades = new DbHelper(this);

        correu = (EditText)findViewById(R.id.correu);

        titolObra = (TextView)findViewById(R.id.titolCompra);
        preu = (TextView)findViewById(R.id.preuCompra);

        done = (ImageView)findViewById(R.id.done);
        done.setOnClickListener(this);

        CJove = (RadioButton)findViewById(R.id.radiojove);
        CAturat = (RadioButton)findViewById(R.id.radioaturat);
        CUniv = (RadioButton)findViewById(R.id.radiouniversitari);

        Bundle b = getIntent().getExtras();
        num = b.getLong("numero");
        titolObra.setText(b.getString("titol"));
        entrades = b.getInt("entrades");
        data = b.getString("data");
       // numbutaquesSelec = b.getInt("numButs"); //num butaques seleccionades
        Cursor c = baseDades.getFuncio(titolObra.getText().toString(),data);
        if(c.moveToFirst()) {
            preuObra = c.getDouble(c.getColumnIndex(baseDades.CN_PREU));
            numbutaquesIni = c.getInt(c.getColumnIndex(baseDades.CN_BUTAQUES_DISP)); //numbutaques ABANS compra
        }
        preuObra = preuObra*entrades;
        aux2 = preuObra;
        preu.setText(preuTotal.format(aux2) + "€");

    }

    public void onRadioButtonClicked(View v){
        double desc;
        double aux;
        switch (v.getId()){
            case R.id.radiocap:
                preu.setText(preuTotal.format(aux2) + "€");
                break;
            case R.id.radiojove:
                    desc = preuObra*0.20;
                    aux = preuObra - desc;
                    preu.setText(preuTotal.format(aux) + "€");
                break;
            case R.id.radioaturat:
                    desc = preuObra*0.15;
                    aux = preuObra - desc;
                    preu.setText(preuTotal.format(aux) + "€");
                break;
            case R.id.radiouniversitari:
                    desc = preuObra*0.15;
                    aux = preuObra - desc;
                    preu.setText(preuTotal.format(aux) + "€");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.done):
                baseDades.updateNum(titolObra.getText().toString(),data,num);
                baseDades.updateNumButDisp(titolObra.getText().toString(),data,numbutaquesIni-entrades);
                baseDades.updateCorreus(titolObra.getText().toString(),data,correu.getText().toString());
                Intent intent = new Intent(getApplicationContext(), llistaObres.class);
                startActivity(intent);
                break;

        }
    }
}
