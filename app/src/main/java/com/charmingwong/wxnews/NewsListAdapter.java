package com.charmingwong.wxnews;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.List;
import java.util.Map;

/**
 * Created by 56223 on 2016/11/18.
 */

public class NewsListAdapter extends BaseAdapter {

    private static final String TAG = "NewsListAdapter";
    private BitmapCache mBitmapcache;
    private Context mContext;
    private List<com.charmingwong.wxnews.List> mData;
    private ImageLoader mImageLoader;

    public NewsListAdapter(Context context) {
        mContext = context;
    }

    public Object getItem(int position) {
        return mData.get(position);
    }

    public void setBitmapCache(BitmapCache cache) {
        mBitmapcache = cache;
        mImageLoader = new ImageLoader(Volley.newRequestQueue(mContext), mBitmapcache);
    }

    public void setData(Map<String, Object> data) {
        Result result = (Result) data.get("result");
        mData = result.getList();
    }

    public int getCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("NewsListAdapter", "getView: " + position);
        com.charmingwong.wxnews.List data = (com.charmingwong.wxnews.List) getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.news_list_item, null);
            holder.titleText = (TextView) convertView.findViewById(R.id.news_item_title);
            holder.sourceText = (TextView) convertView.findViewById(R.id.news_item_source);
            holder.image1 = (ImageView) convertView.findViewById(R.id.news_item_image);
            holder.titleText.setText(data.getTitle());
            holder.sourceText.setText(data.getSource());
            convertView.setTag(holder);
        } else {
            holder = (NewsListAdapter.ViewHolder) convertView.getTag();
            holder.titleText.setText(data.getTitle());
            holder.sourceText.setText(data.getSource());
        }
        Log.i(TAG, "getView: " + data.getFirstimg());
        if (data.getFirstimg() != null) {
            ImageLoader.ImageListener listener1
                    = ImageLoader.getImageListener(holder.image1, R.drawable.ic_preload, R.drawable.ic_preload);
            mImageLoader.get(data.getFirstimg(), listener1);
        }
        return convertView;
    }

    static class ViewHolder {
        ImageView image1;
        TextView sourceText;
        TextView titleText;
    }


}
