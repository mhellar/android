package pete.android.study;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ImageDbHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "image_storage.db";
	public static final int DB_VERSION = 1;
	
	private static final String SQL_CREATE =
		"CREATE TABLE tbl_image (" +
		"_id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
		"image_data BLOB" +
		");"
	;
	
	private static final String SQL_DROP = 
		"DROP TABLE IF EXISTS tbl_image;"
	;
	
	public ImageDbHelper(Context c) {
		super(c, DB_NAME, null, DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE);
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DROP);
		onCreate(db);	
	}
	
	
}
