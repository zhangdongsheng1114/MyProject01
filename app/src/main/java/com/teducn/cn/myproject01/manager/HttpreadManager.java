package com.teducn.cn.myproject01.manager;


import android.os.AsyncTask;

import com.teducn.cn.myproject01.entity.Book;
import com.teducn.cn.myproject01.util.StreamUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by tarena on 2017/6/15.
 */

public class HttpreadManager {
    private static List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try {
            URL url = new URL("");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setDoInput(true);
            connection.connect();

            int statusCode = connection.getResponseCode();
            if (statusCode == 200) {
                InputStream is = connection.getInputStream();
                // 将输入转换成一个字符串
                String jsonStr = StreamUtil.createStr(is);
                // 将json字符串包装成json对象
                JSONObject jsonObject = new JSONObject(jsonStr);
                String result = jsonObject.getString("result");
                if ("ok".equals(result)) {
                    JSONArray array = jsonObject.getJSONArray("data");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonBook = array.getJSONObject(i);
                        int id = jsonBook.getInt("id");

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public static LoadBooksListener listener;

    public static void asyncLoadBook(LoadBooksListener booksListener) {
        if (listener == null) {
            listener = booksListener;
        }
        // 启动异步任务的方法
        MyAsyncTask task = new MyAsyncTask();
        task.execute();
    }

    public static class MyAsyncTask extends AsyncTask<Void, Void, List<Book>> {

        @Override
        protected List<Book> doInBackground(Void... params) {
            // 把网络访问的方法在这里调用
            List<Book> books = loadBooks();
            return books;
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            // 把拿到的网络加载数据通知给Activity
            listener.onBooksLoadEnd(books);
        }
    }

    public interface LoadBooksListener {
        public void onBooksLoadEnd(List<Book> books);
    }
}
