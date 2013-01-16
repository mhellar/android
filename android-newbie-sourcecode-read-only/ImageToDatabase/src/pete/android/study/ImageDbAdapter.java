package pete.android.study;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ImageDbAdapter {
	public static final String TABLE_NAME = "tbl_image";
	public static final String COL_ID = "_id";
	public static final String COL_DATA = "image_data"; 
	
	public static final String[] PROJECTION_ALL = new String[] {
		COL_ID, COL_DATA
	};
	
	private Context mContext;
	private SQLiteDatabase mDb;
	private ImageDbHelper mDbHelper;
	
	public ImageDbAdapter(Context c) {
		mContext = c;
	}
	
	public ImageDbAdapter open() throws SQLException {
		mDbHelper = new ImageDbHelper(mContext);
		mDb = mDbHelper.getWritableDatabase();
		return this;
	}
	
	public void close() {
		mDbHelper.close();
	}
	
	public long insert(byte[] image) {
		return mDb.insert(TABLE_NAME, null, createContentValues(image));
	}
	
	private ContentValues createContentValues(byte[] image) {
		ContentValues cv = new ContentValues();
		cv.put(COL_DATA, image);
		return cv;
	}
	
	public byte[] fetchSingle(int id) {
		Cursor queryCursor = mDb.query(TABLE_NAME, PROJECTION_ALL, COL_ID + " = " + id, null, null, null, null);
		if(queryCursor == null) {
			return null;
		}
		byte[] image = null;
		if(queryCursor.moveToFirst()) {
			image = queryCursor.getBlob(queryCursor.getColumnIndexOrThrow(COL_DATA));
		}
		queryCursor.close();
		
		return image;
		
	}
}
