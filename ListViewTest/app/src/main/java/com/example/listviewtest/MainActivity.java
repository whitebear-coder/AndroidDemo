package com.example.listviewtest;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //初始化水果数据
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits(){
        for(int i=0;i<2;i++){
            Fruit apple = new Fruit("apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("banana", R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("orange", R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("watermelon", R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("pear", R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("grape", R.drawable.grape_pic);
            fruitList.add(grape);
        }
    }
}