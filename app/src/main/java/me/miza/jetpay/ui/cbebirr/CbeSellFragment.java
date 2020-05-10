package me.miza.jetpay.ui.cbebirr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.zxing.qrcode.QRCodeWriter;
import com.hover.sdk.api.HoverParameters;

import net.glxn.qrgen.android.QRCode;

import org.json.JSONObject;

import me.miza.jetpay.R;

public class CbeSellFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_merchant, container, false);

        EditText mAmount, mPhoneNumber;
        MaterialButton mSend;
        ImageView mqrview;
        mqrview = root.findViewById(R.id.merchant_qr);
        mAmount = root.findViewById(R.id.text_amount);
        mAmount.setInputType(InputType.TYPE_CLASS_NUMBER);

        mPhoneNumber = root.findViewById(R.id.text_receiver_phone);
        mPhoneNumber.setInputType(InputType.TYPE_CLASS_PHONE);

        mSend = root.findViewById(R.id.button_cbe_send);
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = mAmount.getText().toString();
                String phone = mPhoneNumber.getText().toString();
                Bitmap payment = QRCode.from(amount + " " + phone).bitmap();
                mqrview.setImageBitmap(payment);

            }
        });
        return root;
    }
}
