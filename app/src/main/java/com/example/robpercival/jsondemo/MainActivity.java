package com.example.robpercival.jsondemo;
import android.os.Parcel;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MainActivity extends Activity {

    private String[] king;


    public class Example
    {
        public String[] name;


        public String[] getExample()
        {
            String ar[] = new String[100];
            return ar; //returning two values at once
        }
    }



    public static ArrayList<String> myFriends = new ArrayList<String>();
    public static ArrayList<Double> Lat = new ArrayList<Double>();
    public static ArrayList<Double> lng = new ArrayList<Double>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        DownloadTask task = new DownloadTask();
        task.execute("https://api.jcdecaux.com/vls/v1/stations?contract=Dublin&apiKey=5bb43f341db582155668bdd1dd629688c8f76635");




    }






    public static class DownloadTask extends AsyncTask<String, Void, String> {




        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1) {

                    char current = (char) data;

                    result += current;

                    data = reader.read();

                }

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d("testing", result);

            String cat[] = new String[0];

            //Brings data from one file to anohter


            try {
                String rsult = "";

                //Keeping all my failers in it so you can see I done it myself :) will explain how whole code works in one big comment

                //  JSONObject jsonObject = new JSONObject(result);

                JSONArray arr = new JSONArray(result);
                // Log.d("testing", "1"+jsonObject.get("name"));
                //  Log.d("testing", "2"+jsonObject.getJSONArray("name"));
                //Log.d("testing", "3"+jsonObject.getJSONObject("name"));


                //   String weatherInfo = jsonObject.getString("number");
                String[] myList = new String[100];
                //  ArrayList<String> mylist = new ArrayList<String>();
                // double[] nums = new double[0];





                for (int i = 0; i < arr.length(); i++) {
                    //  String StationName;
                    JSONObject jsonPart = arr.getJSONObject(i);
                    //   myFamily.add(jsonPart);
                    //   Log.i("main", "testing msg");
                 Log.i("station", jsonPart.getString("name"));
                    // Log.i("LNG/LAT", jsonPart.getString("position"));
                    JSONObject pos= jsonPart.getJSONObject("position");
                    // myFamily.add(jsonPart.getString("name"));
                     Log.i("lat", pos.getString("lat"));
                       Log.i("lng", pos.getString("lng"));
                    myList[i] = jsonPart.getString("name");
//                    Log.i("", String.valueOf(pos));
                    myFriends.add(myList[i]);


//        Intent passdata_intent = new Intent(this, Test.class);
//
//        Bundle bundle = new Bundle();
//
//
//        bundle.putString(String.valueOf(myFriends), data1);
//        bundle.putString("first data", data2);

////                    String PosHolder[];
////                    PosHolder.add();

                    //myFamily[] =  converteNametoString;
                    double posDoubleLat = Double.parseDouble(pos.getString("lat"));
                    double posDoubleLng = Double.parseDouble(pos.getString("lng"));


                    lng.add(posDoubleLng);
                    Lat.add(posDoubleLat);
//                    System.out.println(cat[i]);
                    //myFamily.add(jsonPart.getJSONObject("position"));
                    // Log.i("f", String.valueOf(myFamily.get(i)));
//                   nums[i] = posDoubleLat;
//
//                    myFriends.add(converteNametoString);
//                    arr = new JSONArray("name");
//                    Log.i("jfsid", String.valueOf(arr));
                }
//                Intent Sendtomap = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(Sendtomap);


            } catch (JSONException e) {
                e.printStackTrace();
            }

//            String[] array1={"asd","fgh","dcf","dg","ere","dsf"};
//            Intent i=new Intent(MainActivity.this,Main2Activity.class);
//            i.putExtra("key",array1);
//            startActivity(i);

//            Log.i("wokw", String.valueOf(myFriends));

        }


    }




    public void onclick(View veiw) {
//        Log.i("wokw", String.valueOf(myFriends));
        Intent intent = new Intent(this, Test.class);
        intent.putExtra("string-array", myFriends);
        startActivity(intent);

//        Bundle b = new Bundle();
//        for (int i = 0; i < 99; i++) {
//            b.putStringArray(String.valueOf(this), new String[]{myFriends.get(i)});
//        }
//        Intent i=new Intent(this, Test.class);
//        i.putExtras(b);

//        String data1 = "this";
//        String data2 = "this2";
//
//        Intent passdata_intent = new Intent(this, Test.class);
//
//        Bundle bundle = new Bundle();
//
//
//        bundle.putString(String.valueOf(myFriends), data1);
//        bundle.putString("first data", data2);
//        passdata_intent.putExtra(String.valueOf(myFriends), data1);
//        passdata_intent.putExtra("data2", data2);
//
//        startActivity(passdata_intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
