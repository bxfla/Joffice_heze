package com.smartbus.heze;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2019/2/14.
 */

public class DialogAddSubPrivateTopicRecyclerViewAdapter extends RecyclerView.Adapter<DialogAddSubPrivateTopicRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    private List<String> dataList;
    private OnItemClickListener mOnItemClickListener = null;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alert_dialog_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public DialogAddSubPrivateTopicRecyclerViewAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //标题需要进行一下过滤，因为标题文件当中可能含有html的标签
        holder.titleTextView.setText(dataList.get(position));
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 响应点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int)v.getTag());
        }
    }

    /**
     * 设置listener事件并初始化
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView)itemView.findViewById(R.id.tv_title);
        }
    }

    /**
     * 定义点击事件的接口
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}