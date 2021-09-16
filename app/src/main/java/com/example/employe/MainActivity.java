package com.example.employe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Employee> employeeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getMinstance(this).getRequestQueue();
        employeeList = new ArrayList<Employee>();
        
        fetchemployes();
//        networkcheck();

    }

//    private void networkcheck() {
//        ConnectivityManager conmgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = conmgr.getActiveNetworkInfo();
//        if (networkInfo == null){
//         if (networkInfo.isConnected())
//        }
//    }

    private void fetchemployes() {
        String url = "https://jsonplaceholder.typicode.com/users";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++){
                    try{
                        JSONObject jsonObject = response.getJSONObject(i);
                        String id = jsonObject.getString("id");
                        String name = StringUtills.convertToCameCase(jsonObject.getString("name"));
                        String email =StringUtills.convertToSmallcase(jsonObject.getString("email"));
                        String phone = jsonObject.getString("phone");
                        String website = jsonObject.getString("website");
                        String company_name = jsonObject.getString("company");
                        String address = jsonObject.getString("address");

                        Employee employee1 = new Employee(id,name, email,phone,company_name, website,address);
                        employeeList.add(employee1);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    EmployeeAdapter adapter = new EmployeeAdapter(MainActivity.this,employeeList);
                    recyclerView.setAdapter(adapter);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        requestQueue.add(jsonArrayRequest);




















    }
}