package pete.android.study;

public class UserInfo {
	// fields
	private int mId;
	private String mName;
	private int mAge;
	private String mCity;
	
	/*
	 * constructor
	 */
	public UserInfo(int id, String name, int age, String city) {
		mId = id;
		mName = name;
		mAge = age;
		mCity = city;		 
	}
	
	/*
	 * set user id
	 */
	public void setID(int id) {
		mId = id;
	}
	
	/*
	 * get user id
	 */
	public int getID() {
		return mId;
	}
	
	/*
	 * set user name
	 */
	public void setName(String name) {
		mName = name;
	}
	
	/*
	 * get user name
	 */
	public String getName() {
		return mName;
	}
	
	/*
	 * set user age
	 */
	public void setAge(int age) {
		mAge = age;
	}
	
	/*
	 * get user age
	 */
	public int getAge() {
		return mAge;
	}
	
	/*
	 * set user city
	 */
	public void setCity(String city) {
		mCity = city;
	}
	
	/*
	 * get user city
	 */
	public String getCity() {
		return mCity;
	}
}
