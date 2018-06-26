package com.example.unknown.cheaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class UseragreementActivity extends AppCompatActivity {


    ExpandableListView userAgreement_expandablelistview;

    CheckBox userAgreement_checkbox;

    Button sign_btn;

    HashMap<String ,ArrayList<String>> AgreementHashmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useragreement);

        GetViewELements();


        //////////////// just for testing purposes

        ArrayList<String> Conditions= new ArrayList<>();
        Conditions.add("يحظر على المتاجر الانشطه التاليه");
        Conditions.add("الاعلان عن اى منتجات لا تخص اقسام المنتجات المعروضه بالتطبيق. \n كذلك اى استخدام غير مصرح به لخدمات ارخصلى بما فى ذلك جميع اسماء المستخدمين او عناوين البريد الالكترونى ");

        AgreementHashmap = new HashMap<>();

        AgreementHashmap.put("اعتماد الاتفاقيه",Conditions);
        AgreementHashmap.put("وصف الخدمة",Conditions);
        AgreementHashmap.put("الانشطة المحظورة",Conditions);

        /////////////////////////////////////////////////////////////////////////////////


        UserAgreementAdapter adapter = new UserAgreementAdapter(UseragreementActivity.this,AgreementHashmap);

        userAgreement_expandablelistview.setAdapter(adapter);

    }


    //this method for inflating view elements
    private void GetViewELements() {

        userAgreement_expandablelistview = findViewById(R.id.userAgreement_expandablelistview);
        userAgreement_checkbox = findViewById(R.id.userAgreement_checkbox);
        sign_btn = findViewById(R.id.sign_btn);

    }
}