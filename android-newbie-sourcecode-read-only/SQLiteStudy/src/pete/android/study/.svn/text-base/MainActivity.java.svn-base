package pete.android.study;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
	// TAG for LogCat
    public static final String TAG = "SQLiteDebug";
    // list view control
	private ListView mListUserInfo;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        
        // load list view control
        mListUserInfo = (ListView)findViewById(R.id.listUsers);
        
        // create data creator
        UserInfoCreator creator = new UserInfoCreator(this);
        // open connection
        creator.open();
        // insert data
        creator.insert();
        // add data to list view through adapter
        mListUserInfo.setAdapter(new UserInfoAdapter(this, creator.queryAll()));        
        // close connection
        creator.close();
        
    }
    

}