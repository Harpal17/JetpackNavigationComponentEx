package com.example.jetpacknavigationcomponentex;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigDecimal;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmationFragment extends Fragment {
    private String recipientName;
    private Money money;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!=null){
            recipientName = bundle.getString("recipient");
            money = bundle.getParcelable("amount");
        }
    }

    public ConfirmationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BigDecimal amount = money.getAmount();
        String confirmationMessage = "You have sent $"+amount + " to "+recipientName;
        TextView confirmationMsgTv = view.findViewById(R.id.confirmation_message);
        confirmationMsgTv.setText(confirmationMessage);
    }
}
