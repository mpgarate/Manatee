package com.mpgarate.manatee;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.mpgarate.manatee.model.IdeaStore;

import java.util.List;

public class IdeasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas);

        SharedPreferences preferences = getSharedPreferences(Constants
                .PREFS_NAME, 0);
        final IdeaStore ideaStore = new IdeaStore(preferences);


        List<String> data = ideaStore.getAll();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android
                .R.layout.simple_list_item_1, data);

        ListView lv = (ListView) findViewById(R.id.idea_list);

        lv.setAdapter(adapter);

        final EditText editText = (EditText) findViewById(R.id.edit_text);

        editText.setOnEditorActionListener(new EditText
                .OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent
                    event) {
                if (null != v && actionId == EditorInfo.IME_ACTION_DONE) {
                    String input = v.getText().toString();
                    ideaStore.create(input);
                    adapter.insert(input, 0);
                }

                return false;
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener
                () {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                view.setSelected(true);
                return true;
            }
        });

        setTitle("Ideas");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ideas, menu);

        return super.onCreateOptionsMenu(menu);
    }

}
