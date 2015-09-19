package com.mpgarate.manatee.model;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IdeaStore {
    private final static String IDEA_ENTRIES_KEY = "idea_entries";

    private final SharedPreferences preferences;

    private Set<String> ideas;

    public IdeaStore(SharedPreferences preferences) {
        this.preferences = preferences;
        this.ideas = preferences.getStringSet(IDEA_ENTRIES_KEY, new HashSet
                <String>());
    }

    private void writeChanges() {
        SharedPreferences.Editor editor = preferences.edit();

        editor.putStringSet(IDEA_ENTRIES_KEY, ideas);
        // consider using .apply();
        editor.commit();
    }

    public void create(String text) {
        if (null == text || text.isEmpty()) {
            throw new IllegalArgumentException();
        }

        ideas.add(text);

        writeChanges();
    }

    public void remove(String text) {
        if (null == text || text.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Log.i("removing", text);
        Log.i("success?", "" + ideas.remove(text));
        writeChanges();
    }

    public List<String> getAll() {
        return new ArrayList<>(ideas);
    }

    public int size() {
        return ideas.size();
    }
}
