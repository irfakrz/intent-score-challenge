package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import id.putraprima.skorbola.model.User;

public class MainActivity extends AppCompatActivity {
    public static final String USER_KEY = "user";
    private EditText namaHomeInput;
    private EditText namaAwayInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO
        namaHomeInput = findViewById(R.id.home_team);
        namaAwayInput = findViewById(R.id.away_team);

    }

    public void handleSubmit(View view) {
        String namaHome = namaHomeInput.getText().toString();
        String namaAway = namaAwayInput.getText().toString();

        if (namaHome.isEmpty()){
            namaHomeInput.setError("Silahkan diisi terlebih dahulu");
        } else if (namaAway.isEmpty()){
            namaAwayInput.setError("Silahkan diisi terlebih dahulu");
        } else{
            User user = new User(namaHome, namaAway,0,0);
            Intent intent = new Intent(this, MatchActivity.class);
            intent.putExtra(USER_KEY, user);
            startActivity(intent);
        }
    }
}
