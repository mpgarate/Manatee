package com.mpgarate.manatee;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mpgarate.manatee.model.IdeaStore;
import com.mpgarate.manatee.util.SystemUiHider;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenBrowseActivity extends Activity {
    private final static Logger LOGGER = Logger.getLogger
            (FullscreenBrowseActivity.class.getName());

    private List<String> ideas = new LinkedList<>();

    private SharedPreferences preferences;
    private IdeaStore ideaStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();

        setContentView(R.layout.activity_fullscreen_browse);

        findViewById(R.id.next_idea_button).setOnClickListener
                (buttonClickListener);

        this.preferences = getSharedPreferences(Constants.PREFS_NAME, 0);
        this.ideaStore = new IdeaStore(preferences);

//        ideaStore.create("example idea 1");
//        ideaStore.create("example idea 2");
//        ideaStore.create("example idea 3");
//        ideaStore.create("example idea 4");
//        ideaStore.create("example idea 5");
//        ideaStore.create("example idea 6");

        showRandomItem();
    }

    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getActionBar();
        actionBar.hide();
    }

    private void showRandomItem() {
        TextView t = (TextView) findViewById(R.id.fullscreen_content);

        if (ideas.isEmpty()) {
            ideas = ideaStore.getAll();
            Collections.shuffle(ideas);
        }

        if (!ideas.isEmpty()) {
            t.setText(ideas.remove(0));
        }
    }

    public void manageIdeas(View view) {
        Intent intent = new Intent(this, IdeasActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showRandomItem();
        }
    };
}
