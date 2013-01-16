package pete.android.study;

import java.util.List;

import android.content.Context;

public class UserInfoCreator {
	// db adapter
	private UserDbAdapter mDbAdapter;
	
	/*
	 * constructor
	 */
	public UserInfoCreator(Context c) {
		mDbAdapter = new UserDbAdapter(c);
	}
	
	/*
	 * open DBAdapter connection
	 */
	public void open() {
		mDbAdapter.open();
	}
	
	/*
	 * insert random data
	 */
	public void insert() {
    	mDbAdapter.insertUser("Pete Houston", 29, "Seoul, South Korea");
    	mDbAdapter.insertUser("Kelly Hooker", 22, "London, England");
    	mDbAdapter.insertUser("Jung Ha Lee", 25, "Pusan, South Korea");
    	mDbAdapter.insertUser("Elly Nguyen", 20, "Hanoi, Vietnam");
    	mDbAdapter.insertUser("Hana Kaemi", 26, "Kyoto, Japan");
    	mDbAdapter.insertUser("Jenya Kavroski", 19, "Leningrad, Russia");
	}
	
	/*
	 * query all user info from db
	 */
	public List<UserInfo> queryAll() {
		return mDbAdapter.fetchAllUsers();
	}
	
	/*
	 * close connection
	 */
	public void close() {
		mDbAdapter.close();
	}
}
