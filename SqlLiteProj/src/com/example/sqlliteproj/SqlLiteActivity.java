package com.example.sqlliteproj;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

public class SqlLiteActivity extends Activity
{
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);
SQLiteDatabase db;
db = openOrCreateDatabase("MovieTitles.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
}
}

