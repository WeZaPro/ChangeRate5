package taweesak.com.changerate5;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment implements View.OnClickListener {

    Callback mCallback;

    Button btn;
    EditText editText;
    TextView txtView,tvChoice;
    ImageView mvChoice;

    RadioGroup radioGroup;
    RadioButton radioButton;

    String str;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (Callback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement Callback");
        }
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        view.findViewById(R.id.btnNextPage).setOnClickListener(this);
        view.findViewById(R.id.btn).setOnClickListener(this);

        findView(view);
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertValue();
            }
        });*/

        return view;
    }

    private void convertValue() {
        str = editText.getText().toString();
        Toast.makeText(getActivity(),"Message "+str ,Toast.LENGTH_LONG).show();
        txtView.setText(str);
    }

    private void findView(View view) {
        btn = view.findViewById(R.id.btn);
        editText = view.findViewById(R.id.editText);
        txtView = view.findViewById(R.id.txtView);
        tvChoice = view.findViewById(R.id.tvChoice);
        mvChoice = view.findViewById(R.id.mvChoice);
        radioGroup = (RadioGroup)view.findViewById(R.id.raidoButton);
    }


    @Override
    public void onClick(View view) {
        Fragment fragment;
        switch (view.getId()) {
            case R.id.btnNextPage:
                fragment = new SecondFragment();
                mCallback.someEvent(fragment);
                break;
            case R.id.btn:
                convertValue();
                break;
        }

    }
}
