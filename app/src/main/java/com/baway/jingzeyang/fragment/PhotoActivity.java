package com.baway.jingzeyang.fragment;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.baway.jingzeyang.R;
import com.baway.jingzeyang.utils.Glideimageutils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by 荆泽阳 on 2017/3/17.
 * .::::.
 * .::::::::.
 * :::::::::::  Goddess bless, never bug
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 */

public class PhotoActivity extends AppCompatActivity {
    private PhotoView photoView;
    private ImageView imager, imager2;
    private String url;
    private String a;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoview);
        imager = (ImageView) findViewById(R.id.back);
        photoView = (PhotoView) findViewById(R.id.photo);
        imager2 = (ImageView) findViewById(R.id.down);
        Intent it = getIntent();
        url = it.getStringExtra("url");
        final int id = it.getIntExtra("id", 0);
        Glideimageutils.Imagelode(this, url, photoView);
        imager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imager2.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                Bitmap bitmap = photoView.getVisibleRectangleBitmap();


                try {
                    saveFile(bitmap, id + ".png");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void saveFile(Bitmap bm, String fileName) throws IOException {
        File path = Environment.getExternalStorageDirectory();
        File dirFile =  new File(path, fileName);
        Toast.makeText(PhotoActivity.this, "保存成功地址是"+dirFile.getPath(), Toast.LENGTH_SHORT).show();
        Log.i("TAG", dirFile.getPath());
        if (!dirFile.exists()) {
            dirFile.createNewFile();
        }
        FileOutputStream fil = new FileOutputStream(dirFile);
        BufferedOutputStream bos = new BufferedOutputStream(fil);
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();


        try {
            MediaStore.Images.Media.insertImage(this.getContentResolver(),
                    dirFile.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path)));
    }
}

