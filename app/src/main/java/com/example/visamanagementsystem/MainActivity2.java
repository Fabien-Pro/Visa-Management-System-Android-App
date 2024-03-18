package com.example.visamanagementsystem;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private List<Item> itemList;
    private MyAdapter itemAdapter;
   private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);
                return true;
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Dyna MUKARUGENDO","dmukarugendo@gmail.com",R.drawable.a));
        items.add(new Item("Umwana Anne","umwana@gmail.com",R.drawable.a));
        items.add(new Item("Gisa ","gisa@gmail.com",R.drawable.a));
        items.add(new Item("Kalisa John","kalisa@gmail.com",R.drawable.a));
        items.add(new Item("Fabien NIYIGABA","niyigaba@gmail.com",R.drawable.a));
        items.add(new Item("Dyna MUKARUGENDO","dmukarugendo@gmail.com",R.drawable.a));
        items.add(new Item("Umwana Anne","umwana@gmail.com",R.drawable.a));
        items.add(new Item("Gisa ","gisa@gmail.com",R.drawable.a));
        items.add(new Item("Kalisa John","kalisa@gmail.com",R.drawable.a));
        items.add(new Item("Fabien NIYIGABA","niyigaba@gmail.com",R.drawable.a));
        items.add(new Item("Dyna MUKARUGENDO","dmukarugendo@gmail.com",R.drawable.a));
        items.add(new Item("Umwana Anne","umwana@gmail.com",R.drawable.a));
        items.add(new Item("Gisa ","gisa@gmail.com",R.drawable.a));
        items.add(new Item("Kalisa John","kalisa@gmail.com",R.drawable.a));
        items.add(new Item("Fabien NIyo","niyigaba@gmail.com",R.drawable.a));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
        itemList=new ArrayList<>();

    }

    private void fileList(String text) {
        List<Item> filteredList = new ArrayList<>();
        for (Item item : itemList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
            if (filteredList.isEmpty()) {
                Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show();
            }
            else {
                 itemAdapter.setFilteredList(filteredList);
            }
        }
    }

    public void setItemAdapter(MyAdapter itemAdapter) {
        this.itemAdapter = itemAdapter;
    }
}