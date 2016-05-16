package com.nominalista.twotoolbars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mItemsRecyclerView;
    private ItemsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActionBar();
        initRecyclerView();
    }

    private void setupActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
    }

    private void initRecyclerView() {
        mItemsRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_items);
        mAdapter = new ItemsAdapter(generateContent());
        mItemsRecyclerView.setAdapter(mAdapter);
        mItemsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    private List<String> generateContent() {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; ++i) items.add("Item " + i);
        return items;
    }
}
