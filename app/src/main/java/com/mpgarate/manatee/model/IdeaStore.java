package com.mpgarate.manatee.model;

import android.content.SharedPreferences;

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

    public IdeaStore(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public void create(String text) {
        if (null == text || text.isEmpty()) {
            throw new IllegalArgumentException();
        }

        SharedPreferences.Editor editor = preferences.edit();

        Collection<String> entries = getAll();

        Set<String> newSet = new HashSet<String>(entries);

        newSet.add(text);

        editor.putStringSet(IDEA_ENTRIES_KEY, newSet);
        // consider using .apply();
        editor.commit();
    }

    public List<String> getAll() {
        return new ArrayList<>(preferences.getStringSet
                (IDEA_ENTRIES_KEY, Collections.<String>emptySet()));
    }

    public int size() {
        return getAll().size();
    }
}
