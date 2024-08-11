package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void launchMap(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:19.0760, 72.8777?q=Mukesh Patel School of Technology Management Vile Parle"));
        Intent chooserIntent = Intent.createChooser(intent, "Launch Map");
        startActivity(chooserIntent);
    }

    public void launchMarket(View view) {
        String appPackageName = "com.gdscmpstme.mpstme_ontrack";
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    public void launchMail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dwaynesilvapinto@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hi, From my App");
        intent.putExtra(Intent.EXTRA_TEXT, "Hi, What's up? \n" +
                "This email sent from my app");
        intent.setType("message/rfc822");
        Intent chooserIntent = Intent.createChooser(intent, "Send Email");
        startActivity(chooserIntent);
    }

    public void launchWebPage(View view) {
        String url = "http://www.google.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        Intent chooserIntent = Intent.createChooser(intent, "Choose Phone App");
        startActivity(chooserIntent);
    }

    public void launchPhone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:123456789"));
        Intent chooserIntent = Intent.createChooser(intent, "Choose Phone App");
        startActivity(chooserIntent);
    }

    public void launchCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Intent chooserIntent = Intent.createChooser(intent, "Choose Phone App");
        startActivityForResult(chooserIntent, 101);
    }

    public void launchMessages(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));
        startActivity(intent);
    }
}