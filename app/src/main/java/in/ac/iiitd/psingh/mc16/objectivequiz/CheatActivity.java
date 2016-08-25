package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private Button mShowAnsButton;
    private TextView mCheatViewer;
    private int flag = 0;
    private static final String TAG = "HintActivity";

    TextView textView = new TextView(this);
//    textView.setTextSize(40);
//    textView.setText(message);
//    ViewGroup layout = (ViewGroup) findViewById(R.id.activity_hint);
//    layout.addView(textView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        Intent intent = getIntent();
        String message = intent.getStringExtra(QuizActivity.EXTRA_MESSAGE);

        mCheatViewer = (TextView) findViewById(R.id.cheatViewer);


        mShowAnsButton = (Button) findViewById(R.id.ShowAnsButton);
        mShowAnsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 1;
                //Context context = getApplicationContext();
                mCheatViewer.setText("A prime number has only two factors: 1 and the number itself!");
                Log.d(TAG, "Clicked Show Hint");
            }
        });

        Intent intentHintReturn = new Intent();
        intentHintReturn.putExtra("isSeen", flag);
        setResult(RESULT_OK, intentHintReturn);
        finish();
    }
}
