package kr.co.hajun.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Lab14_1DetailActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab141_detail);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        listView=findViewById(R.id.detail_list);
        listView.setOnItemClickListener(this);

        Lab14_1DBHelper helper=new Lab14_1DBHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select location from tb_data where category=?", new String[]{category});
        datas=new ArrayList<>();
        while (cursor.moveToNext()){
            datas.add(cursor.getString(0));
        }
        db.close();

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        Intent intent = getIntent();
        intent.putExtra("location",textView.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}