package com.example.moviescontentprovider;
import com.example.moviescontentprovider.provider.MovieMetaData;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;


public class MoviesContentProvider extends Activity {
	TextView txtResult;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtResult = (TextView)findViewById(R.id.txtResult);
        
        deleteData();
        
        final Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
   		public void onClick(View v) {
        insertData();
        queryData();
    	}  
		});        
    }
    
    private void insertData() {
    	ContentValues cv = new ContentValues();
    	cv.put(MovieMetaData.MovieTable.TITLE, "The Shawshank Redemption");
    	cv.put(MovieMetaData.MovieTable.CONTENT, "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.");
    	getContentResolver().insert(MovieMetaData.CONTENT_URI, cv);
    	
    	cv.put(MovieMetaData.MovieTable.TITLE, "The Godfather");
    	cv.put(MovieMetaData.MovieTable.CONTENT, "the aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
    	getContentResolver().insert(MovieMetaData.CONTENT_URI, cv);
    	
    	cv.put(MovieMetaData.MovieTable.TITLE, "The Godfather: Part II");
    	cv.put(MovieMetaData.MovieTable.CONTENT, "The early life and career of Vito Corleone in 1920s New York is portrayed while his son, Michael, expands and tightens his grip on his crime syndicate stretching from Lake Tahoe, Nevada to pre-revolution 1958 Cuba.");
    	getContentResolver().insert(MovieMetaData.CONTENT_URI, cv);
    	
    	cv.put(MovieMetaData.MovieTable.TITLE, "The Good, the Bad and the Ugly");
    	cv.put(MovieMetaData.MovieTable.CONTENT, "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.");
    	getContentResolver().insert(MovieMetaData.CONTENT_URI, cv);
    	
    	cv.put(MovieMetaData.MovieTable.TITLE, "Pulp Fiction");
    	cv.put(MovieMetaData.MovieTable.CONTENT, "The lives of two mob hit men, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.");
    	getContentResolver().insert(MovieMetaData.CONTENT_URI, cv);
    	
    	cv.put(MovieMetaData.MovieTable.TITLE, "12 Angry Men");
    	cv.put(MovieMetaData.MovieTable.CONTENT, "A dissenting juror in a murder trial slowly manages to convince the others that the case is not as obviously clear as it seemed in court.");
    	getContentResolver().insert(MovieMetaData.CONTENT_URI, cv);
    	
    	cv.put(MovieMetaData.MovieTable.TITLE, "Schindler's List");
    	cv.put(MovieMetaData.MovieTable.CONTENT, "In Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.");
    	getContentResolver().insert(MovieMetaData.CONTENT_URI, cv);
    	
    	cv.put(MovieMetaData.MovieTable.TITLE, "One Flew Over the Cuckoo's Nest");
    	cv.put(MovieMetaData.MovieTable.CONTENT, "Upon arrival at a mental institution, a brash rebel rallies the patients together to take on the oppressive Nurse Ratched, a woman more a dictator than a nurse.");
    	getContentResolver().insert(MovieMetaData.CONTENT_URI, cv);
    	
    	cv.put(MovieMetaData.MovieTable.TITLE, "Inception");
    	cv.put(MovieMetaData.MovieTable.CONTENT, "In a world where technology exists to enter the human mind through dream invasion, a highly skilled thief is given a final chance at redemption which involves executing his toughest job to date: Inception.");
    	getContentResolver().insert(MovieMetaData.CONTENT_URI, cv);
    	
    	cv.put(MovieMetaData.MovieTable.TITLE, "The Dark Knight");
    	cv.put(MovieMetaData.MovieTable.CONTENT, "Batman, Gordon and Harvey Dent are forced to deal with the chaos unleashed by an anarchist mastermind known only as the Joker, as he drives each of them to their limits.");
    	getContentResolver().insert(MovieMetaData.CONTENT_URI, cv);
    	
    	
    }
     private void deleteData() {
        String allmovies="TITLE NOT NULL";
    	getContentResolver().delete(MovieMetaData.CONTENT_URI, allmovies, null);    	
    }
    
    
    private void queryData() {
    	Cursor c = getContentResolver().query(MovieMetaData.CONTENT_URI, new String[] {
    		MovieMetaData.MovieTable.ID,
    		MovieMetaData.MovieTable.TITLE,
    		MovieMetaData.MovieTable.CONTENT
    	}, null, null, null);
    	String out = "";
    	if(c.moveToFirst()) {
    		while(!c.isAfterLast()) {
    			out += c.getString(c.getColumnIndexOrThrow(MovieMetaData.MovieTable.TITLE));
    			out += "\n";
    			out += c.getString(c.getColumnIndexOrThrow(MovieMetaData.MovieTable.CONTENT));
    			out += "\n\n";
    			c.moveToNext();
    		}
    		txtResult.setText(out);
    	}
    	
    }
}