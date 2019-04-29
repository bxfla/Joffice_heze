package com.smartbus.heze.fileapprove.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.bean.DepartmentDataBean;

import java.util.List;

/**
 * Created by Administrator on 2019/4/29.
 */

public class DepartmentAdapter extends BaseAdapter implements SectionIndexer {
    private List<DepartmentDataBean> list = null;
    private CallBackPosition callBackPosition;
    private Context mContext;

    /**
     * 自定义回调接口
     */
    public interface CallBackPosition {
        public void  myTextViewClient(DepartmentDataBean department);
    }

    public void setOnClientMyTextView(CallBackPosition callBackPosition){
        this.callBackPosition = callBackPosition;
    }

    public DepartmentAdapter(Context mContext, List<DepartmentDataBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void updateListView(List<DepartmentDataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup arg2) {
        ViewHolder viewHolder = null;
        final DepartmentDataBean mContent = list.get(position);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_contact, null);
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.tv_city_name);
            view.setTag(viewHolder);
            viewHolder.tvLetter = (TextView) view.findViewById(R.id.tv_catagory);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        int section = getSectionForPosition(position);

        if (position == getPositionForSection(section)) {
            viewHolder.tvLetter.setVisibility(View.VISIBLE);
            viewHolder.tvLetter.setText(mContent.getLetters());
        } else {
            viewHolder.tvLetter.setVisibility(View.GONE);
        }

        viewHolder.tvTitle.setText(this.list.get(position).getDepName());
        viewHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBackPosition.myTextViewClient(list.get(position));
            }
        });

        return view;

    }

    final static class ViewHolder {
        TextView tvLetter;
        TextView tvTitle;
    }

    public int getSectionForPosition(int position) {
        return list.get(position).getLetters().charAt(0);
    }

    @Override
    public Object[] getSections() {
        return null;
    }

    public int getPositionForSection(int section) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = list.get(i).getLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }
}
