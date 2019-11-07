package com.example.hospital.ui.send;

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
import com.example.hospital.MedicoDetails;
import com.example.hospital.R;

import java.util.ArrayList;
import java.util.List;

public class SendFragment extends Fragment {

    private Spinner spinnerDoctores,spinnnerPacientes,spcitas;
    private Button butonMedicos,butonPacientes;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_send, container, false);
        spinnerDoctores=(Spinner)view.findViewById(R.id.spMedicosConsultar);
        spinnnerPacientes=(Spinner)view.findViewById(R.id.spPacienteConsultar);
        spcitas=(Spinner)view.findViewById(R.id.spCitasFinal);
        butonMedicos=(Button)view.findViewById(R.id.btconsultarMedicosAll);
        butonPacientes=(Button)view.findViewById(R.id.btconsultarPacienteAll);
        final BDHelper dataBase=new BDHelper(view.getContext());
        List<String> medicuchos=dataBase.getAllNombresMedicos();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,medicuchos);
        spinnerDoctores.setAdapter(adapter);
        butonMedicos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String medico=String.valueOf(spinnerDoctores.getSelectedItem());
                List<String> doctors=dataBase.getPacientesByDoctor(medico);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,doctors);
                if(doctors.isEmpty())
                    Toast.makeText(view.getContext(), "No se encontraron ocurrencias", Toast.LENGTH_SHORT).show();
                //spinnerDoctores.setAdapter(adapter);
                spinnnerPacientes.setAdapter(adapter);

            }
        });
        butonPacientes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String paciente=String.valueOf(spinnnerPacientes.getSelectedItem());
                List<String> citas=dataBase.getCitasByPaciente(paciente);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,citas);
                if(citas.isEmpty())
                    Toast.makeText(view.getContext(), "No se encontraron ocurrencias", Toast.LENGTH_SHORT).show();
                //spinnerDoctores.setAdapter(adapter);
                spcitas.setAdapter(adapter);

            }
        });
        return view;
    }
}