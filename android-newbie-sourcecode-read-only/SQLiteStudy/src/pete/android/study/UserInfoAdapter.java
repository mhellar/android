package pete.android.study;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class UserInfoAdapter extends BaseAdapter {
	
	// private objects
	private List<UserInfo> mListUserInfo;
	private LayoutInflater mInflater;
	
	/*
	 * constructor
	 */
	public UserInfoAdapter(Context c, List<UserInfo> list) {	
		mListUserInfo = list;		
		// create layout inflater
		mInflater = LayoutInflater.from(c);
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return mListUserInfo.size();
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		return mListUserInfo.get(position);
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// get view reference
		View view = convertView;
		// if null 
		if(view == null) {
			// inflate new layout
			view = mInflater.inflate(R.layout.layout_list_item, null);
			// create a holder
			ViewHolder holder = new ViewHolder();
			// find controls
			holder.txtName = (TextView)view.findViewById(R.id.txtName);
			holder.txtAge = (TextView)view.findViewById(R.id.txtAge);
			holder.txtCity = (TextView)view.findViewById(R.id.txtCity);
			// set data structure to view
			view.setTag(holder);
		}
		
		// get selected user info
		UserInfo userInfo = mListUserInfo.get(position);
		// if not null
		if(userInfo != null) {
			// query data structure
			ViewHolder holder = (ViewHolder)view.getTag();
			// set data to display
			holder.txtName.setText(userInfo.getName());
			holder.txtAge.setText("(" + String.valueOf(userInfo.getAge()) + ")");
			holder.txtCity.setText(userInfo.getCity());
		}		
		
		// return view
		return view;
	}

	/*
	 * @class ViewHolder
	 * to hold data structure on view with user info
	 */
	static class ViewHolder {
		private TextView txtName;
		private TextView txtAge;
		private TextView txtCity;
	}
}
