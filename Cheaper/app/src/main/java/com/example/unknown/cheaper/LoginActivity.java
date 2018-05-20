package com.example.unknown.cheaper;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unknown.cheaper.Classes.UserClass;

public class LoginActivity extends AppCompatActivity {

    public static UserClass CurrentUser;


    EditText name_Edittext;
    EditText password_Edittext;
    TextView forgetPassword_textView;
    Button signin_btn;
    TextView createNewAccount_Textview;
    TextView signinWithFacebook_Textview;
    ImageView signinWithFacebook_Imageview;


    EditText userEmail_Edittext;
    Button send_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        GetViewELements();

        forgetPassword_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendPassword();
            }
        });

        //open sginup activity
        createNewAccount_Textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);

            }
        });


        //open Home Activity

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CurrentUser= new UserClass(1,"Yasser Mohamed","Yasser EL-Nagar","yasser@gmail.com","123");


                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);




            }
        });

    }


    //this method for Sending Email in Case of Forgeting Password
    private void  SendPassword(){

        Dialog dialog = new Dialog(LoginActivity.this,R.style.Theme_Dialog);
        dialog.setContentView(R.layout.special_dialog_signoption_layout);
        dialog.setTitle(R.string.DidYouForgetYourPassword);

        userEmail_Edittext=dialog.findViewById(R.id.userEmail_Edittext);
        send_btn=dialog.findViewById(R.id.send_btn);


        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Reset Password");
                intent.putExtra(Intent.EXTRA_TEXT, userEmail_Edittext.getText()+" asks to reset his/her passwprd");
                intent.setData(Uri.parse("mailto:"+userEmail_Edittext.getText()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                startActivity(intent);
            }
        });

        //this code for making dialog appear at the bottom of the screen
//        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//        lp.copyFrom(dialog.getWindow().getAttributes());
//        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        lp.gravity = Gravity.BOTTOM;
//        dialog.getWindow().setAttributes(lp);

        dialog.show();

    }

    //this method for inflating view elements
    private void GetViewELements(){

        name_Edittext=findViewById(R.id.name_Edittext);
        password_Edittext=findViewById(R.id.password_Edittext);
        forgetPassword_textView=findViewById(R.id.forgetPassword_textView);
        signin_btn=findViewById(R.id.signin_btn);
        createNewAccount_Textview=findViewById(R.id.createNewAccount_Textview);
        signinWithFacebook_Textview=findViewById(R.id.signinWithFacebook_Textview);
        signinWithFacebook_Imageview=findViewById(R.id.signinWithFacebook_Imageview);

    }
}
