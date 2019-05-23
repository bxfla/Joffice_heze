package com.smartbus.heze.oasheet;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.R;
import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.fileapprove.activity.DepartmentActivity;
import com.smartbus.heze.fileapprove.activity.DepartmentMoreActivity;
import com.smartbus.heze.fileapprove.activity.WorkPersonActivity;
import com.smartbus.heze.fileapprove.bean.DepartmentDataBean;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.base.ProgressDialogUtil;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.oasheet.bean.OANO;
import com.smartbus.heze.oasheet.module.NoContract;
import com.smartbus.heze.oasheet.module.UpOaContract;
import com.smartbus.heze.oasheet.presenter.NoPresenter;
import com.smartbus.heze.oasheet.presenter.UpOaPresenter;

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
import static com.smartbus.heze.http.base.Constant.TAG_ONE;
import static com.smartbus.heze.http.base.Constant.TAG_THERE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

public class OAPublishActivity extends BaseActivity implements NoContract.View,UpOaContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvNo)
    TextView tvNo;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvOverDepart)
    TextView tvOverDepart;
    @BindView(R.id.tvSendDepart)
    TextView tvSendDepart;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.spinnertitle)
    Spinner spinnertitle;
    @BindView(R.id.spinnertype)
    Spinner spinnertype;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.etLeader1)
    EditText etLeader1;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.etLeader2)
    EditText etLeader2;
    @BindView(R.id.tvLeader3)
    TextView tvLeader3;
    @BindView(R.id.etLeader3)
    EditText etLeader3;
    @BindView(R.id.tvLeader4)
    TextView tvLeader4;
    @BindView(R.id.etLeader4)
    EditText etLeader4;
    @BindView(R.id.imageViewAdd01)
    ImageView imageViewAdd01;
    @BindView(R.id.imageViewAdd2)
    ImageView imageViewAdd2;
    @BindView(R.id.btnUp)
    Button btnUp;

    Intent intent;
    String fileName = "";
    private Uri imageUri;
    public static File tempFile;
    NoPresenter noPresenter;
    UpOaPresenter upOapresenter;
    String overDepId = "", overDepName = "";
    String sendDepId = "",sendDepName = "";
    String sendPerson = "";
    ArrayAdapter<String> titleAdapter;
    ArrayAdapter<String> typeAdapter;
    List<String> listTitle = new ArrayList<String>();
    List<String> listType = new ArrayList<String>();
    private static final int MY_PERMISSIONS_MY_UP_IMAGE = 1;
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        listTitle.add("日常工作");
        listTitle.add("现场工作");
        listTitle.add("重点工作");
        listTitle.add("环境监察");
        listTitle.add("其他");

        listType.add("A");
        listType.add("B");
        listType.add("C");

        titleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTitle);
        titleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertitle.setAdapter(titleAdapter);

        typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listType);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertype.setAdapter(typeAdapter);
        noPresenter = new NoPresenter(this, this);
        upOapresenter = new UpOaPresenter(this,this);
        noPresenter.getNo("gongzuochuandidanbia");
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_oapublish;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvStartTime.setText(now);
        tvEndTime.setText(now.split(" ")[0]);
        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvStartTime.setText(time);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(true);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);
        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvEndTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker2.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker2.setIsLoop(false);
    }

    @OnClick({R.id.tvStartTime, R.id.tvEndTime, R.id.tvOverDepart, R.id.tvSendDepart, R.id.tvPerson
            , R.id.btnUp,R.id.imageViewAdd01, R.id.imageViewAdd2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
            case R.id.tvOverDepart:
                intent = new Intent(this, DepartmentActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.tvSendDepart:
                intent = new Intent(this, DepartmentMoreActivity.class);
                startActivityForResult(intent, TAG_TWO);
                break;
            case R.id.tvPerson:
                intent = new Intent(this, WorkPersonActivity.class);
                startActivityForResult(intent, TAG_THERE);
                break;
            case R.id.btnUp:
                if (tvOverDepart.getText().toString().equals("")) {
                    Toast.makeText(this, "解决部门不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etContent.getText().toString().equals("")) {
                    Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                String no = tvNo.getText().toString();
                String upDate = tvStartTime.getText().toString().split(" ")[0];
                String upTime = tvStartTime.getText().toString().split(" ")[1];
                String endTime = tvEndTime.getText().toString();
                String title = spinnertitle.getSelectedItem().toString();
                String type = spinnertype.getSelectedItem().toString();
                String content = etContent.getText().toString();
                String flag = "0";
//                try {
                    upOapresenter.getUpOa(flag,no, overDepName ,overDepId,sendDepName,sendDepId,sendPerson
                            ,upDate,upTime,endTime,title,type,content,fileName);
//                    upOapresenter.getUpOa(flag,no, URLDecoder.decode(overDepName, "UTF-8") ,overDepId
//                            ,URLDecoder.decode(sendDepName, "UTF-8"),sendDepId,URLDecoder.decode(sendPerson, "UTF-8")
//                            ,upDate,upTime,endTime,URLDecoder.decode(title, "UTF-8"),URLDecoder.decode(type, "UTF-8")
//                            ,URLDecoder.decode(content, "UTF-8"),URLDecoder.decode(fileName, "UTF-8"));
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
                break;
            case R.id.imageViewAdd01:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                            MY_PERMISSIONS_MY_UP_IMAGE);
                }  else {
                    openCamera(this);
                }
                break;
            case R.id.imageViewAdd2:
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
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
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
                    Toast.makeText(this,"请开启存储权限",Toast.LENGTH_SHORT).show();
                    return;
                }
                imageUri = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            }
        }
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CAREMA
        activity.startActivityForResult(intent, TAG_FOUR);
    }

    /**
* 判断sdcard是否被挂载
*/
    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        DepartmentDataBean departmentDataBean = (DepartmentDataBean) data.getSerializableExtra("department");
                        overDepId = departmentDataBean.getDepId();
                        overDepName = departmentDataBean.getDepName();
                        tvOverDepart.setText(overDepName);
                    }
                }
                break;
            case TAG_TWO:
                if (data != null) {
                    List<String> selectName = data.getStringArrayListExtra("bean");
                    List<String> selectId = data.getStringArrayListExtra("beanId");
                    sendDepName = selectName.toString();
                    sendDepName = sendDepName.toString().replace("[","");
                    sendDepName = sendDepName.toString().replace("]","");
                    sendDepId = selectId.toString();
                    sendDepId = sendDepId.toString().replace("[","");
                    sendDepId = sendDepId.toString().replace("]","");
                    tvSendDepart.setText(sendDepName);
                }
                break;
            case TAG_THERE:
                if (data != null) {
                    List<String> selectPersonList = data.getStringArrayListExtra("bean");
                    sendPerson = selectPersonList.toString();
                    sendPerson = sendPerson.toString().replace("[","");
                    sendPerson = sendPerson.toString().replace("]","");
                    tvPerson.setText(sendPerson);
                }
                break;
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
        final String url = ApiAddress.mainApi + ApiAddress.upimagebef;
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

    @Override
    public void setNo(OANO s) {
        if (s.isSuccess()) {
            tvNo.setText(s.getNumber());
        }
    }

    @Override
    public void setNoMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * oa数据提交
     * @param s
     */
    @Override
    public void setUpOa(UpData s) {
        if (s.isSuccess()){
            Toast.makeText(this, "上传数据成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    @Override
    public void setUpOaMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Toast.makeText(OAPublishActivity.this, "文件上传成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_TWO:
                    Toast.makeText(OAPublishActivity.this, "文件上传失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

}
