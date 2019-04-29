package com.smartbus.heze.http.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.smartbus.heze.R;

import java.util.ArrayList;
import java.util.List;

import static com.smartbus.heze.R.id.cb1;

/**
 * Created by Administrator on 2019/2/1.
 */

public class AlertDialogAdapter extends BaseAdapter {
    List<String> beanList = new ArrayList<>();
    private LayoutInflater mInflater;
    private String isShow;
    public AlertDialogAdapter(Context context, List<String> nameList, String isShow) {
        beanList = nameList;
        mInflater = LayoutInflater.from(context);
        this.isShow = isShow;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.alert_item, parent, false); //加载布局
            holder = new ViewHolder();
            holder.cb = (CheckBox) convertView.findViewById(R.id.cb);
            holder.cb1 = (CheckBox) convertView.findViewById(cb1);
            convertView.setTag(holder);
        } else {
            //else里面说明，convertView已经被复用了，说明convertView中已经设置过tag了，即holder
            holder = (ViewHolder) convertView.getTag();
        }
        if (isShow.equals("true")){
            holder.cb.setVisibility(View.GONE);
            holder.cb1.setText(beanList.get(position));
        }else {
            holder.cb1.setVisibility(View.GONE);
            holder.cb.setText(beanList.get(position));
        }
        return convertView;
    }
    private class ViewHolder {
        CheckBox cb;
        CheckBox cb1;
    }
}

