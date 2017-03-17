package com.charmingwong.wxnews;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private NewsListAdapter mAdapter;
    private BitmapCache mBitmapCache;
    private Map<String, Object> mNewsData;
    private SwipeRefreshLayout mRefresh;
    private long flag;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        NewsPresenter presenter = NewsPresenter.getInstance(this);
        presenter.setOnResponseCallback(new OnResponseCallback() {
            public void onResponseSuccess(Object response) {
                if (mRefresh.isRefreshing()) {
                    mRefresh.setRefreshing(false);
                }
                mNewsData = (Map<String, Object>) response;
                if (listView.getAdapter() == null) {
                    listView.setAdapter(mAdapter);
                }
                mAdapter.setData(mNewsData);
                mAdapter.notifyDataSetChanged();
            }

            public void onResponseError(Exception e) {
            }
        });
        presenter.startPresent();
    }

    private void init() {
        listView = (ListView) findViewById(R.id.news_list);
        mRefresh = (SwipeRefreshLayout) findViewById(R.id.news_refresh);
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            public void onRefresh() {
                NewsPresenter.getInstance(MainActivity.this).startPresent();
            }
        });
        mAdapter = new NewsListAdapter(this);
        mBitmapCache = new BitmapCache(this);
        mAdapter.setBitmapCache(mBitmapCache);
        listView.setDivider(null);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this, NewsDetailsActivity.class);
                    Result result = (Result) mNewsData.get("result");
                    java.util.List<List> datas = result.getList();
                    intent.setData(Uri.parse(datas.get(position).getUrl()));
                    startActivity(intent);
            }
        });
    }


    protected void onDestroy() {
        super.onDestroy();
        try {
            mBitmapCache.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        long current = System.currentTimeMillis();
        if (current - flag < 2000) {
            super.onBackPressed();
        }
        flag = current;
    }
}
