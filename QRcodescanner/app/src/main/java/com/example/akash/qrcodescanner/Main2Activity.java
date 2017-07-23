package com.example.akash.qrcodescanner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    Bitmap myQRCode;
    EditText t1;
    ImageView image;
    TextView t2,textTargetUri;
    Button b1,b2;
    Uri targetUri;
    private final static int Pickimage=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1 = (EditText) findViewById(R.id.filename);
        t2 = (TextView) findViewById(R.id.res);
        image = (ImageView) findViewById(R.id.image);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        textTargetUri = (TextView)findViewById(R.id.targetUri);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, Pickimage);
            }
        });

        final BarcodeDetector barcodeDetector =
                new BarcodeDetector.Builder(this)
                        .setBarcodeFormats(Barcode.QR_CODE)
                        .build();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                final String name = t1.getText().toString();
//
//                try {
//                    myQRCode = BitmapFactory.decodeStream(
//                            getAssets().open(name + ".jpg")
//                    );
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                try {
                    myQRCode = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//                image.setImageBitmap(bitmap);

                Frame myFrame = new Frame.Builder()
                        .setBitmap(myQRCode)
                        .build();
//                image.setImageBitmap(myQRCode);

                SparseArray<Barcode> barcodes = barcodeDetector.detect(myFrame);

                // Check if at least one barcode was detected
                if(barcodes.size() != 0) {

                    t2.setText(barcodes.valueAt(0).displayValue);
                    Intent intent = new Intent(Main2Activity.this, browser.class);
                    intent.putExtra("name",barcodes.valueAt(0).displayValue);
                    startActivity(intent);

                }

            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode==Pickimage){
             targetUri = data.getData();
            textTargetUri.setText(targetUri.toString());
//            Bitmap bitmap;
            image.setImageURI(targetUri);
//            try {
//                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
//                image.setImageBitmap(bitmap);
//            } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        }
    }
}
