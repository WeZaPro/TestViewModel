package com.taweesak.testviewmodel;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements FileView{

    TextView textView;
    Button button;
    EditText editText;
    AndroidViewModel androidViewModel;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        androidViewModel = ViewModelProviders.of(getActivity()).get(AndroidViewModel.class);

        fileViewBy(view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                androidViewModel.setString(editText.getText().toString());

            }
        });

        androidViewModel.getData().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        return view;
    }


    @Override
    public void fileViewBy(View view) {
        textView = view.findViewById(R.id.textView);
        button = view.findViewById(R.id.button);
        editText = view.findViewById(R.id.editText);
    }
}
