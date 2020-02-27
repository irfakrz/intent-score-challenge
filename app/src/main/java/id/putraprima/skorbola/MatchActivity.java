package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import id.putraprima.skorbola.model.User;

public class MatchActivity extends AppCompatActivity {
    public static final String USER_KEY = "user";
    private static final int SCORER_ACTIVITY_REQUEST_CODE = 0;
    private String namaSkorer = "";
    public String pemenang;
    private TextView homeScorerText;
    private TextView awayScorerText;
    private TextView namaHomeText;
    private TextView namaAwayText;
    private TextView skorHome;
    private TextView skorAway;
    private int sHome = 0;
    private int sAway = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        //TODO
        namaHomeText = findViewById(R.id.txt_home);
        namaAwayText = findViewById(R.id.txt_away);
        skorHome = findViewById(R.id.score_home);
        skorAway = findViewById(R.id.score_away);
        homeScorerText = findViewById(R.id.home_scorer);
        awayScorerText = findViewById(R.id.away_scorer);
        skorHome.setText("0");
        skorAway.setText("0");

        //1.Menampilkan detail match sesuai data dari main activity
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            User data = getIntent().getParcelableExtra(USER_KEY);
            namaHomeText.setText(data.getNamaHome());
            namaAwayText.setText(data.getNamaAway());
        }
    }

    public void addSkorHome(View View){
        Intent intent = new Intent(this, ScorerActivity.class);
        startActivityForResult(intent, 1);
    }

    public void addSkorAway(View View){
        Intent intent = new Intent(this, ScorerActivity.class);
        startActivityForResult(intent, 2);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                // Get String data from Intent
                namaSkorer += data.getStringExtra("keyName");
                if(namaSkorer != null){
                    sHome++;
                    skorHome.setText(String.valueOf(sHome));
                    homeScorerText = findViewById(R.id.home_scorer);
                    homeScorerText.setText(namaSkorer+"\n");
                }
            }
        }
        else if(requestCode == 2){
            if(resultCode == RESULT_OK){

                // Get String data from Intent
                namaSkorer += data.getStringExtra("keyName");
                if(namaSkorer != null){
                    sAway++;
                    skorAway.setText(String.valueOf(sAway));
                    awayScorerText = findViewById(R.id.away_scorer);
                    awayScorerText.setText(namaSkorer+"\n");
                }
            }
        }
    }

    public void cekHasil(View View){

        if(sHome > sAway){
            pemenang = "The Winner is "+namaHomeText.getText().toString();
        }
        else if(sAway > sHome){
            pemenang = "The Winner is"+namaAwayText.getText().toString();
        }
        else{
            pemenang = "DRAW";
        }
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(USER_KEY, pemenang);
        startActivity(intent);
    }
}
