package com.sow.mas.darsviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_dars);
        ArrayList<DarsModel> data = createDummyData();
        DarsAdapter adapter = new DarsAdapter(data, this);
        listView.setAdapter(adapter);
    }

    private ArrayList<DarsModel> createDummyData() {
        ArrayList<DarsModel> data = new ArrayList<>();

        data.add(new DarsModel("Fiqh of Ramadan", "March 23, 2017", "dars001.pdf"));
        data.add(new DarsModel("Fiqh of Marriage", "March 30, 2017","dars002.pdf"));
        data.add(new DarsModel("Fiqh of Zakat", "April 7th, 2017", "dars003.pdf"));

        return data;
    }
}
