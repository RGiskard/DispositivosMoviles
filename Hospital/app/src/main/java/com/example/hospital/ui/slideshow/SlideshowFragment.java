package com.example.hospital.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

public class SlideshowFragment extends Fragment {

    private EditText nombrePaciente,telPaciente,dirPaciente;
    private Button botonRegistrar,botonClean,botonShow;
    private Spinner spin;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
        nombrePaciente=(EditText)view.findViewById(R.id.txtNombrePaciente);
        telPaciente=(EditText)view.findViewById(R.id.txtTelefonoPaciente);
        dirPaciente=(EditText)view.findViewById(R.id.txtDireccionPaciente);
        botonRegistrar = (Button)view.findViewById(R.id.btRegistrarPaciente);
        botonClean=(Button)view.findViewById(R.id.btCleanPaciente);
        spin=(Spinner) view.findViewById(R.id.spPaciente);
        final BDHelper dataBase=new BDHelper(view.getContext());
        List<String> opt=dataBase.getAllNombresMedicos();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,opt);
        spin.setAdapter(adapter);
        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = String.valueOf(nombrePaciente.getText());
                String telefono = String.valueOf(telPaciente.getText());
                String direccion = String.valueOf(dirPaciente.getText());
                String hospital=String.valueOf(spin.getSelectedItem());


                if(name.isEmpty()||direccion.isEmpty()) {
                    Toast.makeText(view.getContext(), "Complete los Campos", Toast.LENGTH_SHORT).show();

                }else{
                    try {
                        dataBase.agregarPaciente(name, telefono, direccion,hospital);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(view.getContext(), "Se Agregó Correctamente", Toast.LENGTH_SHORT).show();
                }
                nombrePaciente.onEditorAction(EditorInfo.IME_ACTION_DONE);
                telPaciente.onEditorAction(EditorInfo.IME_ACTION_DONE);
                dirPaciente.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        botonClean.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nombrePaciente.setText("");
                telPaciente.setText("");
                dirPaciente.setText("");
                //spin.setAdapter(null);
                Toast.makeText(view.getContext(),"Campos Limpiados",Toast.LENGTH_SHORT).show();
                //view.findViewById(R.layout.fragment_item);
                //FragmentTransaction transaction = getFragmentManager().beginTransaction();
                nombrePaciente.onEditorAction(EditorInfo.IME_ACTION_DONE);
                telPaciente.onEditorAction(EditorInfo.IME_ACTION_DONE);
                dirPaciente.onEditorAction(EditorInfo.IME_ACTION_DONE);

            }
        });
        return view;
    }
}