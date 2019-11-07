package com.example.hospital.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hospital.BDHelper;
import com.example.hospital.ItemFragment;
import com.example.hospital.R;

import java.util.List;

public class GalleryFragment extends Fragment {

    private EditText nombreMed,telMed,dirMed;
    private Button boton,botonClean,botonShow;
    private Spinner spin,spin2;
/*
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        //final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        /*
        View contenedor=(View)container.getParent();
        nombreMed=(EditText)contenedor.findViewById(R.id.txtNombreMedico);
        telMed=(EditText)contenedor.findViewById(R.id.txtTelefonoMedico);
        dirMed=(EditText)contenedor.findViewById(R.id.txtDirMedico);
        boton=(Button)contenedor.findViewById(R.id.btregisterMed);
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nombreMed.setText("Funciona");
            }
        });*/
        //return root;}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_gallery, container, false);
    nombreMed=(EditText)view.findViewById(R.id.txtNombreMedico);
    telMed=(EditText)view.findViewById(R.id.txtTelefonoMedico);
    dirMed=(EditText)view.findViewById(R.id.txtDirMedico);
    boton = (Button)view.findViewById(R.id.btregisterMed);
    botonClean=(Button)view.findViewById(R.id.btclear);
    //botonShow=(Button)view.findViewById(R.id.btMostrar);
    //spin=(Spinner)view.findViewById(R.id.spinner);
    spin2 = (Spinner) view.findViewById(R.id.spinnerHospital);
    final BDHelper dataBase=new BDHelper(view.getContext());

    List<String> opt=dataBase.getAllHospitales();
    ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,opt);
    spin2.setAdapter(adapter);

    boton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            String name = String.valueOf(nombreMed.getText());
            String telefono = String.valueOf(telMed.getText());
            String direccion = String.valueOf(dirMed.getText());
            String hospital=String.valueOf(spin2.getSelectedItem());
            if(name.isEmpty()||telefono.isEmpty()||direccion.isEmpty())
                Toast.makeText(view.getContext(), "Complete los Campos", Toast.LENGTH_SHORT).show();
            else{
                try {
                    dataBase.agregarDoctor(name, telefono, direccion,hospital);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(view.getContext(), "Se Agregó Correctamente", Toast.LENGTH_SHORT).show();
            }

            nombreMed.onEditorAction(EditorInfo.IME_ACTION_DONE);
            telMed.onEditorAction(EditorInfo.IME_ACTION_DONE);
            dirMed.onEditorAction(EditorInfo.IME_ACTION_DONE);

        }
    });
    botonClean.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
                nombreMed.setText("");
                telMed.setText("");
                dirMed.setText("");
                //spin.setAdapter(null);
                Toast.makeText(view.getContext(),"Campos Limpiados",Toast.LENGTH_SHORT).show();

            nombreMed.onEditorAction(EditorInfo.IME_ACTION_DONE);
            telMed.onEditorAction(EditorInfo.IME_ACTION_DONE);
            dirMed.onEditorAction(EditorInfo.IME_ACTION_DONE);
                //view.findViewById(R.layout.fragment_item);
                //FragmentTransaction transaction = getFragmentManager().beginTransaction();

        }
    });
    /*botonShow.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            List<String> opt=dataBase.getAllNombresMedicos();
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_spinner_item,opt);
            spin.setAdapter(adapter);
        }
    });*/
    return view;
    }

}