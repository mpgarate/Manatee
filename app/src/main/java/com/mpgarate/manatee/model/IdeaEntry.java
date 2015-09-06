package com.mpgarate.manatee.model;

import android.content.SharedPreferences;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class IdeaEntry {
    private final static String IDEA_ENTRIES_KEY = "idea_entries";
    private String text;

    public IdeaEntry(String text) {
        if (null == text || text.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void saveTo(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> entries = Collections.unmodifiableSet(preferences
                .getStringSet(IDEA_ENTRIES_KEY, Collections.<String>emptySet
                        ()));

        Set<String> newSet = new HashSet<String>(entries);

        newSet.add(text);

        editor.putStringSet(IDEA_ENTRIES_KEY, newSet);
        // consider using .apply();
        editor.commit();
    }

    public String toString() {
        return text;
    }
}
