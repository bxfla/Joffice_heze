package com.smartbus.heze.exam.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.exam.activity.OnLineActivity;
import com.smartbus.heze.exam.bean.ExaminationData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.smartbus.heze.R.id.rbA;
import static com.smartbus.heze.R.id.rbB;
import static com.smartbus.heze.R.id.rbC;
import static com.smartbus.heze.R.id.rbD;

/**
 * Created by dell on 2017/12/6.
 */

public class OnLineAdapter extends PagerAdapter {
    public GetItemPosition getItemPosition;
    OnLineActivity mContext;
    List<View> viewItems;
    View convertView;
    List<ExaminationData.DataBean> dataItems;
    List<ExaminationData.DataBean> upList;
    HashMap<String,ExaminationData.DataBean> hasMap = new HashMap<>();
    List<String> beanList = new ArrayList<>();
    String answer;

    public interface GetItemPosition {
        void getPosition(List<ExaminationData.DataBean> upList);
    }

    public void setOnInnerItemOnClickListener(GetItemPosition getItemPosition) {
        this.getItemPosition = getItemPosition;
    }

    public OnLineAdapter(OnLineActivity context, List<View> viewItems, List<ExaminationData.DataBean> beanList) {
        mContext = context;
        this.viewItems = viewItems;
        this.dataItems = beanList;
        this.upList = beanList;
    }

    //初始化
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final ViewHolder holder = new ViewHolder();
        convertView = viewItems.get(position);
        holder.tvNo = (TextView) convertView.findViewById(R.id.tvNo);
        holder.tvQuestion = (TextView) convertView.findViewById(R.id.tvQuestion);
        holder.tvNext = (TextView) convertView.findViewById(R.id.tvNext);
        holder.imNext = (ImageView) convertView.findViewById(R.id.imNext);
        holder.tvNum = (TextView) convertView.findViewById(R.id.tvNum);

        holder.rbA = (RadioButton) convertView.findViewById(rbA);
        holder.rbB = (RadioButton) convertView.findViewById(rbB);
        holder.rbC = (RadioButton) convertView.findViewById(rbC);
        holder.rbD = (RadioButton) convertView.findViewById(rbD);
        holder.rbE = (RadioButton) convertView.findViewById(R.id.rbE);
        holder.rbF = (RadioButton) convertView.findViewById(R.id.rbF);
        holder.rg = (RadioGroup) convertView.findViewById(R.id.rg);

        holder.cbA = (CheckBox) convertView.findViewById(R.id.cbA);
        holder.cbB = (CheckBox) convertView.findViewById(R.id.cbB);
        holder.cbC = (CheckBox) convertView.findViewById(R.id.cbC);
        holder.cbD = (CheckBox) convertView.findViewById(R.id.cbD);
        holder.cbE = (CheckBox) convertView.findViewById(R.id.cbE);
        holder.cbF = (CheckBox) convertView.findViewById(R.id.cbF);
        holder.llType = (LinearLayout) convertView.findViewById(R.id.llType);
        holder.llUp = (LinearLayout) convertView.findViewById(R.id.llUp);
        holder.llNext = (LinearLayout) convertView.findViewById(R.id.llNext);

