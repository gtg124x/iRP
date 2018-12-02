package team1.gatech.edu.irp.controllers;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.content.DialogInterface.OnClickListener;
import team1.gatech.edu.irp.R;
import android.view.View;
import android.widget.ImageView;

public class LockedActivity extends AppActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locked);

        //setInitialImage();
        //setImageRotateListener();


        Toast.makeText(this, "Account locked! Sorry!",
                Toast.LENGTH_SHORT).show();
    }




}