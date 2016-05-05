package com.example.llw.demo_sax_xml;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager asset = getAssets();
        try {
            InputStream input = asset.open("student01.xml");
            List<Student> list = ParserBySAX.parseXML(input);
            for (Student stu : list) {
                Log.e("StudentInfo", "Person ID: " + stu.getId() + ","
                        + stu.getName() + ", " + stu.getAge() + ", "
                        + stu.getSex());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
