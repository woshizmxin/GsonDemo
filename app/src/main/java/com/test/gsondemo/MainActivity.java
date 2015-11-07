package com.test.gsondemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    private String str = "[{\"name\":\"name0\",\"age\":0}]";
    private String strList = "[{\"name\":\"name0\",\"age\":0},{\"name\":\"name1\",\"age\":5},{\"name\":\"name2\",\"age\":10},{\"name\":\"name3\",\"age\":15},{\"name\":\"name4\",\"age\":20},{\"name\":\"name5\",\"age\":25},{\"name\":\"name6\",\"age\":30},{\"name\":\"name7\",\"age\":35},{\"name\":\"name8\",\"age\":40},{\"name\":\"name9\",\"age\":45}]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.json2class)
     void json2class(){
        Gson gson = new Gson();
        Person[] person = gson.fromJson(str, Person[].class);
        Log.i("zm", "#####json2class: " + person[0].toString());
    }

    @OnClick(R.id.json2classlist)
     void json2classList(){
        Gson gson = new Gson();
        List<Person> ps = gson.fromJson(strList, new TypeToken<List<Person>>(){}.getType());
        for(int i = 0; i < ps.size() ; i++)
        {
            Person p = ps.get(i);
            Log.i("zm", "********json2classlist: " + p.toString());
        }
    }

    @OnClick(R.id.class2json)
    void class2json(){
        Gson gson = new Gson();
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setName("name" + i);
            p.setAge(i * 5);
            persons.add(p);
        }
        String toStr = gson.toJson(persons);
        Log.i("zm", "#####str2json: " + toStr);
    }
}
