package me.miza.jetpay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.hover.sdk.api.HoverParameters;

public class CameraActivity extends AppCompatActivity {
    private CodeScanner mScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        CodeScannerView mScannerView = findViewById(R.id.scanner);
        mScanner = new CodeScanner(this, mScannerView);
        mScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                String[] split = result.getText().split("\\s+");
                System.out.println(split[0]);
                System.out.println(split[1]);
                Intent i = new HoverParameters.Builder(CameraActivity.this)
                        .request("c49b6e17")
                        .extra("PhoneNo", split[1])
                        .extra("Amount",split[0])
                        .style(R.style.AppTheme)
                        .setHeader(getResources().getString(R.string.processing_request))
                        .buildIntent();
                startActivityForResult(i, 0);
                System.out.println(result);
            }
        });
        mScannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScanner.startPreview();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScanner.startPreview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScanner.releaseResources();
    }
}
