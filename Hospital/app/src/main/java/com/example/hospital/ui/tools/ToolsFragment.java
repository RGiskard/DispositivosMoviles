package com.example.hospital.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
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

public class ToolsFragment extends Fragment {

    private Spinner spin,spinDoc;
    private Button register;
    private CalendarView calc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_tools, container, false);
        spin=(Spinner)view.findViewById(R.id.spPacientesCitas);
        spinDoc=(Spinner)view.findViewById(R.id.spMedicos);
        register=(Button)view.findViewById(R.id.btRegisterCita);
        calc=(CalendarView)view.findViewById(R.id.dateCalendar);
        final BDHelper dataBase=new BDHelper(view.getContext());
        List<String> opt=dataBase.getAllPacientes();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,opt);
        spin.setAdapter(adapter);

        List<String> optDoc=dataBase.getAllNombresMedicos();
        ArrayAdapter<String> adapterDoc=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,optDoc);
        spinDoc.setAdapter(adapterDoc);
        if(optDoc.isEmpty())
            Toast.makeText(view.getContext(), "No hay médicos disponibles", Toast.LENGTH_SHORT).show();

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = String.valueOf(spin.isSelected());
                String date=String.valueOf(calc.getDate());
                {
                    try {
                        dataBase.agregarCita(name, date);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(view.getContext(), "Se Agregó Correctamente", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }
}