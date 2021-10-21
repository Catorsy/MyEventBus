package com.example.myeventbus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import io.reactivex.disposables.Disposable;

public class SecondFragmentJava extends Fragment {
    private TextView counterTv;
    private Disposable disposable;
    private int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_java, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        counterTv = view.findViewById(R.id.counter_text_view_java);

        disposable = AppKt.getApp(this).getEventBus().get()
                .subscribe(event -> {
                    if(event instanceof PlusEvent){
                        count++;
                    }else if (event instanceof  MinusEvent) {
                        count --;
                    }
                    counterTv.setText(String.valueOf(count));
                });

    }

    @Override
    public void onDestroyView() {
        disposable.dispose();
        super.onDestroyView();
    }
}