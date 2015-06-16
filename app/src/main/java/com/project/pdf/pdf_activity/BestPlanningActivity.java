package com.project.pdf.pdf_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Jordan on 16/06/2015.
 */
public class BestPlanningActivity extends Activity {

    private String[] drawerItemsList;
    private ListView myDrawer;
    private DrawerLayout mDrawerLayout;
    private TextView myTextView;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partage);


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
                    startActivity(new Intent(BestPlanningActivity.this, AccueilActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(BestPlanningActivity.this, ServicesActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(BestPlanningActivity.this, PlanningActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(BestPlanningActivity.this, MapActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(BestPlanningActivity.this, SpectacleActivity.class));
                    break;
                case 5:
                    startActivity(new Intent(BestPlanningActivity.this, PartageActivity.class));
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
