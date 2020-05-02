package com.example.fillform.postRequests;

import android.os.AsyncTask;

import com.example.fillform.constants.Constants;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ScrapPostData extends AsyncTask<String, Void, Boolean> {
    private Constants constants;
    public static final MediaType
            FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    @Override
    protected Boolean doInBackground(String... strings) {
        constants = new Constants();
        Boolean result = true;
        String url = strings[0];
        String name = strings[1];
        String email = strings[2];
        String phoneNumber = strings[3];
        String postBody = "";
        try {
            postBody = constants.testNameField+"="+ URLEncoder.encode(name, "UTF-8") + "&" +
                       constants.testEmailAddress+"="+ URLEncoder.encode(email,"UTF-8")+ "&" +
                        constants.testPhoneNumber+"="+URLEncoder.encode(phoneNumber, "UTF-8");
        }catch(UnsupportedEncodingException ex){
            result = false;
        }
        try{
            OkHttpClient client = new OkHttpClient();
            RequestBody body =  RequestBody.create(FORM_DATA_TYPE, postBody);

            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            //Send the request
            Response response = client.newCall(request).execute();
        }catch (IOException exception){
            result=false;
        }
        return result;

       
    }
}
