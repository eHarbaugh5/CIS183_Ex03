package com.example.objectsarraylistscustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //  Establish
    Button btn_j_addUser;
    EditText et_j_fName;
    EditText et_j_lName;
    EditText et_j_email;
    ListView lv_j_listUsers;
    ArrayList<User> listOfUsers;
    UserListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Connect
        btn_j_addUser = findViewById(R.id.btn_v_addUser);
        et_j_fName = findViewById(R.id.et_v_fName);
        et_j_lName = findViewById(R.id.et_v_lName);
        et_j_email = findViewById(R.id.et_v_email);
        lv_j_listUsers = findViewById(R.id.lv_v_users);

        //User user = new User("Bob", "Smith", "bsmith@gmail.com");
        //Log.d("user first name", user.getfName());
        listOfUsers = new ArrayList<User>();

        registerButtonEventHandler();
        fillListView();


    }


    public void registerButtonEventHandler()
    {
        btn_j_addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                //Log.d("Add User Clicked", "Clicked");
                addUser();
                clearTextBoxes();
                displayListOfUsers();
                adapter.notifyDataSetChanged();

            }
        });

    }

    public void addUser()
    {

        //  make sure the user entered something into the text boxes
        if(!et_j_fName.getText().toString().equals("") &&  !et_j_lName.getText().toString().equals("") && !et_j_email.getText().toString().equals(""))
        {

            //  if you are here the user has entered information into all of the text boxes

            //  make a new user to add to the list
            User newUser = new User();

            //  get the information entered in the textboxes
            String fName = et_j_fName.getText().toString();
            String lName = et_j_lName.getText().toString();
            String email = et_j_email.getText().toString();

            //  add the information to the new user
            newUser.setfName(fName);
            newUser.setlName(lName);
            newUser.setEmail(email);

            //  Store the information in the arrayList
            listOfUsers.add(newUser);

        }

    }



    public void clearTextBoxes()
    {

        et_j_fName.setText("");
        et_j_lName.setText("");
        et_j_email.setText("");
        displayListOfUsers();


    }


    public void displayListOfUsers()
    {

        for (int i = 0; i < listOfUsers.size(); i++)
        {
            Log.d("User: ", listOfUsers.get(i).getfName().toString());
        }

    }

    public void fillListView()
    {

        adapter = new UserListAdapter(this, listOfUsers);
        //  set the listviews adapter
        lv_j_listUsers.setAdapter(adapter);

    }


    //  Bottom


}