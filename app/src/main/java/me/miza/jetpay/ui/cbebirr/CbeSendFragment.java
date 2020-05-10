package me.miza.jetpay.ui.cbebirr;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.button.MaterialButton;
import com.hover.sdk.api.HoverParameters;

import me.miza.jetpay.R;
import me.miza.jetpay.view.ActionView;

public class CbeSendFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cbe_send, container, false);

        EditText mAmount, mPhoneNumber;
        MaterialButton mSend;
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
                    Intent i = new HoverParameters.Builder(getContext())
                            .request("c49b6e17")
                            .extra("PhoneNo", phone)
                            .extra("Amount",amount)
                            .style(R.style.AppTheme)
                            .setHeader(getResources().getString(R.string.processing_request))
                            .buildIntent();
                    startActivityForResult(i, 0);
            }
        });
        return root;
    }
}
