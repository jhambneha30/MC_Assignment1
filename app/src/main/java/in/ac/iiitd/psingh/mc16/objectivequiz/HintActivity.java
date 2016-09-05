package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HintActivity extends AppCompatActivity {

    private Button mShowHintButton;
    private TextView mHintViewer;
    private Button mBackHintButton;
    private String flag = "no";
    private static final String TAG = "HintActivity";
    //The following function is called when the hint activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        //Setting the content to be shown when the "Show Hint" button is clicked
        mHintViewer = (TextView) findViewById(R.id.HintViewer);

        mShowHintButton = (Button) findViewById(R.id.ShowHintButton);
        mShowHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = "yes";
                //Context context = getApplicationContext();
                mHintViewer.setText("A prime number has only two factors: 1 and the number itself!");
                Log.d(TAG, "Clicked Show Hint");

            }
        });
        //Back button to go back to the main Quiz activity
        mBackHintButton = (Button) findViewById(R.id.BackHintButton);
        mBackHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Back button on hint");
                Intent intentHintReturn = new Intent();
                intentHintReturn.putExtra("isSeen", flag);
                setResult(RESULT_OK, intentHintReturn);
                finish();
            }
        });


    }
    //Saving instance so that app is not reset on screen rotation
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        final TextView ques = (TextView)findViewById(R.id.HintViewer);
        CharSequence oldHint = ques.getText();
        savedInstanceState.putCharSequence("savedText", oldHint);
        savedInstanceState.putCharSequence("savedFlag", flag);
        Log.i(TAG, "Inside onSaveInstance");
    }

    //Restoring the state of the app when the screen is rotated or when the app is resumed. onRestoreInstanceState is called before the onResume method.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        final TextView ques = (TextView)findViewById(R.id.HintViewer);
        CharSequence oldHint = savedInstanceState.getCharSequence("savedText");
        CharSequence oldFlag = savedInstanceState.getCharSequence("savedFlag");
        ques.setText(oldHint);
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