package pete.android.study;

import android.os.Parcel;
import android.os.Parcelable;

public class SmsInfo implements Parcelable {
	private String mNumber;
	private String mContent;
	
	public SmsInfo(String number, String content) {
		mNumber = number;
		mContent = content;
	}
	
	public SmsInfo(Parcel in) {
		String data[] = new String[2];
		in.readStringArray(data);
		mNumber = data[0];
		mContent = data[1];
	}
	
	public void setNumber(String number) {
		mNumber = number;
	}
	public String getNumber() {
		return mNumber;
	}
	
	public void setContent(String content) {
		mContent = content;
	}
	public String getContent() {
		return mContent;
	}

	@Override
	public int describeContents() {		
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringArray(new String[] {
			mNumber, mContent	
		});
		
	}
	
	public static final Parcelable.Creator<SmsInfo> CREATOR = new Parcelable.Creator<SmsInfo> () {

		@Override
		public SmsInfo createFromParcel(Parcel source) {
			
			return new SmsInfo(source);
		}

		@Override
		public SmsInfo[] newArray(int size) {
			
			return new SmsInfo[size];
		}
		
	};
}
