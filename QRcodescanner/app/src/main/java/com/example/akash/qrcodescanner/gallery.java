package com.example.akash.qrcodescanner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class gallery extends AppCompatActivity {


    Button b1,b2;
    private final static int Pickimage=100;
    ImageView image;
    Uri targetUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        b2  = (Button) findViewById(R.id.button2);
        image = (ImageView) findViewById(R.id.image);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, Pickimage);
            }
        });
    }

           @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode==Pickimage){
             targetUri = data.getData();
//            textTargetUri.setText(targetUri.toString());
//            Bitmap bitmap;
            image.setImageURI(targetUri);
//          try {
//              bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
//              image.setImageBitmap(bitmap);
//          } catch (FileNotFoundException e) {
//             // TODO Auto-generated catch block
//               e.printStackTrace();
//           }
        }
    }
}

