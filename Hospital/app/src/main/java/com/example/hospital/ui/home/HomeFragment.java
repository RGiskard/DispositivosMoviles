package com.example.hospital.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hospital.BDHelper;
import com.example.hospital.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private EditText nombreHos,dirHos;
    private Button register,botonClean,botonShow;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        nombreHos=(EditText)view.findViewById(R.id.txtnameHospital);
        dirHos=(EditText)view.findViewById(R.id.txtdirhospital);
        register = (Button)view.findViewById(R.id.btRegisterHos);
        final BDHelper dataBase=new BDHelper(view.getContext());
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = String.valueOf(nombreHos.getText());
                        String direccion = String.valueOf(dirHos.getText());
                        if(name.isEmpty()||direccion.isEmpty())
                            Toast.makeText(view.getContext(), "Complete los Campos", Toast.LENGTH_SHORT).show();
                        else{
                            try {
                                dataBase.agregarHospital(name,direccion);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(view.getContext(), "Se Agregó Correctamente", Toast.LENGTH_SHORT).show();
                        }


                    }
                }
        );
        return view;
    }
}