package com.smartbus.heze.other.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
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
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.checkup.activitydata.LineCodeActivity;
import com.smartbus.heze.checkup.bean.LineCodeData;
import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.fileapprove.activity.WorkOnePersonActivity;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.base.ProgressDialogUtil;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.other.module.LostUpContract;
import com.smartbus.heze.other.presenter.LostUpPresenter;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.smartbus.heze.http.base.Constant.TAG_ONE;
import static com.smartbus.heze.http.base.Constant.TAG_THERE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

public class LostActivity extends BaseActivity implements LostUpContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvLine)
    TextView tvLine;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.etLQPerson)
    EditText etLQPerson;
    @BindView(R.id.etLQPhone)
    EditText etLQPhone;
    @BindView(R.id.etGHFS)
    EditText etGHFS;
    @BindView(R.id.spinnerIC)
    Spinner spinnerIC;
    @BindView(R.id.spinnerType)
    Spinner spinnerType;
    @BindView(R.id.etReason)
    EditText etReason;
    @BindView(R.id.etMemo)
    EditText etMemo;
    @BindView(R.id.imageViewAdd01)
    ImageView imageViewAdd01;
    @BindView(R.id.imageViewAdd2)
    ImageView imageViewAdd2;
    @BindView(R.id.btnUp)
    Button btnUp;

    String dirPath = "temp";
    String fileName = "";
    Intent intent;
    public static File tempFile;
    LostUpPresenter lostUpPresenter;

    ArrayAdapter<String> icAdapter;
    ArrayAdapter<String> typeAdapter;
    List<String> typeList = new ArrayList<>();
    List<String> icList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker, customDatePicker1;
    private static final int MY_PERMISSIONS_MY_UP_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        typeList.add("一般事件");
        typeList.add("重大事件");
        typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeList);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(typeAdapter);

        icList.add("身份证");
        icList.add("驾驶证");
        icList.add("军官证");
        icList.add("学生证");
        icList.add("士兵证");
        icList.add("护照");
        icAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, icList);
        icAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIC.setAdapter(icAdapter);
        lostUpPresenter = new LostUpPresenter(this, this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_lost;
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
        tvEndTime.setText(now);
//        tvStartTime.setText(now.split(" ")[0]);
        customDatePicker = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvStartTime.setText(time);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker.showSpecificTime(true);
        // 不允许循环滚动
        customDatePicker.setIsLoop(false);

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvEndTime.setText(time);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(true);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);
    }

    @OnClick({R.id.tvStartTime, R.id.tvLine, R.id.tvPerson, R.id.tvEndTime, R.id.imageViewAdd01, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime:
                customDatePicker.show(tvStartTime.getText().toString());
                break;
            case R.id.tvLine:
                intent = new Intent(this, LineCodeActivity.class);
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.tvPerson:
                intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.tvEndTime:
                customDatePicker1.show(tvEndTime.getText().toString());
                break;
            case R.id.imageViewAdd01:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                                    , Manifest.permission.CAMERA
                                    , Manifest.permission.READ_EXTERNAL_STORAGE},
                            MY_PERMISSIONS_MY_UP_IMAGE);
                } else {
                    Matisse.from(LostActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.smartbus.heze.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.5f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_ONE);//
                }
                break;
            case R.id.btnUp:
                if (tvLine.getText().toString().equals("")||tvPerson.getText().toString().equals("")
                        ||etLQPerson.getText().toString().equals("")||etLQPhone.getText().toString().equals("")
                        ||etGHFS.getText().toString().equals("")){
                    Toast.makeText(this, "请填写完整数据", Toast.LENGTH_SHORT).show();
                }else {
                    String userName = new SharedPreferencesHelper(this,"login").getData(this,"userName","");
                    String startTime = tvStartTime.getText().toString();
                    String endTime = tvEndTime.getText().toString();
                    lostUpPresenter.getLostUp(userName,startTime.split(" ")[0],startTime.split(" ")[1]
                        ,tvLine.getText().toString(),tvPerson.getText().toString(),endTime.split(" ")[0]
                        ,endTime.split(" ")[1],etLQPerson.getText().toString(),etLQPhone.getText().toString()
                        ,etGHFS.getText().toString(),spinnerIC.getSelectedItem().toString()
                        ,spinnerType.getSelectedItem().toString(),etReason.getText().toString()
                        ,etMemo.getText().toString(),fileName);
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_MY_UP_IMAGE:
                if (grantResults.length == 3 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
//                    openCamera(this);
                    Matisse.from(LostActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.smartbus.heze.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.5f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_ONE);//
                } else {
                    Toast.makeText(this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                if (resultCode == RESULT_OK) {
                    List<Uri> result1 = new ArrayList<>();
                    result1 = Matisse.obtainResult(data);
                    BitmapFactory.Options opts = new BitmapFactory.Options();//获取缩略图显示到屏幕上
                    opts.inSampleSize = 2;
                    Bitmap cbitmap01 = null;
                    try {
                        cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result1.get(0));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Matrix matrix = new Matrix();
                    matrix.setScale(0.2f, 0.2f);
                    Bitmap bm = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
                            cbitmap01.getHeight(), matrix, true);
                    imageViewAdd01.setImageBitmap(bm);
                    saveImageToSD(bm, "temp");
                }
                break;
            case TAG_TWO:
                if (resultCode == TAG_ONE) {
                    LineCodeData lineCodeData = (LineCodeData) data.getSerializableExtra("lineCode");
                    tvLine.setText(lineCodeData.getLineCode());
                }
                break;
            case TAG_THERE:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvPerson.setText(data.getStringArrayListExtra("beanId").get(0));
//                        selectPersonId = data.getStringArrayListExtra("bean").get(0);
//                        depName = data.getStringExtra("department");
//                        depId = data.getStringExtra("departmentId");
//                        mnemonicCard = data.getStringExtra("mnemonicCard");
//                        ecard = data.getStringExtra("ecard");
//                        if (depName != null) {
//                            tvDepartment.setText(depName);
//                        }
                    }
                }
                break;
        }
    }

    /**
     * 图片保存到本地
     *
     * @param cbitmap01
     * @param dirPath
     */
    private void saveImageToSD(Bitmap cbitmap01, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tempFile = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tempFile.exists()) {
            tempFile.mkdir();
        }

        //新建文件存储裁剪后的图片
        File img = new File(tempFile.getAbsolutePath() + "/" + "signin" + ".png");
        try {
            //打开文件输出流
            FileOutputStream fos = new FileOutputStream(img);
            //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
            cbitmap01.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            //刷新输出流
            fos.flush();
            //关闭输出流
            fos.close();
            //返回File类型的Uri
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        upImage();
    }

    /**
     * 上传图片
     */
    private void upImage() {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "signin" + ".png");
        String filepath = "signin" + ".png";
        final AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(60000);
        final String url = ApiAddress.mainApi + ApiAddress.lostimageup;
        final RequestParams params = new RequestParams();
        try {
            params.put("upload", file);
            params.put("fullname", filepath);
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

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Toast.makeText(LostActivity.this, "文件上传成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_TWO:
                    Toast.makeText(LostActivity.this, "文件上传失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

    @Override
    public void setLostUp(UpData upData) {
        if (upData.isSuccess()) {
            Toast.makeText(this, "上传数据成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setLostUpMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}