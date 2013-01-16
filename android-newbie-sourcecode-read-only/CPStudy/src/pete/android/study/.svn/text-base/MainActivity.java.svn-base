package pete.android.study;

import pete.android.study.provider.ArticleMetaData;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView txtResult;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        txtResult = (TextView)findViewById(R.id.txtResult);
        
        insertData();
        queryData();
    }
    
    private void insertData() {
    	ContentValues cv = new ContentValues();
    	cv.put(ArticleMetaData.ArticleTable.TITLE, "Title 1");
    	cv.put(ArticleMetaData.ArticleTable.CONTENT, "Content 1");
    	getContentResolver().insert(ArticleMetaData.CONTENT_URI, cv);
    	
    	cv.put(ArticleMetaData.ArticleTable.TITLE, "Title 2");
    	cv.put(ArticleMetaData.ArticleTable.CONTENT, "Content 2");
    	getContentResolver().insert(ArticleMetaData.CONTENT_URI, cv);
    }
    private void queryData() {
    	Cursor c = getContentResolver().query(ArticleMetaData.CONTENT_URI, new String[] {
    		ArticleMetaData.ArticleTable.ID,
    		ArticleMetaData.ArticleTable.TITLE,
    		ArticleMetaData.ArticleTable.CONTENT
    	}, null, null, null);
    	String out = "";
    	if(c.moveToFirst()) {
    		while(!c.isAfterLast()) {
    			out += c.getString(c.getColumnIndexOrThrow(ArticleMetaData.ArticleTable.TITLE));
    			out += "\n";
    			out += c.getString(c.getColumnIndexOrThrow(ArticleMetaData.ArticleTable.CONTENT));
    			out += "\n\n";
    			c.moveToNext();
    		}
    		txtResult.setText(out);
    	}
    	
    }
}