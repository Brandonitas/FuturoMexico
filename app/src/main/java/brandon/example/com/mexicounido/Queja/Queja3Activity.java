package brandon.example.com.mexicounido.Queja;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import brandon.example.com.mexicounido.OrganizacionesActivity;
import brandon.example.com.mexicounido.R;

public class Queja3Activity extends AppCompatActivity {

    EditText editText;
    Button button;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queja3_login);

        final Bundle bundle = getIntent().getExtras();
        final String date= bundle.getString("date");


        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mensajeRef = ref.child(date);

        Log.e("Mylog2",date);

        editText = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comentarios = editText.getText().toString();
                
                if(comentarios.isEmpty()){
                    Toast.makeText(Queja3Activity.this, "Debes explicar el problema", Toast.LENGTH_SHORT).show();
                }else {

                    mensajeRef.push().setValue(comentarios);
                    Intent intent = new Intent(Queja3Activity.this, OrganizacionesActivity.class);
                    intent.putExtra("date", date);
                    startActivity(intent);
                }
            }
        });


    }
}
