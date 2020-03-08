package com.example.jetpacknavigationcomponentex;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseRecipientFragment extends Fragment implements View.OnClickListener {
    private NavController mNavController;
    private TextInputEditText input_recipient;

    public ChooseRecipientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_receipent, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        view.findViewById(R.id.next_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);
        input_recipient = view.findViewById(R.id.input_recipient);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_btn:
                String inputStr = input_recipient.getText().toString();
                if(!TextUtils.isEmpty(inputStr)){
                    Bundle bundle = new Bundle();
                    bundle.putString("recipient", inputStr);
                    if (mNavController != null) {
                        mNavController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle);
                    }
                }else{
                    input_recipient.setError("Please enter recipient name");
                    input_recipient.setFocusable(true);
                }
                break;
            case R.id.cancel_btn:
                requireActivity().onBackPressed();
                break;
        }

    }
}
