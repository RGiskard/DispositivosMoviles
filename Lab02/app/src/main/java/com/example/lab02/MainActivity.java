package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;




import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;

import android.view.View;
import android.widget.ImageButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton boton1=(ImageButton) findViewById(R.id.imgbt1);
        boton1.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View view) {
                                          Toast notificar=Toast.makeText(MainActivity.this,"Ciencia Ficción",Toast.LENGTH_LONG);
                                          notificar.show();
                                          Intent intento=new Intent(getApplicationContext(),SlideBookActivity.class);
                                          startActivity(intento);
                                      }
                                  }

        );

        ImageButton boton2=(ImageButton) findViewById(R.id.imgbt2);
        boton2.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View view) {
                                          Toast notificar=Toast.makeText(MainActivity.this,"Literatura Fantástica",Toast.LENGTH_LONG);
                                          notificar.show();
                                          Intent intento=new Intent(getApplicationContext(),SlideBookActivity.class);
                                          startActivity(intento);
                                      }
                                  }

        );

        ImageButton boton3=(ImageButton) findViewById(R.id.imgbt3);
        boton3.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View view) {
                                          Toast notificar=Toast.makeText(MainActivity.this,"Ficción Gótica",Toast.LENGTH_LONG);
                                          notificar.show();
                                          Intent intento=new Intent(getApplicationContext(),SlideBookActivity.class);
                                          startActivity(intento);
                                      }
                                  }

        );

        ImageButton boton4=(ImageButton) findViewById(R.id.imgbt4);
        boton4.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View view) {
                                          Toast notificar=Toast.makeText(MainActivity.this,"Cuentos de Hadas",Toast.LENGTH_LONG);
                                          notificar.show();
                                          Intent intento=new Intent(getApplicationContext(),SlideBookActivity.class);
                                          startActivity(intento);
                                      }
                                  }

        );

    }


    @Override
    public void onClick(View view) {

    }

    public  void launch1(View view)
    {
        loadFragment(new cFictionFragment());

    }
    public  void launch2(View view)
    {
        loadFragment(new cFictionFragment());

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                loadFragment(new cFictionFragment());
                break;
            case R.id.nav_gallery:
                loadFragment(new lFantasticFragment());
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.scene,fragment);
        fragmentTransaction.commit();
    }
}
