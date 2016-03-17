package com.example.handsomemark.simpletalk;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

/**
 * Created by handsomemark on 2016/3/17.
 */
public class MessageAdapter extends ArrayAdapter<Message> {

    private int resouceID;

    public MessageAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);
        this.resouceID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);
        ViewHolder viewHolder;
        if (convertView != null){
            viewHolder = (ViewHolder)convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(resouceID,null);
            viewHolder = new ViewHolder();
            viewHolder.rightLayout = (LinearLayout) convertView.findViewById(R.id.right_layout);
            viewHolder.rightText = (TextView) convertView.findViewById(R.id.right_message);
            viewHolder.leftLayout = (LinearLayout) convertView.findViewById(R.id.left_layout);
            viewHolder.leftText = (TextView) convertView.findViewById(R.id.left_message);
            convertView.setTag(viewHolder);
        }
        if (message.getType()==Message.TYPE_SENT) {
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightText.setText(message.getMessage());
        } else if(message.getType()==Message.TYPE_RECEIVED){
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.leftText.setText(message.getMessage());
        }
//        Log.d("View","left:"+((TextView) convertView.findViewById(R.id.left_message)).getText().toString());
//        Log.d("VIew","right:"+((TextView) convertView.findViewById(R.id.right_message)).getText().toString());
        return convertView;
    }

    private class ViewHolder{
        LinearLayout rightLayout;
        LinearLayout leftLayout;
        TextView rightText;
        TextView leftText;
    }
}
