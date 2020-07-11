package idat.edu.pe.appfragmentmenu.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import idat.edu.pe.appfragmentmenu.R;


public class CompartirFragment extends Fragment {
    private TextInputEditText etnota1, etnota2, etnota3, etnota4;
    private Button btncalcular;


    public CompartirFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compartir, container, false);
        etnota1 = view.findViewById(R.id.etnota1);
        etnota2 = view.findViewById(R.id.etnota2);
        etnota3 = view.findViewById(R.id.etnota3);
        etnota4 = view.findViewById(R.id.etnota4);
        btncalcular = view.findViewById(R.id.btncalcular);
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clic en el boton calcular",
                        Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
