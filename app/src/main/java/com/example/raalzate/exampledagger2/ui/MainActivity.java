package com.example.raalzate.exampledagger2.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.raalzate.exampledagger2.App;
import com.example.raalzate.exampledagger2.R;
import com.example.raalzate.exampledagger2.api.NetworkApi;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject NetworkApi networkApi;

    @BindView(R.id.text) TextView userAvailable;
    @BindView(R.id.toolbar) Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        App.getDiComponent(this).inject(this);

        boolean injected =  networkApi != null;

        userAvailable.setText("Dependency injection worked: " + String.valueOf(injected));
    }


}
