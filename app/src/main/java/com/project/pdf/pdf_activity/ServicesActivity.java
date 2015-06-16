package com.project.pdf.pdf_activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.project.pdf.pdf_descriptifs.FicheRestaurant;
import com.project.pdf.pdf_needs.BoutiqueListAdapter;
import com.project.pdf.pdf_needs.Boutiques;
import com.project.pdf.pdf_needs.RestaurantListAdapter;
import com.project.pdf.pdf_needs.Restaurants;

import java.util.ArrayList;

/**
 * Created by Jordan on 15/06/2015.
 */
public class ServicesActivity extends Activity {

    String[] RestaurantsName = {"Resto0", "Resto1", "Resto2", "Resto3", "Resto4", "Resto5"};
    String[] BoutiquesName = {"Boutique1", "Boutique2", "Boutique3", "Boutique4", "Boutique5", "Boutique6", "Boutique7", "Boutique8"};
    ArrayList<Boutiques> listBoutiques;
    ArrayList<Restaurants> listRestaurant;
    private String[] drawerItemsList;
    private ListView myDrawer;
    private DrawerLayout mDrawerLayout;
    private TextView myTextView;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        final ListView viewRestaurant;
        viewRestaurant = (ListView) findViewById(R.id.listRestaurants);
        Drawable[] listNotes = {
                getResources().getDrawable(R.drawable.note0),
                getResources().getDrawable(R.drawable.note1),
                getResources().getDrawable(R.drawable.note2),
                getResources().getDrawable(R.drawable.note3),
                getResources().getDrawable(R.drawable.note4),
                getResources().getDrawable(R.drawable.note5)};

        listRestaurant = new ArrayList<>();

        for (int i = 0; i < listNotes.length; i++) {
            listRestaurant.add(new Restaurants(i + 1, RestaurantsName[i], listNotes[i]));
        }
        viewRestaurant.setAdapter(new RestaurantListAdapter(getApplicationContext(), listRestaurant));

        ListView viewBoutiques;
        viewBoutiques = (ListView) findViewById(R.id.listBoutiques);

        listBoutiques = new ArrayList<>();

        for (int i = 0; i < listNotes.length; i++) {
            listBoutiques.add(new Boutiques(i + 1, BoutiquesName[i], listNotes[i]));
        }
        viewBoutiques.setAdapter(new BoutiqueListAdapter(getApplicationContext(), listBoutiques));

        viewRestaurant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ServicesActivity.this, FicheRestaurant.class);
                startActivity(intent);
            }
        });

        drawerItemsList = getResources().getStringArray(R.array.items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        myTextView = (TextView) findViewById(R.id.display_drawer_txt);
        myDrawer = (ListView) findViewById(R.id.my_drawer);

        myDrawer.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_item, drawerItemsList));

        myDrawer.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, drawerItemsList));
        myDrawer.setOnItemClickListener(new MyDrawerItemClickListener());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_launcher, R.string.ouverture, R.string.fermeture) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(R.string.titre);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(R.string.titre_apres_ouverture);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }

    public class MyDrawerItemClickListener implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch(position) {
                case 0:
                    startActivity(new Intent(ServicesActivity.this, AccueilActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(ServicesActivity.this, ServicesActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(ServicesActivity.this, PlanningActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(ServicesActivity.this, MapActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(ServicesActivity.this, SpectacleActivity.class));
                    break;
                case 5:
                    startActivity(new Intent(ServicesActivity.this, PartageActivity.class));
                    break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}