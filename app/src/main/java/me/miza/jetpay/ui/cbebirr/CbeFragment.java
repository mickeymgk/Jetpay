package me.miza.jetpay.ui.cbebirr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.hover.sdk.api.HoverParameters;
import com.hover.sdk.parsers.HoverParser;

import net.glxn.qrgen.android.QRCode;

import me.miza.jetpay.MainActivity;
import me.miza.jetpay.R;
import me.miza.jetpay.view.ActionView;

public class CbeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cbe_choice, container, false);
        ActionView mCheckBalance, mSendMoney, mSellItem;
        mCheckBalance = root.findViewById(R.id.cbe_check_balance);
        mCheckBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new HoverParameters.Builder(getContext())
                            .request("d13e776c") // Add your action ID here
                            .style(R.style.AppTheme)
                            .setHeader(getResources().getString(R.string.checking_balance))
                            .buildIntent();
                    startActivityForResult(i, 0);
            }
        });
        mSendMoney = root.findViewById(R.id.cbe_send_money);
        mSendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Navigation.findNavController(view).navigate(R.id.action_nav_cbe_to_nav_cbe_send);
            }
        });
        mSellItem = root.findViewById(R.id.cbe_sell_item);
        mSellItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_cbe_to_nav_cbe_sell);
            }
        });
        return root;
    }
}
