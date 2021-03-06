package com.jasperwong.smartbicycle.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jasperwong.smartbicycle.R;
import com.jasperwong.smartbicycle.fragment.EditDialogFragment;

public class SettingActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{

    private EditDialogFragment mEditDialogFrament=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_setting);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_guide) {
            Intent guideIntent= new Intent(this,RouteActivity.class);
            startActivity(guideIntent);
        }   else if (id == R.id.nav_switch) {
            Intent switchIntent=new Intent(this,SwitchActivity.class);
            startActivity(switchIntent);
        }   else if (id == R.id.nav_setting) {
            Intent settingIntent=new Intent(this,SettingActivity.class);
            startActivity(settingIntent);
        }   else if(id==R.id.nav_share){
            Intent intent=new Intent(this,UserActivity.class);
            startActivity(intent);
        }   else if (id == R.id.nav_connect) {
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {

    }


}
