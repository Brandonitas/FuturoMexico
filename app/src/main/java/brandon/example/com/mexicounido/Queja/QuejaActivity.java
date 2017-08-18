package brandon.example.com.mexicounido.Queja;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v4.util.TimeUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

import brandon.example.com.mexicounido.R;

public class QuejaActivity extends AppCompatActivity implements View.OnClickListener{


    private Button button, btn1, btn2, btn3, btn4, btn5, btn6;
    private String categoria = "";

    Date currentTime = Calendar.getInstance().getTime();

    String date = ""+currentTime;

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mensajeRef = ref.child(date);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queja);

        Log.e("Mylog",date);





        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String mensaje =  editText.getText().toString();
                mensajeRef.push().setValue(categoria);

                if(categoria.isEmpty()){
                    Toast.makeText(QuejaActivity.this, "Debes de seleccionar una categoría", Toast.LENGTH_SHORT).show();
                }else {

                    Intent intent = new Intent(QuejaActivity.this, Queja2Activity.class);
                    intent.putExtra("date", date);
                    startActivity(intent);
                    //mensajeRef.setValue(mensaje);
                }
            }
        });

        btn1 = (Button) findViewById(R.id.buttonSalud);
        btn2 = (Button) findViewById(R.id.buttonTrasnporte);
        btn3 = (Button) findViewById(R.id.buttonSeguridad);
        btn4 = (Button) findViewById(R.id.buttonMedio);
        btn5 = (Button) findViewById(R.id.buttonEducacion);
        btn6 = (Button) findViewById(R.id.buttonEnergia);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mensajeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               // String value = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSalud:
                btn1.setBackgroundResource(R.color.azulacua);
                categoria = "Salud";
                break;
            case R.id.buttonTrasnporte:
                btn2.setBackgroundResource(R.color.azulacua);
                categoria = "Transporte";
                break;
            case R.id.buttonSeguridad:
                btn3.setBackgroundResource(R.color.azulacua);
                categoria = "Seguridad";
                break;
            case R.id.buttonMedio:
                btn4.setBackgroundResource(R.color.azulacua);
                categoria = "Medio";
                break;
            case R.id.buttonEducacion:
                btn5.setBackgroundResource(R.color.azulacua);
                categoria = "Educacion";
                break;
            case R.id.buttonEnergia:
                btn6.setBackgroundResource(R.color.azulacua);
                categoria = "Energia";
                break;
        }
    }
}
