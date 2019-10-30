package com.example.hospital.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hospital.BDHelper;
import com.example.hospital.R;

import java.util.List;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;
    private Spinner spiner,spinnerDoctores;
    private Button butonSearch;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View view = inflater.inflate(R.layout.fragment_share, container, false);
        final BDHelper dataBase=new BDHelper(view.getContext());
        spiner =(Spinner)view.findViewById(R.id.spHospitalesConsulta);
        butonSearch=(Button)view.findViewById(R.id.btConsultar);
        spinnerDoctores=(Spinner)view.findViewById(R.id.spShowDoctores);
        List<String> opt=dataBase.getAllHospitales();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,opt);
        spiner.setAdapter(adapter);
        butonSearch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String hospital=String.valueOf(spiner.getSelectedItem());
                        List<String> doctors=dataBase.getDoctorsByHospital(hospital);
                        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,doctors);
                        spinnerDoctores.setAdapter(adapter);
                    }
                }
        );
        return view;
    }
}