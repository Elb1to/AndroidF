package gg.rubit.SelectConversation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gg.rubit.R;
import gg.rubit.components.lessons.ConversationActivity;

public class SelectConversation extends AppCompatActivity {


    Spinner spnSeleccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        inicializarcontroles();
    }

    public void inicializarcontroles() {



        List<String> list = new ArrayList<>();
        list.add("Desarrollo agil");
        list.add("Programacion extrema");
        list.add("Modelo de analisis");
        list.add("Kanban");
        list.add("Desarrollo de software");
        list.add("Lenguajes");

        spnSeleccion = (Spinner) findViewById(R.id.spnSel);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSeleccion.setAdapter(arrayAdapter);

    }

    public void itemSelected(View v) {

        Intent intent = new Intent(this, ConversationActivity.class);
        String sel="0";

        switch (spnSeleccion.getSelectedItem().toString()) {
            case "Desarrollo agil":
                sel = "1";
                intent.putExtra("sel", sel);
                break;
            case "Programacion extrema":
                sel = "2";
                intent.putExtra("sel", sel);
                break;
            case "Modelo de analisis":
                sel = "3";
                intent.putExtra("sel", sel);
                break;
            case "Kanban":
                sel = "5";
                intent.putExtra("sel", sel);
                break;
            case "Desarrollo de software":
                sel = "6";
                intent.putExtra("sel", sel);
                break;
            case "Lenguajes":
                sel = "7";
                intent.putExtra("sel", sel);
                break;
        }
        startActivity(intent);
    }


}