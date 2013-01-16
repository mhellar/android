package com.example.movies;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleCursorAdapter;


public class Movies extends ListActivity
{
    /** Called when the activity is first created. */
    public static final int INSERT_ID = Menu.FIRST;
    
    private int mMovieNumber = 1;
	private MoviesDbAdapter mDbHelper;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_list);
        mDbHelper = new MoviesDbAdapter(this);
        mDbHelper.open();
        fillData();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	boolean result = super.onCreateOptionsMenu(menu);
        menu.add(0, INSERT_ID, 0, R.string.menu_insert);
        return result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
        case INSERT_ID:
            createMovie();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void createMovie() {
        String noteName = "Movie " + mMovieNumber++;
        mDbHelper.createMovie(noteName, "");
        fillData();
    }
    
    private void fillData() {
        // Get all of the notes from the database and create the item list
        Cursor c = mDbHelper.fetchAllMovies();
        startManagingCursor(c);

        String[] from = new String[] { MoviesDbAdapter.KEY_TITLE };
        int[] to = new int[] { R.id.text1 };
        
        // Now create an array adapter and set it to display using our row
        SimpleCursorAdapter movies =
            new SimpleCursorAdapter(this, R.layout.movies_row, c, from, to);
        setListAdapter(movies);
    }
    
}
