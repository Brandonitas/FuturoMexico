package brandon.example.com.mexicounido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrganizacionesActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;

    ImageView img1, img2, img3, img4, img5, img6;

    String organizacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizaciones);
        button = (Button) findViewById(R.id.button5);

        final Bundle bundle = getIntent().getExtras();
        final String date= bundle.getString("date");


        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mensajeRef = ref.child(date);


        img1 = (ImageView) findViewById(R.id.imageView);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        img6 = (ImageView) findViewById(R.id.imageView10);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);

        Log.e("Mylog2",date);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensajeRef.push().setValue(organizacion);
                Intent intent = new Intent(OrganizacionesActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView:
                img1.setColorFilter(R.color.blanco);
                organizacion = "Caminos y puentes";
                break;
            case R.id.imageView2:
                img2.setColorFilter(R.color.amarillo);
                organizacion = "Cofepris";
                break;
            case R.id.imageView3:
                img3.setColorFilter(R.color.amarillo);
                organizacion = "CFE";
                break;
            case R.id.imageView4:
                img4.setColorFilter(R.color.amarillo);
                organizacion = "Sistema de aguas";
                break;
            case R.id.imageView5:
                img5.setColorFilter(R.color.amarillo);
                organizacion = "Teleton";
                break;
            case R.id.imageView10:
                img6.setColorFilter(R.color.amarillo);
                organizacion = "ASEA";
                break;
        }
    }
}
