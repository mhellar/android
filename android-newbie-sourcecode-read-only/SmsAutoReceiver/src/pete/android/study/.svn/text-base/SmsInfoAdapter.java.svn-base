package pete.android.study;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SmsInfoAdapter extends ArrayAdapter<SmsInfo> {
	
	
	public SmsInfoAdapter(Activity a, List<SmsInfo> list) {
		super(a, 0, list);
		
	}
	
	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		
		ViewHolder holder = null;
		if(convertView == null) {
			Activity a = (Activity)getContext();
			LayoutInflater inflater = a.getLayoutInflater();
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listitem, null);
			holder.tvNumber = (TextView)convertView.findViewById(R.id.tvNumber);
			holder.tvContent = (TextView)convertView.findViewById(R.id.tvContent);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder)convertView.getTag();
		}
		
		SmsInfo entry = getItem(pos);
		if(entry != null) {
			holder.tvNumber.setText(entry.getNumber());
			holder.tvContent.setText(entry.getContent());
		}
		
		return convertView;
	}
	
	static class ViewHolder {
		TextView tvNumber;
		TextView tvContent;
	}
}
