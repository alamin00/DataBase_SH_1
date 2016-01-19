package com.crackbrain.tanveen.database_sh_1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    EditText etName,etEmail,etPhone,etAddress;
    Button buttonSave,btnView;

    DatabaseHelper dbHelper;

    EmplyeData obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText)findViewById(R.id.editTextName);
        etEmail = (EditText)findViewById(R.id.editTextEmail);
        etPhone = (EditText)findViewById(R.id.editTextPhone);
        etAddress = (EditText)findViewById(R.id.editTextAddress);

        buttonSave = (Button)findViewById(R.id.btnSave);
        btnView = (Button)findViewById(R.id.buttonView);

        dbHelper = new DatabaseHelper(this);


    }


public void saveMethod(View view)
{
    String name = etName.getText().toString();
    String email = etEmail.getText().toString();
    String phone = etPhone.getText().toString();
    String address = etAddress.getText().toString();

 obj = new EmplyeData(name,email,phone,address);


    Toast.makeText(getApplicationContext(),obj.toString(),Toast.LENGTH_LONG).show();

    long inserted = dbHelper.insertData(obj);

    if(inserted >=0)
    {
        Toast.makeText(getApplicationContext(),"DATA INSERTED",Toast.LENGTH_LONG).show();

    }
    else
    {
        Toast.makeText(getApplicationContext(),"DATA INSERTION FAILED.......",Toast.LENGTH_LONG).show();

    }
}


   public void viewMethod (View v)
    {
        ArrayList<EmplyeData>employeList = dbHelper.getAllEmplyees();

        if(employeList != null && employeList.size() >0)
        {
            for(EmplyeData em : employeList)
            {
                Toast.makeText(getApplicationContext(), em.toString(), Toast.LENGTH_LONG).show();
            }

        }

        else if(employeList.size() == 0)
        {
            Toast.makeText(getApplicationContext(),"NO data Found......",Toast.LENGTH_LONG).show();
        }
    }

}
