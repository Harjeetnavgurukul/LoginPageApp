package com.draw.loginpageapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    EditText editText, editText1, editText2;
    Button button, button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mDatabaseHelper = new DatabaseHelper(this);
        editText = findViewById(R.id.edt_1);
        editText1 = findViewById(R.id.edt_2);
        editText2 = findViewById(R.id.edt_3);
        button = findViewById(R.id.btn_1);
        button1 = findViewById(R.id.btn_2);

        AddData();
//        ShowData();

    }

    //Data insertion java code for registration....user.......
    public void AddData(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted =  mDatabaseHelper.insertData(
                        editText1.getText().toString(),
                        editText2.getText().toString());
                if (isInserted == true)
                    Toast.makeText(getApplicationContext(),"Data is inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Data is not inserted", Toast.LENGTH_LONG).show();

            }
        });

    }

    //Show data......
//    public void ShowData() {
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor res = mDatabaseHelper.getAllData();
//                if (res.getCount() == 0) {
//                    ShowMessage("Error", "Nothing found");
//                    return;
//                }
//
//                StringBuffer buffer = new StringBuffer();
//                while (res.moveToNext()) {
//                    buffer.append("ID : " + res.getString(0) + "\n");
//                    buffer.append("NAME : " + res.getString(1) + "\n");
//                    buffer.append("EMAIL_ID : " + res.getString(2) + "\n");
//                    buffer.append("PASSWORD: " + res.getString(3) + "\n");
//                }
//                ShowMessage("Data", buffer.toString());
//            }
//
//        });
//    }

    public void ShowMessage(String Tittle, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Tittle);
        builder.setMessage(Message);
        builder.show();

    }
}
