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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import brandon.example.com.mexicounido.R;

public class Queja2Activity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queja2);

        final Bundle bundle = getIntent().getExtras();
        final String date= bundle.getString("date");


        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mensajeRef = ref.child(date);

        Log.e("Mylog2",date);



        editText = (EditText) findViewById(R.id.editText2);

        button = (Button) findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dirigido = editText.getText().toString();
                mensajeRef.push().setValue(dirigido);

                if(dirigido.isEmpty()){
                    Toast.makeText(Queja2Activity.this, "Debes ingresar el destinatario", Toast.LENGTH_SHORT).show();
                }else {

                    Intent intent = new Intent(Queja2Activity.this, Queja3Activity.class);
                    intent.putExtra("date", date);
                    startActivity(intent);
                }

            }
        });

    }
}
