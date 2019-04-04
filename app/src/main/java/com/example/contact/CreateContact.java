package com.example.contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContact extends AppCompatActivity {
    EditText Name,phoneNumber;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        Name = findViewById(R.id.etName);
        phoneNumber = findViewById(R.id.etPhone);
        phoneNumber.setFilters(new InputFilter[] {new InputFilter.LengthFilter(10)});
        button = findViewById(R.id.btSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = Name.getText().toString();
                String phone = phoneNumber.getText().toString();
                createNewContact(name,phone);
            }
        });
    }
    private void createNewContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        Log.d("Contact: ", "New contact created: " + contact.toString());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("phoneNumber", phoneNumber);
        startActivity(intent);
    }

}
