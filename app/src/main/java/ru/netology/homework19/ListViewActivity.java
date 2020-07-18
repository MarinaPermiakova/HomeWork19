package ru.netology.homework19;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();
        BaseAdapter listContentAdapter = createAdapter(values);
        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        return new SimpleAdapter(this, values,
                R.layout.simple_adapter,
                new String[]{"text", "number"},
                new int[]{R.id.textView, R.id.textView2});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> arrayList = new ArrayList<>();
        Map<String, String> map;

        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i < arrayContent.length; i++) {
            map = new HashMap<>();
            map.put("text", arrayContent[i]);
            map.put("number", String.valueOf(arrayContent[i].length()));
            arrayList.add(map);
        }
        return arrayList;
    }
}
