package com.smartbus.heze.checkup.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.smartbus.heze.R;
import com.smartbus.heze.checkup.bean.SafeHistoryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class SafeAdapter extends RecyclerView.Adapter<SafeAdapter.ViewHolder> {
    Context context;
    List<SafeHistoryItem.ResultBean> beanList = new ArrayList<>();
    public GetItemPosition getItemPosition;

    public interface GetItemPosition {
        void getPosition(int position, String money, String tag);
    }

    public void setOnInnerItemOnClickListener(GetItemPosition getItemPosition) {
        this.getItemPosition = getItemPosition;
    }

    public SafeAdapter(Context context, List<SafeHistoryItem.ResultBean> anquanList) {
        this.context = context;
        beanList = anquanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_chlid_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textView.setText(beanList.get(position).getProjectName());
        holder.tvName.setText("分数");
        holder.editText.setText(beanList.get(position).getScore());
        holder.position = position;
        holder.rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItemPosition.getPosition(position, holder.editText.getText().toString(), "rb2");
            }
        });
        holder.rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItemPosition.getPosition(position, "0", "rb1");
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView,tvName;
        public EditText editText;
        public RadioButton rb1, rb2;
        int position;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            editText = (EditText) itemView.findViewById(R.id.editText);
            rb1 = (RadioButton) itemView.findViewById(R.id.rb1);
            rb2 = (RadioButton) itemView.findViewById(R.id.rb2);
        }
    }
}
