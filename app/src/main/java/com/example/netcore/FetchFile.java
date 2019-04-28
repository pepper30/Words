package com.example.netcore;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.Scanner;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FetchFile extends AsyncTask {
    Request request;
    Response response;
    String url = "http://pnstage.netcore.co.in/netcore-interview-textfile.txt";
    String result;

    @Override
    protected Object doInBackground(Object[] objects) {

        return null;
    }

    String run() throws IOException {
        OkHttpClient client = new OkHttpClient();
        request = new Request.Builder().url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (!response.isSuccessful()) throw new IOException("Unexpected Code" + response);

                InputStream in = response.body().byteStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line = reader.readLine();
                result = line;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }



            }
        });
        return result;
    }



}


