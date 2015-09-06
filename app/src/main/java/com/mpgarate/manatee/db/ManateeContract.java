package com.mpgarate.manatee.db;

import android.provider.BaseColumns;

public final class ManateeContract {
    public ManateeContract() {}

    public static abstract class IdeaEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TEXT = "text";
        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + IdeaEntry.TABLE_NAME + " (" +
                        IdeaEntry._ID + " INTEGER PRIMARY KEY," +
                        IdeaEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                        IdeaEntry.COLUMN_NAME_TEXT + TEXT_TYPE + COMMA_SEP +
                        " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + IdeaEntry.TABLE_NAME;
    }



}
