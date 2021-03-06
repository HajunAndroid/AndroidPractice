package kr.co.hajun.androidpractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Lab14_1Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> datas;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab141);

        listView = findViewById(R.id.main_list);
        listView.setOnItemClickListener(this);

        Lab14_1DBHelper helper = new Lab14_1DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select location from tb_data where category = '0'",null);

        datas=new ArrayList<>();
        while(cursor.moveToNext()){
            datas.add(cursor.getString(0));
        }
        db.close();

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        category = textView.getText().toString();

        Intent intent = new Intent(this, Lab14_1DetailActivity.class);
        intent.putExtra("category",category);
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK) {
            String location = data.getStringExtra("location");
            Toast toast = Toast.makeText(this, category + ":" + location, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}