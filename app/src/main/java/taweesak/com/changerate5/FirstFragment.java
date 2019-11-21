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
    TextView txtView, tvChoice;
    ImageView mvChoice;

    RadioGroup radioGroup;
    RadioButton radioButton;

    int selectId, choice;

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
        selectId = radioGroup.getCheckedRadioButtonId();
        radioButton = getActivity().findViewById(selectId);
        switch (radioButton.getId()) {
            case R.id.zeroText:
                choice = 0;
                break;
            case R.id.oneText:
                choice = 1;
                break;
            case R.id.twotext:
                choice = 2;
                break;
        }

        try {
            double valueRate = Double.parseDouble(editText.getText().toString());
            if (valueRate > 0) {
                Model model = new Model(choice, valueRate);
                txtView.setText("rate = " + model.getRates());
                tvChoice.setText(model.getRateText());
                Toast.makeText(getActivity(), "Message " + choice, Toast.LENGTH_LONG).show();

                changeFlag(model);

            } else {
                txtView.setText("ค่าที่ใส่ต้องมากกว่า 0 เท่านั้น");
                tvChoice.setText("");
                mvChoice.setImageResource(R.drawable.my_image2);
            }
        } catch (NumberFormatException e) {
            txtView.setText("ค่าที่ใส่ต้องเป็นตัวเลข เท่านั้น");
            tvChoice.setText("");
            mvChoice.setImageResource(R.drawable.my_image2);
        }

    }

    private void changeFlag(Model model) {
        switch (model.getChoice()) {
            case 0:
                mvChoice.setImageResource(R.drawable.usa);
                break;
            case 1:
                mvChoice.setImageResource(R.drawable.japan);
                break;
            case 2:
                mvChoice.setImageResource(R.drawable.europe);
                break;
        }
    }

    private void findView(View view) {
        btn = view.findViewById(R.id.btn);
        editText = view.findViewById(R.id.editText);
        txtView = view.findViewById(R.id.txtView);
        tvChoice = view.findViewById(R.id.tvChoice);
        mvChoice = view.findViewById(R.id.mvChoice);
        radioGroup = (RadioGroup) view.findViewById(R.id.raidoButton);

        /*selectId =radioGroup.getCheckedRadioButtonId();
        radioButton = view.findViewById(selectId);*/
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
