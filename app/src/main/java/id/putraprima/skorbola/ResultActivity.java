package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    public static final String USER_KEY = "user";
    private TextView tampilText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tampilText = findViewById(R.id.textView3);

        //1.Menampilkan detail match sesuai data dari match activity
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            tampilText.setText(extras.getString(USER_KEY));
        }
    }
}
