package com.example.unknown.cheaper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.drm.DrmStore;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    ImageView user_ImageView;
    EditText name_Edittext;
    EditText email_Edittext;
    EditText phone_Edittext;
    EditText password_Edittext;
    EditText retypePassword_Edittext;
    Button signup_btn;



    static int choose_photo = 1;
    static int take_photo =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        GetViewELements();

        user_ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SelectPhotoOption();

            }
        });

        RemoveRequired();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {


            if (requestCode == take_photo) {

                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                user_ImageView.setImageBitmap(bitmap);
                Toast.makeText(SignupActivity.this, R.string.ImageSuccessfullyChoosed,Toast.LENGTH_SHORT);

            } else {

                Uri path = data.getData();
                user_ImageView.setImageURI(path);
            }
        }
        catch (Exception e){

            Log.v("error",e.getMessage());
            Toast.makeText(SignupActivity.this, R.string.ImageFailedChoosed,Toast.LENGTH_SHORT).show();

        }


    }







    //this method to display Image Options
    private void SelectPhotoOption(){

        AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
        builder.setTitle(R.string.ChooseImage);
        builder.setMessage(R.string.ImageChooseOptions);
        builder.setPositiveButton(getString(R.string.TakePhoto), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                TakePhoto();

            }
        });

        builder.setNegativeButton(getString(R.string.ChooseImage), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ChoosePhoto();
            }
        });

        builder.setNeutralButton(getString(R.string.Cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();

    }


    private void TakePhoto(){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,take_photo);

    }
    private void ChoosePhoto(){

        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent,"Choose Your Photo"),choose_photo);

    }





    //this method for inflating view elements
    private void GetViewELements(){

        name_Edittext=findViewById(R.id.name_Edittext);
        email_Edittext=findViewById(R.id.email_Edittext);
        phone_Edittext=findViewById(R.id.phone_Edittext);
        password_Edittext=findViewById(R.id.password_Edittext);
        retypePassword_Edittext=findViewById(R.id.retypePassword_Edittext);
        signup_btn=findViewById(R.id.signup_btn);
        user_ImageView=findViewById(R.id.user_ImageView);

    }


    private  void RemoveRequired(){

        email_Edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(email_Edittext.getText().toString().length()>1) {
                    email_Edittext.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.opened_email, 0);
                }
                else {

                    email_Edittext.setCompoundDrawablesWithIntrinsicBounds(R.drawable.reqired, 0, R.drawable.opened_email, 0);

                }


            }
        });

        phone_Edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(phone_Edittext.getText().toString().length()>1) {
                    phone_Edittext.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.smartphone_call, 0);
                }
                else {

                    phone_Edittext.setCompoundDrawablesWithIntrinsicBounds(R.drawable.reqired, 0, R.drawable.smartphone_call, 0);

                }


            }
        });

        password_Edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(password_Edittext.getText().toString().length()>1) {
                    password_Edittext.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.padlock, 0);
                }
                else {

                    password_Edittext.setCompoundDrawablesWithIntrinsicBounds(R.drawable.reqired, 0, R.drawable.padlock, 0);

                }


            }
        });


        retypePassword_Edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(retypePassword_Edittext.getText().toString().length()>1) {
                    retypePassword_Edittext.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.padlock, 0);
                }
                else {

                    retypePassword_Edittext.setCompoundDrawablesWithIntrinsicBounds(R.drawable.reqired, 0, R.drawable.padlock, 0);

                }


            }
        });

    }

}
