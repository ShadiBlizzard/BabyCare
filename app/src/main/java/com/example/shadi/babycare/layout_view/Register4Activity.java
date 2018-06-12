package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import android.widget.ImageView;

import com.example.shadi.babycare.R;


public class Register4Activity extends AppCompatActivity implements View.OnClickListener{

    private Bundle bundle;
    private static final int SELECTED_PICTURE = 0;
    private ImageView img;
    private Button upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register4);
        this.setTitle("Register");
        Intent intent = getIntent();
        bundle = intent.getExtras();

        img = findViewById(R.id.imageView);
        upload = findViewById(R.id.upload);

        img.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECTED_PICTURE && resultCode == RESULT_OK && data!= null) {
            Uri selectedImage = data.getData();
            img.setImageURI(selectedImage);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, SELECTED_PICTURE);
                break;
            case R.id.upload:
                //TODO how to send to the server the image uploaded and all the previous data bundle
                /*basing on the result of the registration, we could have two results, one of
                correctness that call RegisterOkActivity, One with error that will call RegiterErrorActivity
                NOW I HARDCODE THE OK
                 */
                Intent ok = new Intent(this, RegistrationOkActivity.class);
                startActivity(ok);
                break;
        }
    }

  /*  private class UploadImage extends AsyncTask<Void, Void, Void> {

        Bitmap image;

        public  UploadImage(Bitmap image) {
            this.image=image;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);

            ArrayList<NameValuePair> dataTosend = new ArrayList<>();
            dataTosend.add(new BasicNameValuePair("image", encodedImage));


            return null;
        }
    }

    private HttpParams getHttpRequestParams() {

    } */
}
