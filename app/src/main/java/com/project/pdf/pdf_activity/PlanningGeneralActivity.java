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
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.project.pdf.pdf_needs.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jordan on 16/06/2015.
 */
public class PlanningGeneralActivity extends Activity {

    public ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planninggeneral);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

    }

    private void prepareListData(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("9h00");
        listDataHeader.add("10h00");
        listDataHeader.add("19h00");

        List<String> neufHeure = new ArrayList<String>();
        neufHeure.add("Le Signe du Triomphe");
        neufHeure.add("Les Vikings");
        neufHeure.add("Le Bal des Oiseaux Fantômes");
        neufHeure.add("Le Secret de la lance");

        List<String> dixHeure = new ArrayList<String>();
        dixHeure.add("Les grandes eaux");
        dixHeure.add("Les chevaliers de la table ronde");
        dixHeure.add("La renaissance de feu");

        List<String> dixneufHeure = new ArrayList<String>();
        dixneufHeure.add("La Cinescenie");
        dixneufHeure.add("Les orgues de feu");

        listDataChild.put(listDataHeader.get(0), neufHeure);
        listDataChild.put(listDataHeader.get(1), dixHeure);
        listDataChild.put(listDataHeader.get(2), dixneufHeure);
    }
}
