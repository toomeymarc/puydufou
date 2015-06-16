package com.project.pdf.pdf_activity;

import android.app.Activity;
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

import com.project.pdf.pdf_descriptifs.FicheSpectacles;
import com.project.pdf.pdf_needs.Spectacles;
import com.project.pdf.pdf_needs.SpectaclesListAdapter;

import java.util.ArrayList;

/**
 * Created by Jordan on 15/06/2015.
 */
public class SpectacleActivity extends Activity {

    String[] SpectaclesNames = {"Spectacle1","Spectacle2","Spectacle3","Spectacle4","Spectacle5","Spectacle6","Spectacle7","Spectacle8","Spectacle9"};
    String[] SpectaclesHeuresDebut = {"12h30","13h00","13h30","14h00","14h30","15h00","15h30","16h00","16h30"};
    String[] SpectaclesDuree = {"30min","30min","30min","30min","30min","30min","30min","30min","30min"};

    ArrayList<Spectacles> listSpectacles;

    private String[] drawerItemsList;
    private ListView myDrawer;
    private DrawerLayout mDrawerLayout;
    private TextView myTextView;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spectacle);

        final ListView viewSpectacles;
        viewSpectacles = (ListView) findViewById(R.id.listSpectacles);
        Drawable[] listNotes = {
                getResources().getDrawable(R.drawable.note0),
                getResources().getDrawable(R.drawable.note1),
                getResources().getDrawable(R.drawable.note2),
                getResources().getDrawable(R.drawable.note3),
                getResources().getDrawable(R.drawable.note4),
                getResources().getDrawable(R.drawable.note5)};

        listSpectacles = new ArrayList<>();

        for (int i = 0; i < listNotes.length; i++) {
            listSpectacles.add(new Spectacles(i + 1, SpectaclesNames[i],SpectaclesHeuresDebut[i],SpectaclesDuree[i], listNotes[i]));
        }
        viewSpectacles.setAdapter(new SpectaclesListAdapter(getApplicationContext(), listSpectacles));

        viewSpectacles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SpectacleActivity.this, FicheSpectacles.class);
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
                    startActivity(new Intent(SpectacleActivity.this, AccueilActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(SpectacleActivity.this, ServicesActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(SpectacleActivity.this, PlanningActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(SpectacleActivity.this, MapActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(SpectacleActivity.this, SpectacleActivity.class));
                    break;
                case 5:
                    startActivity(new Intent(SpectacleActivity.this, PartageActivity.class));
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
