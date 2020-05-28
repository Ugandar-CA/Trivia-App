package com.example.triviaapp.Data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.triviaapp.Controller.AppController;
import com.example.triviaapp.Model.QuestionModel;

import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    ArrayList<QuestionModel> questionArrayList = new ArrayList<>();
    private String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    public List<QuestionModel> questionList(final AnswerListAsyncResponse callBack){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i=0;i<response.length();i++){
                            QuestionModel questionModel = new QuestionModel();
                            try {
                                questionModel.setQuestions(response.getJSONArray(i).get(0).toString());
                                questionModel.setTrueOrFalse(response.getJSONArray(i).getBoolean(1));
                                Log.i("Json","onResponse"+ response.getJSONArray(i).get(0));
                                Log.i("json boolean","onResponse"+ response.getJSONArray(i).getBoolean(1));
                                questionArrayList.add(questionModel);
                                Log.d("hello", "onResponse: " +questionModel);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if(callBack != null){
                            callBack.processFinished(questionArrayList);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;
    }


}
