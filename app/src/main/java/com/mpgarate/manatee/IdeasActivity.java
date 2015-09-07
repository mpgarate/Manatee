package com.mpgarate.manatee;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.mpgarate.manatee.model.IdeaStore;

public class IdeasActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas);

        SharedPreferences preferences = getSharedPreferences(Constants.PREFS_NAME, 0);
        IdeaStore ideaStore = new IdeaStore(preferences);

        String[] data = ideaStore.getAll().toArray(new String[ideaStore.size()]);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android
                .R.layout.simple_list_item_1, data);

        ListView lv = getListView();

        lv.setAdapter(adapter);



    }

}
