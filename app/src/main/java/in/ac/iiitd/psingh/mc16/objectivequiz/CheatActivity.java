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
    public int isPrime =1;
    private static final String TAG = "HintActivity";
    public static String ans = "";
    public static String message = "";

   // TextView textView = new TextView(this);
//    textView.setTextSize(40);
//    textView.setText(message);
//    ViewGroup layout = (ViewGroup) findViewById(R.id.activity_hint);
//    layout.addView(textView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        Intent intent = getIntent();
        message = intent.getStringExtra(QuizActivity.EXTRA_MESSAGE);
        int number = Integer.parseInt(message);
        for(int i=2; i<=number/2; i++)
        {
            if(number % i == 0){
                isPrime=0;
            }
        }
        mCheatViewer = (TextView) findViewById(R.id.cheatViewer);


        mShowAnsButton = (Button) findViewById(R.id.ShowAnsButton);
        mShowAnsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 2;
                //Context context = getApplicationContext();
                if(isPrime==1)
                {
                    ans = message + " is prime.";
                }
                else if(isPrime==0)
                {
                    ans = message + " is not prime.";
                }
                mCheatViewer.setText(ans);
                Log.d(TAG, "Clicked Show Hint");
            }
        });

        Intent intentHintReturn = new Intent();
        intentHintReturn.putExtra("isSeen", flag);
        setResult(RESULT_OK, intentHintReturn);
        finish();
    }
}
