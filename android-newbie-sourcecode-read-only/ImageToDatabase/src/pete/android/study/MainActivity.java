package pete.android.study;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
    
	private ImageView mMain;
	private ImageDbAdapter mDbAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mMain = (ImageView) findViewById(R.id.ivMain);
        insertToDB();
        queryFromDB();
    }
    
    private void insertToDB() {
    	mDbAdapter = new ImageDbAdapter(this);
    	mDbAdapter.open();
    	
    	byte[] image = Utilities.getBytes(BitmapFactory.decodeResource(getResources(), R.drawable.sumire02));
    	
    	mDbAdapter.insert(image);    	
    }
    
    private void queryFromDB() {
    	byte[] image = mDbAdapter.fetchSingle(1);
    	mMain.setImageBitmap(Utilities.getImage(image));
    	mDbAdapter.close();
    }
}