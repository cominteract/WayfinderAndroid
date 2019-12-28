package com.wayfinder.wayfinder;




import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class BoothAdapter extends ArrayAdapter<BoothClass>{

    Context context;
    int layoutResourceId;   
    BoothClass data[] = null;
   
    public BoothAdapter(Context context, int layoutResourceId, BoothClass[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        BoothHolder holder = null;
       
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
           
            holder = new  BoothHolder();
            
            holder.txtCName = (TextView)row.findViewById(R.id.txtCName);
            row.setTag(holder);
        }
        else
        {
            holder = (BoothHolder)row.getTag();
        }
       
        BoothClass fb = data[position];
        holder.txtCName.setText(fb.cname);
        
       
        return row;
    }
   
    static class BoothHolder
    {
        public TextView txtDesc;
        TextView txtCName;
    }
}
