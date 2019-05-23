package com.smartbus.heze.oasheet;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.R;
import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.base.ProgressDialogUtil;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.main.bean.OaWillDo;
import com.smartbus.heze.oasheet.module.UpOaDetailContract;
import com.smartbus.heze.oasheet.presenter.UpOaDetailPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.smartbus.heze.http.base.Constant.TAG_FOUR;
import static com.smartbus.heze.oasheet.OAPublishActivity.hasSdcard;
import static com.smartbus.heze.oasheet.OAPublishActivity.tempFile;

public class OaDetailActivity extends BaseActivity implements UpOaDetailContract.View{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvNo)
    TextView tvNo;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvType)
    TextView tvType;
    @BindView(R.id.tvOverDepart)
    TextView tvOverDepart;
    @BindView(R.id.tvSendDepart)
    TextView tvSendDepart;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvContent)
    TextView tvContent;
    @BindView(R.id.imageViewAdd01)
    ImageView imageViewAdd01;
    @BindView(R.id.imageViewAdd2)
    ImageView imageViewAdd2;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.spinner1)
    Spinner spinner1;
    @BindView(R.id.etLeader2)
    EditText etLeader2;
    @BindView(R.id.spinner2)
    Spinner spinner2;
    @BindView(R.id.etLeader4)
    EditText etLeader4;
    @BindView(R.id.btnUp)
    Button btnUp;

    String workId = "";
    String fileName = "";
    @BindView(R.id.imageViewAdd3)
    ImageView imageViewAdd3;
    private Uri imageUri;
    ArrayAdapter<String> CLAdapter;
    ArrayAdapter<String> SHAdapter;
    List<String> listCL = new ArrayList<String>();
    List<String> listSH = new ArrayList<String>();
    OaWillDo.ResultBean resultBean;
    UpOaDetailPresenter upOaDetailPresenter;
    private CustomDatePickerDay customDatePicker1;
    private static final int MY_PERMISSIONS_MY_UP_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        upOaDetailPresenter = new UpOaDetailPresenter(this,this);
        initDatePicker();
        Intent intent = getIntent();
        resultBean = (OaWillDo.ResultBean) intent.getSerializableExtra("bean");

        listCL.add("未处理");
        listCL.add("处理中");
        listCL.add("处理完成");
        listCL.add("驳回处理中");

        listSH.add("未审核");
        listSH.add("驳回");
        listSH.add("通过");
        listSH.add("拒绝");

        CLAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCL);
        CLAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(CLAdapter);

        SHAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSH);
        SHAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(SHAdapter);

        setData();
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvLeader.setText(now);
        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvLeader.setText(time);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(true);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);
    }

    private void setData() {
        workId = String.valueOf(resultBean.getWorkId());
        tvNo.setText(resultBean.getWorkCode());
        tvStartTime.setText(resultBean.getFqDate() + " " + resultBean.getFqsj());
        tvEndTime.setText(resultBean.getJzDate());
        tvTitle.setText(resultBean.getTitle());
        String type = resultBean.getType();
        if (type.equals("0")) {
            tvType.setText("A");
        } else if (type.equals("1")) {
            tvType.setText("B");
        } else if (type.equals("2")) {
            tvType.setText("C");
        }
        tvOverDepart.setText(resultBean.getClDep());
        tvSendDepart.setText(resultBean.getCsDep());
        tvContent.setText(resultBean.getContent());
        String imagePath = resultBean.getJlPhoto();
        if (imagePath != null) {
            Glide.with(this).load(imagePath).error(R.drawable.ic_image_erray).into(imageViewAdd01);
            imageViewAdd2.setVisibility(View.VISIBLE);
        } else {
            imageViewAdd01.setVisibility(View.GONE);
            imageViewAdd2.setVisibility(View.VISIBLE);
            imageViewAdd3.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_oa_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.imageViewAdd01, R.id.imageViewAdd2, R.id.tvLeader, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageViewAdd01:
                break;
            case R.id.imageViewAdd2:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                            MY_PERMISSIONS_MY_UP_IMAGE);
                } else {
                    openCamera(this);
                }
                break;
            case R.id.tvLeader:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.btnUp:
                if (etLeader2.getText().toString().equals("")&&etLeader4.getText().toString().equals("")){
                    Toast.makeText(this, "请填写解决结果", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etLeader2.getText().toString().equals("")&&!etLeader4.getText().toString().equals("")){
                    Toast.makeText(this, "解决完才能审核", Toast.LENGTH_SHORT).show();
                }
                String statue = spinner1.getSelectedItem().toString();
                if (statue.equals("未处理")){
                    statue = "0";
                }else if (statue.equals("处理中")){
                    statue = "1";
                }else if (statue.equals("处理完成")){
                    statue = "2";
                }else if (statue.equals("驳回处理中")){
                    statue = "3";
                }
                if (!etLeader2.getText().toString().equals("")&&etLeader4.getText().toString().equals("")){
                    upOaDetailPresenter.getUpOaDetail("1",statue,etLeader2.getText().toString(),fileName,workId);
                }else if (!etLeader2.getText().toString().equals("")&&!etLeader4.getText().toString().equals("")){
//                    upOaDetailPresenter.getUpOaDetail("2");
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_MY_UP_IMAGE:
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    openCamera(this);
                } else {
                    Toast.makeText(this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    public void openCamera(Activity activity) {
        //獲取系統版本
        int currentapiVersion = Build.VERSION.SDK_INT;
        // 激活相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            SimpleDateFormat timeStampFormat = new SimpleDateFormat(
                    "yyyy_MM_dd_HH_mm_ss");
            String filename = timeStampFormat.format(new Date());
            tempFile = new File(Environment.getExternalStorageDirectory(),
                    filename + ".jpg");
            if (currentapiVersion < 24) {
                // 从文件中创建uri
                imageUri = Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            } else {
                //兼容android7.0 使用共享文件的形式
                ContentValues contentValues = new ContentValues(1);
                contentValues.put(MediaStore.Images.Media.DATA, tempFile.getAbsolutePath());
                //检查是否有存储权限，以免崩溃
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    Toast.makeText(this, "请开启存储权限", Toast.LENGTH_SHORT).show();
                    return;
                }
                imageUri = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            }
        }
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CAREMA
        activity.startActivityForResult(intent, TAG_FOUR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_FOUR:
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeStream(getContentResolver()
                            .openInputStream(imageUri));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                imageViewAdd01.setImageBitmap(bitmap);
                upImage();
                break;
        }
    }

    /**
     * 上传图片
     */
    private void upImage() {
        final AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(60000);
        final String url = ApiAddress.mainApi + ApiAddress.upimageold;
        final RequestParams params = new RequestParams();
        try {
            params.put("upload", tempFile);
            params.put("fullname", tempFile.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ProgressDialogUtil.startLoad(this, MainUtil.upData);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int arg0, String arg1) {
                super.onSuccess(arg0, arg1);
                Log.i("XXX", arg1);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(arg1.toString());
                    fileName = jsonObject.getString("msg");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                super.onFailure(statusCode, headers, responseBody, error);
                Log.i("XXX", "XXXXX");
                Message message = new Message();
                message.what = Constant.TAG_TWO;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 解决提交
     * @param s
     */
    @Override
    public void setUpOaDetail(UpData s) {
        if (s.isSuccess()){
            Toast.makeText(this, "提交数据成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setUpOaDetailMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Toast.makeText(OaDetailActivity.this, "文件上传成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_TWO:
                    Toast.makeText(OaDetailActivity.this, "文件上传失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

}
