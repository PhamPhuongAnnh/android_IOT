package com.example.ttcs;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadJsone {
    public  void readJSonFile(Context context)throws IOException,JSONException{
        String jsonText = readText(context,R.raw.data);
        JSONObject jsonRoot = new JSONObject(jsonText);
        String id = jsonRoot.getString("id");
        String title = jsonRoot.getString("title");
        JSONObject object = jsonRoot.getJSONObject("value").getJSONObject("object_example");
        System.out.println(object);

    }


    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
