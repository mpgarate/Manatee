package com.mpgarate.manatee;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mpgarate.manatee.adapter.IdeaAdapter;
import com.mpgarate.manatee.model.IdeaStore;

import java.util.List;

public class IdeasActivity extends Activity {

    private RecyclerView recyclerView;
    private IdeaStore ideaStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas);
        recyclerView = (RecyclerView) findViewById(R.id.idea_list_recycler);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ideaStore = new IdeaStore(getSharedPreferences(Constants.PREFS_NAME,
                0));
        List<String> ideas = ideaStore.getAll();
        IdeaAdapter adapter = new IdeaAdapter(ideas);
        recyclerView.setAdapter(adapter);

    }
}
