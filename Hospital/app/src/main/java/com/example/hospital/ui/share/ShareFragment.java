package com.example.hospital.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hospital.BDHelper;
import com.example.hospital.R;

import java.util.List;

public class ShareFragment extends Fragment {

    private Spinner spiner,spinnerDoctores,spinnnerPacientes;
    private Button butonSearch,butonConsultar;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share, container, false);
        final BDHelper dataBase=new BDHelper(view.getContext());
        spiner =(Spinner)view.findViewById(R.id.spHospitalesConsulta);
        butonSearch=(Button)view.findViewById(R.id.btConsultar);
        spinnerDoctores=(Spinner)view.findViewById(R.id.spShowDoctores);
        spinnnerPacientes=(Spinner)view.findViewById(R.id.spMostrarPaciente);
        List<String> opt=dataBase.getAllHospitales();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,opt);
        butonConsultar=(Button)view.findViewById(R.id.btCOnsultarPaciente);
        spiner.setAdapter(adapter);
        butonSearch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String hospital=String.valueOf(spiner.getSelectedItem());
                        List<String> doctors=dataBase.getDoctorsByHospital(hospital);
                        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,doctors);
                        if(doctors.isEmpty())
                            Toast.makeText(view.getContext(), "No se encontraron ocurrencias", Toast.LENGTH_SHORT).show();
                        spinnerDoctores.setAdapter(adapter);
                        spinnnerPacientes.setAdapter(null);

                    }
                }
        );
        butonConsultar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String doctor=String.valueOf(spinnerDoctores.getSelectedItem());
                        List<String> pacientes=dataBase.getPacientesByDoctor(doctor);
                        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,pacientes);
                        spinnnerPacientes.setAdapter(adapter);
                        if(pacientes.isEmpty())
                            Toast.makeText(view.getContext(), "No se encontraron ocurrencias", Toast.LENGTH_SHORT).show();

                    }
                }
        );
        return view;
    }
}