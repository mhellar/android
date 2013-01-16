package com.example.moviescontentprovider.provider;

import android.net.Uri;
import android.provider.BaseColumns;

public class MovieMetaData {
	private MovieMetaData() { }
	
	public static final String AUTHORITY = "com.example.moviescontentprovider.provider.Movies";
	public static final Uri CONTENT_URI = Uri.parse(
		"content://" + AUTHORITY + "/movies"
	);
	
	public static final String DATABASE_NAME = "movies.db";
	public static final int DATABSE_VERSION = 1;
	
	public static final String CONTENT_TYPE_MOVIES_LIST = "vnd.android.cursor.dir/vnd.example.movies";
	public static final String CONTENT_TYPE_MOVIE_ONE = "vnd.android.cursor.item/vnd.example.movies";
	
	public class MovieTable implements BaseColumns {
		private MovieTable() { }
		
		public static final String TABLE_NAME = "tbl_movies";
		
		public static final String ID = "_id";
		public static final String TITLE = "title";
		public static final String CONTENT = "description";
	}
	
}
