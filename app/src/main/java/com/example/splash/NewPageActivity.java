package com.example.splash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class NewPageActivity extends AppCompatActivity {
    FrameLayout fl;
    FragmentTransaction ft;
    DrawerLayout dl;
    NavigationView nv;
    Toolbar tb;
    ActionBarDrawerToggle adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);
        dl = findViewById(R.id.drawerlayout);

        nv = findViewById(R.id.navigation);
        fl = findViewById(R.id.framelayout);
        tb = findViewById(R.id.toolbar);

        adt=new ActionBarDrawerToggle(NewPageActivity.this,dl,tb,R.string.open,R.string.close);
//        setSupportActionBar(tb);
//        getSupportActionBar().setTitle("introduction");
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.framelayout, new IntroductionFragment());
        ft.commit();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if( id==R.id.menu_intro){
                    ft=getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout,new IntroductionFragment());
//                    getSupportActionBar().setTitle("introduction");
                    ft.commit();
                }
                if(id==R.id.menu_services){
                    ft=getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout,new ServicesFragment());
//                    getSupportActionBar().setTitle("services");
                    ft.commit();
                }
                if(id==R.id.menu_Tranings){
                    ft=getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout,new TraningsFragment());
                    ft.commit();

                }
                if(id==R.id.menu_product){
                    ft=getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout,new ProductFragment());
                    ft.commit();

                }
                if(id==R.id.menu_Contact){
                    ft=getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout,new ContactFragment());
                    ft.commit();

                }
                dl.closeDrawers();
                return true;
            }
        });

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        adt.syncState();

    }
}