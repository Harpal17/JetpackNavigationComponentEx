package com.example.jetpacknavigationcomponentex;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;

import java.math.BigDecimal;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpecifyAmountFragment extends Fragment implements View.OnClickListener {
    private NavController mNavController;
    private String recipient;
    private TextInputEditText inputAmountET;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            recipient = bundle.getString("recipient");
        }
    }

    public SpecifyAmountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        view.findViewById(R.id.send_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);
        inputAmountET = view.findViewById(R.id.input_amount);
        TextView recipientNameTV = view.findViewById(R.id.recipient);
        recipientNameTV.setText("Sending money to " + recipient);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_btn:
                String inputAmount = inputAmountET.getText().toString();
                if (!TextUtils.isEmpty(inputAmount)) {
                    Money money = new Money();
                    money.setAmount(new BigDecimal(inputAmount));
                    Bundle bundle = new Bundle();
                    bundle.putString("recipient", recipient);
                    bundle.putParcelable("amount", money);
                    if (mNavController != null) {
                        mNavController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle);
                    }
                } else {
                    inputAmountET.setError("Please enter amount");
                }

                break;
            case R.id.cancel_btn:
                requireActivity().onBackPressed();
                break;

        }
    }
}
