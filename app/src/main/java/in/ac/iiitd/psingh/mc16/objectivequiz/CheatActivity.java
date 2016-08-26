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
    private Button mBackCheatButton;
    private String flag = "no";
    //public int isPrime =1;
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
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            message = extras.getString("EXTRA_MESSAGE");
        }

        mCheatViewer = (TextView) findViewById(R.id.CheatViewer);

        mShowAnsButton = (Button) findViewById(R.id.ShowAnsButton);
        mShowAnsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = "yes";

                if (message.equals("1")) {
                    mCheatViewer.setText("It is prime.");
                }
                else if (message.equals("0")) {
                    mCheatViewer.setText("It is not prime.");
                }

                Log.d(TAG, "Clicked Show Answer");

            }
        });

        mBackCheatButton = (Button) findViewById(R.id.BackCheatButton);
        mBackCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Back button on cheat");
                Intent intentCheatReturn = new Intent();
                intentCheatReturn.putExtra("isSeen", flag);
                setResult(RESULT_OK, intentCheatReturn);
                finish();
            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        final TextView answer = (TextView)findViewById(R.id.CheatViewer);
        CharSequence oldAns = answer.getText();
        savedInstanceState.putCharSequence("savedText", oldAns);
        Log.i(TAG, "Inside onSaveInstance");
    }

    //Restoring the state of the app when the screen is rotated or when the app is resumed. onRestoreInstanceState is called before the onResume method.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        final TextView ques = (TextView)findViewById(R.id.CheatViewer);
        CharSequence oldAns = savedInstanceState.getCharSequence("savedText");
        ques.setText(oldAns);
        Log.i(TAG, "Inside onRestoreInstance");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnResume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }
}
