package com.casbek.passwordcreator;
/* Proje ekibi
 1711012002 Kadir Güler
1711012032 Muhammet Furkan Yiğit */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Kayit extends AppCompatActivity {
    private Button buttonKayitGit1,buttonSifreOlusturGit1,buttonSifrelerimGit1, buttonKaydet;
    private EditText editTextMail,editTextPassword;
    private TextView textViewSifre,textViewKullanici;
    private VeritabaniYardimcisi vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        buttonKayitGit1=findViewById(R.id.buttonKayitGit1);
        buttonSifreOlusturGit1=findViewById(R.id.buttonSifreOlusturGit1);
        buttonSifrelerimGit1=findViewById(R.id.buttonSifrelerimGit1);
        buttonKaydet=findViewById(R.id.buttonKaydet);
        editTextMail=findViewById(R.id.editTextMail);
        editTextPassword=findViewById(R.id.editTextPassword);
        textViewSifre=findViewById(R.id.textViewSifre);
        textViewKullanici=findViewById(R.id.textViewKullanici);
        vt=new VeritabaniYardimcisi(this);


        buttonSifreOlusturGit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent3=new Intent(Kayit.this,MainActivity.class);
             startActivity(intent3);
            }
        });
        buttonSifrelerimGit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(Kayit.this,Sifre.class);
                startActivity(intent4);
            }
        });
        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!editTextMail.getText().toString().trim().equals("") && !editTextPassword.getText().toString().trim().equals("")){


                    new Sifrelerdao().SifreEkle(vt,editTextMail.getText().toString(),editTextPassword.getText().toString());
                    Toast.makeText(getApplicationContext(),"Başarılı",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"Birşeyler girmelisiniz",Toast.LENGTH_LONG).show();

                }



            }
        });




    }
}