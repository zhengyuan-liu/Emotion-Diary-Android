package org.hackpku.emotiondiary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.hackpku.emotiondiary.common.Diary.Diary;
import org.hackpku.emotiondiary.common.Diary.DiaryPicture;

import java.util.Properties;


public class showDiaryActivity extends AppCompatActivity {
    /*
    传入 intent 包含一个 diary 引用。
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.showDiaryToolbar);
        toolbar.setTitle("查看日记");
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Diary diary = (Diary) intent.getExtras().get("diary");
        ImageView captionImageView = (ImageView) findViewById(R.id.showImageView);
        captionImageView.setImageBitmap(diary.getSelfie().getImage());
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.showProgressBar);
        progressBar.setMax(0);
        progressBar.setMax(100);
        progressBar.setProgress(diary.getHappiness());
        TextView textView = (TextView) findViewById(R.id.showTextView);
        textView.setText(diary.getText());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.showImageList);
        for(DiaryPicture diaryPicture:diary.getPictures()){
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageBitmap(diaryPicture.getImage());
            linearLayout.addView(imageView);
        }


    }
}
