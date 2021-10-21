package com.example.myeventbus;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragmentJava extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_java, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //тут две кнопки у нас кидают событие
        view.findViewById(R.id.plus_button_java).setOnClickListener(v -> AppKt.getApp(this)
                .getEventBus().post(new PlusEvent()));

        //это не упрощенное
        view.findViewById(R.id.minus_button_java).setOnClickListener(v -> {
            AppKt.getApp(this).getEventBus().post(new MinusEvent());
        });
    }
}