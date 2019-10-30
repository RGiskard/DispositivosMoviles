package com.example.hospital.ui.tools;

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

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    private Spinner spin;
    private Button register;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View view = inflater.inflate(R.layout.fragment_tools, container, false);
        spin=(Spinner)view.findViewById(R.id.spPacientesCitas);
        register=(Button)view.findViewById(R.id.btRegisterCita);
        final BDHelper dataBase=new BDHelper(view.getContext());
        List<String> opt=dataBase.getAllPacientes();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,opt);
        spin.setAdapter(adapter);

        return view;
    }
}