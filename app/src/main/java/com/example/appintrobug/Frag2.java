package com.example.appintrobug;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.appintro.SlideBackgroundColorHolder;
import com.github.appintro.SlidePolicy;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag2 extends Fragment implements SlideBackgroundColorHolder, SlidePolicy {

    private static final String ARG_COLOR_INT = "COLOR_INT";
    private int originalColor = 0;
    private ConstraintLayout background = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        originalColor = getArguments().getInt(ARG_COLOR_INT);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.teacher_or_student_slide_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        background = view.findViewById(R.id.layout1);
    }

    public static Frag2 newInstance(@ColorInt int originalColor) {
        Frag2 newFragment = new Frag2();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR_INT, originalColor);
        newFragment.setArguments(args);
        return newFragment;
    }

    @Override
    public int getDefaultBackgroundColor() {
        return originalColor;
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        background.setBackgroundColor(backgroundColor);
    }


    @Override
    public boolean isPolicyRespected() {
        return false;
    }

    @Override
    public void onUserIllegallyRequestedNextPage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Please Select  an option");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();

    }
}