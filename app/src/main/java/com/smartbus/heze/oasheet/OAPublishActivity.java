package com.smartbus.heze.oasheet;

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
import java.text.ParseException;
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

public class OAPublishActivity extends BaseActivity implements NoContract.View, UpOaContract.View {

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
    String dirPath = "temp";
    public static File tempFile;
    NoPresenter noPresenter;
    UpOaPresenter upOapresenter;
    String overDepId = "", overDepName = "";
    String sendDepId = "", sendDepName = "";
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
        upOapresenter = new UpOaPresenter(this, this);
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
                String startTime = tvStartTime.getText().toString();
                boolean type = isDate2Bigger(startTime.split(" ")[0], time.split(" ")[0]);
                // 回调接口，获得选中的时间
                if (type) {
                    tvEndTime.setText(time.split(" ")[0]);
                } else {
                    Toast.makeText(OAPublishActivity.this, "请输入正确时间", Toast.LENGTH_SHORT).show();
                }
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker2.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker2.setIsLoop(false);
    }

    @OnClick({R.id.tvStartTime, R.id.tvEndTime, R.id.tvOverDepart, R.id.tvSendDepart, R.id.tvPerson
            , R.id.btnUp, R.id.imageViewAdd01, R.id.imageViewAdd2})
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
                if (type.equals("A")) {
                    type = "0";
                } else if (type.equals("B")) {
                    type = "1";
                } else if (type.equals("C")) {
                    type = "2";
                }
                String content = etContent.getText().toString();
                String flag = "0";
                upOapresenter.getUpOa(flag, no, overDepName, overDepId, sendDepName, sendDepId, sendPerson
                        , upDate, upTime, endTime, title, type, content, fileName);
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
                    Matisse.from(OAPublishActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.smartbus.heze.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.5f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_FOUR);//
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
                if (grantResults.length == 3 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
//                    openCamera(this);
                    Matisse.from(OAPublishActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.smartbus.heze.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.5f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_FOUR);//
                } else {
                    Toast.makeText(this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                return;
        }
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
                    sendDepName = sendDepName.toString().replace("[", "");
                    sendDepName = sendDepName.toString().replace("]", "");
                    sendDepId = selectId.toString();
                    sendDepId = sendDepId.toString().replace("[", "");
                    sendDepId = sendDepId.toString().replace("]", "");
                    tvSendDepart.setText(sendDepName);
                }
                break;
            case TAG_THERE:
                if (data != null) {
                    List<String> selectPersonList = data.getStringArrayListExtra("bean");
                    sendPerson = selectPersonList.toString();
                    sendPerson = sendPerson.toString().replace("[", "");
                    sendPerson = sendPerson.toString().replace("]", "");
                    tvPerson.setText(sendPerson);
                }
                break;
            case TAG_FOUR:
//                Bitmap bitmap = null;
//                try {
//                    bitmap = BitmapFactory.decodeStream(getContentResolver()
//                            .openInputStream(imageUri));
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//                imageViewAdd2.setImageBitmap(bitmap);
//                upImage();
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
        final String url = ApiAddress.mainApi + ApiAddress.upimagebef;
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

    /**
     * 比较两个日期的大小，日期格式为yyyy-MM-dd
     *
     * @param str1 the first date
     * @param str2 the second date
     * @return true <br/>false
     */
    public static boolean isDate2Bigger(String str1, String str2) {
        boolean isBigger = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = null;
        Date dt2 = null;
        try {
            dt1 = sdf.parse(str1);
            dt2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dt1.getTime() > dt2.getTime()) {
            isBigger = false;
        } else if (dt1.getTime() <= dt2.getTime()) {
            isBigger = true;
        }
        return isBigger;
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
     *
     * @param s
     */
    @Override
    public void setUpOa(UpData s) {
        if (s.isSuccess()) {
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