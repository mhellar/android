package com.example.moviescontentprovider.provider;

import java.util.HashMap;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class MovieProvider extends ContentProvider {

	private static final UriMatcher sUriMatcher;
	private static final int MOVIE_TYPE_LIST = 1;
	private static final int MOVIE_TYPE_ONE = 2;
	static {
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(MovieMetaData.AUTHORITY, "movies", MOVIE_TYPE_LIST);
		sUriMatcher.addURI(MovieMetaData.AUTHORITY, "movies/#", MOVIE_TYPE_ONE);
	}
	
	private static final HashMap<String, String> sMoviesProjectionMap;
	static {
		sMoviesProjectionMap = new HashMap<String, String>();
		sMoviesProjectionMap.put(MovieMetaData.MovieTable.ID, MovieMetaData.MovieTable.ID);
		sMoviesProjectionMap.put(MovieMetaData.MovieTable.TITLE, MovieMetaData.MovieTable.TITLE);
		sMoviesProjectionMap.put(MovieMetaData.MovieTable.CONTENT, MovieMetaData.MovieTable.CONTENT);
	}
	
	private static class MovieDBHelper extends SQLiteOpenHelper {
		
		public MovieDBHelper(Context c) {
			super(c, MovieMetaData.DATABASE_NAME, null, MovieMetaData.DATABSE_VERSION);
		}
		
		private static final String SQL_QUERY_CREATE =
			"CREATE TABLE " + MovieMetaData.MovieTable.TABLE_NAME + " (" + 
			MovieMetaData.MovieTable.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			MovieMetaData.MovieTable.TITLE + " TEXT NOT NULL, " +
			MovieMetaData.MovieTable.CONTENT + " TEXT NOT NULL" +
			");"
		;
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(SQL_QUERY_CREATE);			
		}

		private static final String SQL_QUERY_DROP =
			"DROP TABLE IF EXISTS " + MovieMetaData.MovieTable.TABLE_NAME + ";"
		;
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
			db.execSQL(SQL_QUERY_DROP);
			onCreate(db);			
		}
		
	}
	
	private MovieDBHelper mDbHelper;
	
	@Override
	public boolean onCreate() {
		mDbHelper = new MovieDBHelper(getContext());
		return false;
	}
	
	@Override
	public int delete(Uri uri, String where, String[] whereArgs) {
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		int count = 0;
		switch(sUriMatcher.match(uri)) {
			case MOVIE_TYPE_LIST:
				count = db.delete(MovieMetaData.MovieTable.TABLE_NAME, where, whereArgs);
				break;
			
			case MOVIE_TYPE_ONE:
				String rowId = uri.getPathSegments().get(1);
				count = db.delete(MovieMetaData.MovieTable.TABLE_NAME,
					MovieMetaData.MovieTable.ID + " = " + rowId + 
						(!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""),
					whereArgs);
				break;
			
			default:
				throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		
		getContext().getContentResolver().notifyChange(uri, null);		
		return count;
	}

	@Override
	public String getType(Uri uri) {
		
		switch(sUriMatcher.match(uri)) {
			case MOVIE_TYPE_LIST:
				return MovieMetaData.CONTENT_TYPE_MOVIES_LIST;
			
			case MOVIE_TYPE_ONE:
				return MovieMetaData.CONTENT_TYPE_MOVIE_ONE;
				
			default:
				throw new IllegalArgumentException("Unknown URI: " + uri);
		}		
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		
		if(sUriMatcher.match(uri) != MOVIE_TYPE_LIST) {
			throw new IllegalArgumentException("[Insert](01)Unknown URI: " + uri);
		}
		
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		long rowId = db.insert(MovieMetaData.MovieTable.TABLE_NAME, null, values);
		if(rowId > 0) {
			Uri movieUri = ContentUris.withAppendedId(MovieMetaData.CONTENT_URI, rowId);
			getContext().getContentResolver().notifyChange(movieUri, null);
			return movieUri;
		}
		throw new IllegalArgumentException("[Insert](02)Unknown URI: " + uri);	
	}



	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
		switch(sUriMatcher.match(uri)) {
			case MOVIE_TYPE_LIST:
				builder.setTables(MovieMetaData.MovieTable.TABLE_NAME);
				builder.setProjectionMap(sMoviesProjectionMap);
				break;
			
			case MOVIE_TYPE_ONE:
				builder.setTables(MovieMetaData.MovieTable.TABLE_NAME);
				builder.setProjectionMap(sMoviesProjectionMap);
				builder.appendWhere(MovieMetaData.MovieTable.ID + " = " +
						uri.getPathSegments().get(1));
				break;
			
			default:
				throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		
		SQLiteDatabase db = mDbHelper.getReadableDatabase();
		Cursor queryCursor = builder.query(db, projection, selection, selectionArgs, null, null, null);
		queryCursor.setNotificationUri(getContext().getContentResolver(), uri);
		
		return queryCursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String where,
			String[] whereArgs) {
		
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		int count = 0;
		switch(sUriMatcher.match(uri)) {
			case MOVIE_TYPE_LIST:
				count = db.update(MovieMetaData.MovieTable.TABLE_NAME, values, where, whereArgs);
				break;
				
			case MOVIE_TYPE_ONE:
				String rowId = uri.getPathSegments().get(1);
				count = db.update(MovieMetaData.MovieTable.TABLE_NAME, values,
					MovieMetaData.MovieTable.ID + " = " + rowId + 
						(!TextUtils.isEmpty(where) ? " AND (" + ")" : ""),
				whereArgs);
				
			default:
				throw new IllegalArgumentException("Unknown URI: " + uri);			
		}
		
		getContext().getContentResolver().notifyChange(uri, null);		
		return count;
	}

}