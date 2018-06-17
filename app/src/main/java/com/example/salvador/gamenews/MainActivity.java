package com.example.salvador.gamenews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salvador.gamenews.Api.GameNewsAPI;
import com.example.salvador.gamenews.Api.RetrofitSingleton;
import com.example.salvador.gamenews.Api.Usuario;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView username;
    TextView password;
    Button boton;
    private GameNewsAPI api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);
        boton = findViewById(R.id.btn_login);

        api = RetrofitSingleton.startAPI(); //inicia la Api

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(username.getText().toString().isEmpty()) && !(password.getText().toString().isEmpty())){
                    solicitarLogin(username.getText().toString(),password.getText().toString());
                }

            }
        });

    }
    public void solicitarLogin(final String username, final String password){
        api.iniciarSesion(username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Usuario>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Usuario usuario) {

                    }
                });

    }
}
