package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast toast = Toast.makeText(getContext(), "Вызван onCreate",
                Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCity1();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast toast = Toast.makeText(getContext(), "Вызван onViewCreated",
                Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Toast toast = Toast.makeText(getContext(), "Вызван onViewStateRestored",
                Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast toast = Toast.makeText(getContext(), "Вызван onStart",
                Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast toast = Toast.makeText(getContext(), "Вызван onResume",
                Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast toast = Toast.makeText(getContext(), "Вызван onSaveInstanceState",
                Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast toast = Toast.makeText(getContext(), "Вызван onPause",
                Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(getContext(), "Вызван onStop",
                Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast toast = Toast.makeText(getContext(), "Вызван onDestroyView",
                Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast toast = Toast.makeText(getContext(), "Вызван onDestroy",
                Toast.LENGTH_LONG);
        toast.show();
    }


    public void sendCity1(){
        EditText cityText = getView().findViewById(R.id.input_name);
        String city = cityText.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("city" , city);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, secondFragment);
        fragmentTransaction.commit();
    }
}