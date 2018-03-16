package com.example.robpercival.jsondemo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test extends Activity {


   public static ArrayList<String> myFriends = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
//        Bundle b=this.getIntent().getExtras();
//        String[] array=b.getStringArray(myFriends);
//for (int i = 0; i < 5; i++) {
//    myFriends.add(myFriends.get(1));
//}
        myFriends.add("PARNELL SQUARE NORTH");
        myFriends.add("CLONMEL STREET");
        myFriends.add("MOUNT STREET LOWER");
        myFriends.add("CHRISTCHURCH PLACE");
        myFriends.add("GRANTHAM STREET");
        myFriends.add("PEARSE STREET");
        myFriends.add("YORK STREET EAST");
        myFriends.add(" EXCISE WALK");
        myFriends.add("FITZWILLIAM SQUARE WEST");

        String [] stringArray = intent.getStringArrayExtra("string-array");
//        for (int i = 0; i < 99; i++){
//            myFriends.add(stringArray[i]);
//        }
//        myFriends.add(stringArray[1]);

//        Bundle bundle = getIntent().getExtras();
//        String data1 = bundle.getString("data1");
//        String data2 = bundle.getString("data2");

        ListView myListView = (ListView)findViewById(R.id.myList);



//        for (int i = 0; i < 100 ; i++) {
//        myFriends.add(stringArray[i]);
//        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent intent1 = new Intent(getApplicationContext(), MapsActivity.class);
                intent1.putExtra("string-array", myFriends);
                intent1.putExtra("place number", i);
                startActivity(intent1);

            }
        });











    }

}
