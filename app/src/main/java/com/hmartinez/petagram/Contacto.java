package com.hmartinez.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.hmartinez.petagram.mail.SendMail;

public class Contacto extends AppCompatActivity {

    //Declaring EditText
    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar abContacto = (Toolbar)findViewById(R.id.tbGeneral);
        setSupportActionBar(abContacto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextEmail = (EditText)findViewById(R.id.tietMail_contacto);
        editTextSubject = (EditText)findViewById(R.id.tietNombre_contacto);
        editTextMessage = (EditText)findViewById(R.id.tietComentario_contacto);

        buttonSend = (Button)findViewById(R.id.btnEnviarMail_contacto);
        buttonSend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        //Getting content for email
        String email = editTextEmail.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
}