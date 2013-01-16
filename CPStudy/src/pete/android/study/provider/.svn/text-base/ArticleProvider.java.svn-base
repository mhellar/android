package pete.android.study.provider;

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

public class ArticleProvider extends ContentProvider {

	private static final UriMatcher sUriMatcher;
	private static final int ARTICLE_TYPE_LIST = 1;
	private static final int ARTICLE_TYPE_ONE = 2;
	static {
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(ArticleMetaData.AUTHORITY, "articles", ARTICLE_TYPE_LIST);
		sUriMatcher.addURI(ArticleMetaData.AUTHORITY, "articles/#", ARTICLE_TYPE_ONE);
	}
	
	private static final HashMap<String, String> sArticlesProjectionMap;
	static {
		sArticlesProjectionMap = new HashMap<String, String>();
		sArticlesProjectionMap.put(ArticleMetaData.ArticleTable.ID, ArticleMetaData.ArticleTable.ID);
		sArticlesProjectionMap.put(ArticleMetaData.ArticleTable.TITLE, ArticleMetaData.ArticleTable.TITLE);
		sArticlesProjectionMap.put(ArticleMetaData.ArticleTable.CONTENT, ArticleMetaData.ArticleTable.CONTENT);
	}
	
	private static class ArticleDBHelper extends SQLiteOpenHelper {
		
		public ArticleDBHelper(Context c) {
			super(c, ArticleMetaData.DATABASE_NAME, null, ArticleMetaData.DATABSE_VERSION);
		}
		
		private static final String SQL_QUERY_CREATE =
			"CREATE TABLE " + ArticleMetaData.ArticleTable.TABLE_NAME + " (" + 
			ArticleMetaData.ArticleTable.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			ArticleMetaData.ArticleTable.TITLE + " TEXT NOT NULL, " +
			ArticleMetaData.ArticleTable.CONTENT + " TEXT NOT NULL" +
			");"
		;
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(SQL_QUERY_CREATE);			
		}

		private static final String SQL_QUERY_DROP =
			"DROP TABLE IF EXISTS " + ArticleMetaData.ArticleTable.TABLE_NAME + ";"
		;
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
			db.execSQL(SQL_QUERY_DROP);
			onCreate(db);			
		}
		
	}
	
	private ArticleDBHelper mDbHelper;
	
	@Override
	public boolean onCreate() {
		mDbHelper = new ArticleDBHelper(getContext());
		return false;
	}
	
	@Override
	public int delete(Uri uri, String where, String[] whereArgs) {
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		int count = 0;
		switch(sUriMatcher.match(uri)) {
			case ARTICLE_TYPE_LIST:
				count = db.delete(ArticleMetaData.ArticleTable.TABLE_NAME, where, whereArgs);
				break;
			
			case ARTICLE_TYPE_ONE:
				String rowId = uri.getPathSegments().get(1);
				count = db.delete(ArticleMetaData.ArticleTable.TABLE_NAME,
					ArticleMetaData.ArticleTable.ID + " = " + rowId + 
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
			case ARTICLE_TYPE_LIST:
				return ArticleMetaData.CONTENT_TYPE_ARTICLES_LIST;
			
			case ARTICLE_TYPE_ONE:
				return ArticleMetaData.CONTENT_TYPE_ARTICLE_ONE;
				
			default:
				throw new IllegalArgumentException("Unknown URI: " + uri);
		}		
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		
		if(sUriMatcher.match(uri) != ARTICLE_TYPE_LIST) {
			throw new IllegalArgumentException("[Insert](01)Unknown URI: " + uri);
		}
		
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		long rowId = db.insert(ArticleMetaData.ArticleTable.TABLE_NAME, null, values);
		if(rowId > 0) {
			Uri articleUri = ContentUris.withAppendedId(ArticleMetaData.CONTENT_URI, rowId);
			getContext().getContentResolver().notifyChange(articleUri, null);
			return articleUri;
		}
		throw new IllegalArgumentException("[Insert](02)Unknown URI: " + uri);	
	}



	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
		switch(sUriMatcher.match(uri)) {
			case ARTICLE_TYPE_LIST:
				builder.setTables(ArticleMetaData.ArticleTable.TABLE_NAME);
				builder.setProjectionMap(sArticlesProjectionMap);
				break;
			
			case ARTICLE_TYPE_ONE:
				builder.setTables(ArticleMetaData.ArticleTable.TABLE_NAME);
				builder.setProjectionMap(sArticlesProjectionMap);
				builder.appendWhere(ArticleMetaData.ArticleTable.ID + " = " +
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
			case ARTICLE_TYPE_LIST:
				count = db.update(ArticleMetaData.ArticleTable.TABLE_NAME, values, where, whereArgs);
				break;
				
			case ARTICLE_TYPE_ONE:
				String rowId = uri.getPathSegments().get(1);
				count = db.update(ArticleMetaData.ArticleTable.TABLE_NAME, values,
					ArticleMetaData.ArticleTable.ID + " = " + rowId + 
						(!TextUtils.isEmpty(where) ? " AND (" + ")" : ""),
				whereArgs);
				
			default:
				throw new IllegalArgumentException("Unknown URI: " + uri);			
		}
		
		getContext().getContentResolver().notifyChange(uri, null);		
		return count;
	}

}