        container.addView(viewItems.get(position));
        setData(holder, position);
        return viewItems.get(position);
    }

    //ABCD赋值
    private void setData(ViewHolder holder, int position) {
        //单选
        if (dataItems.get(position).getTypeName().equals("单选题")) {
            if (dataItems.get(position).getContent2().equals("C:")) {
                holder.rbC.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getContent3().equals("D:")) {
                holder.rbD.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getContent4().equals("E:")) {
                holder.rbE.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getContent5().equals("F:")) {
                holder.rbF.setVisibility(View.GONE);
            }
        }
        //多选
        if (dataItems.get(position).getTypeName().equals("多选题")) {
            holder.rg.setVisibility(View.GONE);
            holder.llType.setVisibility(View.VISIBLE);
            if (dataItems.get(position).getContent2().equals("C:")) {
                holder.cbC.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getContent3().equals("D:")) {
                holder.cbD.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getContent4().equals("E:")) {
                holder.cbE.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getContent5().equals("F:")) {
                holder.cbF.setVisibility(View.GONE);
            }
        }
        //判断
        if (dataItems.get(position).getTypeName().equals("判断题")) {
            holder.rbC.setVisibility(View.GONE);
            holder.rbD.setVisibility(View.GONE);
            holder.rbE.setVisibility(View.GONE);
            holder.rbF.setVisibility(View.GONE);
        }

        holder.rbA.setText(dataItems.get(position).getContent0());
        holder.rbB.setText(dataItems.get(position).getContent1());
        holder.rbC.setText(dataItems.get(position).getContent2());
        holder.rbD.setText(dataItems.get(position).getContent3());
        holder.rbE.setText(dataItems.get(position).getContent4());
        holder.rbF.setText(dataItems.get(position).getContent5());

        holder.cbA.setText(dataItems.get(position).getContent0());
        holder.cbB.setText(dataItems.get(position).getContent1());
        holder.cbC.setText(dataItems.get(position).getContent2());
        holder.cbD.setText(dataItems.get(position).getContent3());
        holder.cbE.setText(dataItems.get(position).getContent4());
        holder.cbF.setText(dataItems.get(position).getContent5());
        holder.tvNo.setText(String.valueOf(position+1));
        holder.tvQuestion.setText(dataItems.get(position).getTitle().toString());
        holder.tvNum.setText((position + 1) + "/" + dataItems.size());
//        holder.question.setText(dataItems.get(position).getQuContent());
        // 最后一页修改"下一步"按钮文字
        if (position == viewItems.size() - 1) {
            holder.tvNext.setText("提交");
            holder.imNext.setImageResource(R.drawable.vote_submit_finish);
        }
        //上一题  下一题
        holder.llUp.setOnClickListener(new LinearOnClickListenerup(position - 1, false, position, holder));
        holder.llNext.setOnClickListener(new LinearOnClickListenernext(position + 1, true, position, holder));
    }

    /**
     * @author 设置下一步按钮监听
     */
    class LinearOnClickListenernext implements View.OnClickListener {

        private int mPosition;
        private int mPosition1;
        private boolean mIsNext;
        private ViewHolder viewHolder;

        public LinearOnClickListenernext(int position, boolean mIsNext, int position1, ViewHolder viewHolder) {
            mPosition = position;
            mPosition1 = position1;
            this.viewHolder = viewHolder;
            this.mIsNext = mIsNext;
        }

        @Override
        public void onClick(View v) {
            answer = null;
            if (mPosition == -1) {
                Toast.makeText(mContext, "已经是第一题", Toast.LENGTH_SHORT).show();
            } else if (mPosition == viewItems.size()) {
                addAnswerToList(viewHolder, mPosition1, mPosition);
//                upData();
            } else {
                addAnswerToList(viewHolder, mPosition1, mPosition);
            }
        }
    }

    //启动得分activity
    public void upData() {
        for (int i = 0;i<upList.size();i++){
            Log.e("XXX",upList.get(i).getData());
        }
        getItemPosition.getPosition(upList);
//        String answer = beanList.toString();
//        Intent intent = new Intent(mContext, OnLineResultActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putInt("score", code);
//        bundle.putInt("passnum", beanRule.erPassMark);
//        intent.putExtras(bundle);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        MyApplication.getContextObject().startActivity(intent);
//        mContext.finish();
//        mContext.finish();
    }

    //保存答案到list
    private void addAnswerToList(ViewHolder viewHolder, int mPosition1, int mPosition) {
        if (beanList.size() < mPosition) {
            //单选
            if (viewHolder.rbA.isChecked()) {
                answer = "A";
            } else if (viewHolder.rbB.isChecked()) {
                answer = "B";
            } else if (viewHolder.rbC.isChecked()) {
                answer = "C";
            } else if (viewHolder.rbD.isChecked()) {
                answer = "D";
            } else if (viewHolder.rbE.isChecked()) {
                answer = "E";
            } else if (viewHolder.rbF.isChecked()) {
                answer = "F";
            }

            //多选
            if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ABCDEF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ABCDE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ABCDF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ACDEF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BCDEF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "ABCD";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ABCE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ABCF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ACDE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ACDF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ADEF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "BCDE";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BCDF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BDEF";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "CDEF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked()) {
                answer = "ABC";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "ABD";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ABE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ABF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "ACD";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ACE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ACF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ADE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ADF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "AEF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "BCD";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "BCE";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BCF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "BDE";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BDF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BEF";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "CDE";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "CDF";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "CEF";
            } else if (viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "DEF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked()) {
                answer = "AB";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked()) {
                answer = "AC";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "AD";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "AE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "AF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked()) {
                answer = "BC";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "BD";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "BE";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BF";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "CD";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "CE";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "CF";
            } else if (viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "DE";
            } else if (viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "DF";
            } else if (viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "EF";
            } else if (viewHolder.cbA.isChecked()) {
                answer = "A";
            } else if (viewHolder.cbB.isChecked()) {
                answer = "B";
            } else if (viewHolder.cbC.isChecked()) {
                answer = "C";
            } else if (viewHolder.cbD.isChecked()) {
                answer = "D";
            } else if (viewHolder.cbE.isChecked()) {
                answer = "E";
            } else if (viewHolder.cbF.isChecked()) {
                answer = "F";
            }
            if (answer != null) {
                if (!answer.equals(dataItems.get(mPosition1).getAnswer())) {
                    ExaminationData.DataBean bean = dataItems.get(mPosition1);
                    bean.setId(dataItems.get(mPosition1).getId());
                    bean.setTitle(dataItems.get(mPosition1).getTitle());
                    bean.setContent0(dataItems.get(mPosition1).getContent0());
                    bean.setContent1(dataItems.get(mPosition1).getContent1());
                    bean.setContent2(dataItems.get(mPosition1).getContent2());
                    bean.setContent3(dataItems.get(mPosition1).getContent3());
                    bean.setContent4(dataItems.get(mPosition1).getContent4());
                    bean.setContent5(dataItems.get(mPosition1).getContent5());
                    bean.setQuestionId(dataItems.get(mPosition1).getQuestionId());
                    bean.setTypeName(dataItems.get(mPosition1).getTypeName());
                    bean.setAnswer(dataItems.get(mPosition1).getAnswer());
                    bean.setData(answer);
                    bean.setScore("0");
                    bean.setOldScore(dataItems.get(mPosition1).getScore());
                    upList.set(mPosition1,bean);
                } else {
                    ExaminationData.DataBean bean = dataItems.get(mPosition1);
                    bean.setId(dataItems.get(mPosition1).getId());
                    bean.setTitle(dataItems.get(mPosition1).getTitle());
                    bean.setContent0(dataItems.get(mPosition1).getContent0());
                    bean.setContent1(dataItems.get(mPosition1).getContent1());
                    bean.setContent2(dataItems.get(mPosition1).getContent2());
                    bean.setContent3(dataItems.get(mPosition1).getContent3());
                    bean.setContent4(dataItems.get(mPosition1).getContent4());
                    bean.setContent5(dataItems.get(mPosition1).getContent5());
                    bean.setQuestionId(dataItems.get(mPosition1).getQuestionId());
                    bean.setTypeName(dataItems.get(mPosition1).getTypeName());
                    bean.setAnswer(dataItems.get(mPosition1).getAnswer());
                    bean.setData(answer);
                    bean.setScore(dataItems.get(mPosition1).getScore());
                    bean.setOldScore(dataItems.get(mPosition1).getScore());
                    upList.set(mPosition1,bean);
                }
                mContext.setCurrentView(mPosition);
            } else {
                Toast.makeText(mContext, "请先选择选项", Toast.LENGTH_SHORT).show();
            }
        } else {
            mContext.setCurrentView(mPosition);
        }
    }


    /**
     * @author 设置上一步按钮监听
     */
    public class LinearOnClickListenerup implements View.OnClickListener {

        private int mPosition;
        public LinearOnClickListenerup(int position, boolean mIsNext, int position1, ViewHolder viewHolder) {
            mPosition = position;
        }

        @Override
        public void onClick(View v) {
            if (mPosition == -1) {
                Toast.makeText(mContext, "已经是第一题", Toast.LENGTH_SHORT).show();
            } else if (mPosition > dataItems.size()) {
                //待定
            } else {
                mContext.setCurrentView(mPosition);
            }
        }

    }

    @Override
    public int getCount() {
        if (viewItems == null)
            return 0;
        return viewItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewItems.get(position));
    }

    public class ViewHolder {
        TextView tvNo, tvQuestion, tvNum, tvNext;
        ImageView imNext;
        LinearLayout llUp, llNext, llType;
        RadioButton rbA, rbB, rbC, rbD, rbE, rbF;
        CheckBox cbA, cbB, cbC, cbD, cbE, cbF;
        RadioGroup rg;
    }
}
