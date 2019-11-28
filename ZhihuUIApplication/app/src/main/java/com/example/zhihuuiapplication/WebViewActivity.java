package com.example.zhihuuiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.zhihuuiapplication.adapters.WebViewPagerAdapter;
import com.example.zhihuuiapplication.bean.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebViewActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        assert data != null;
        for (int i = 0; i <= data.size() - 2; i++) {
            urls.add(data.getString("url" + i));
        }
        int position=data.getInt("position");
//        int position=0;
//        Set<String> keySet = data.keySet();
//        for(String key : keySet){
//            if(data.get(key).getClass().getName().toString().equals("Integer")){
//                position=(int) data.get(key);
//            }else {
//                urls.add((String) data.get(key));
//            }
//        }

        viewPager=findViewById(R.id.web_vp);
        if(urls!=null) {
            viewPager.setAdapter(new WebViewPagerAdapter(this, urls));
            if(urls.size()==5){
                viewPager.setCurrentItem(position);
            }else {
                viewPager.setCurrentItem(position + 3);
            }
        }else {
            List<String> fakeUrl=new ArrayList<>();
            fakeUrl.add("https://daily.zhihu.com/story/9717105");
            fakeUrl.add("https://daily.zhihu.com/story/9717105");
            fakeUrl.add("https://daily.zhihu.com/story/9717105");
            viewPager.setAdapter(new WebViewPagerAdapter(this,fakeUrl));
        }
    }
}

