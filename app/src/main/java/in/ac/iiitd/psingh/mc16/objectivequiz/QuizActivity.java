package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import java.util.Random;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mTextViewer;
    //Creating the random object to generate the random prime number when a new question is created.
    private Random r = new Random();
    private String newQuestion;
    private int num;
    private static final String TAG = "QuizActivity";
    int flag=0;

    //Functionality of the app when the app is created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        flag=0;
        newQuestion = createQuestion();
        mTextViewer = (TextView) findViewById(R.id.textViewer);
        mTextViewer.setText(newQuestion);

        //Functionality for yes button
        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                flag=1;
                Context context = getApplicationContext();
                if(checkPrime(num))
                {
                    Toast toast = Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 65);
                }
                else
                {
                    Toast toast = Toast.makeText(context, "Incorrect!!", Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 65);
                }
                Log.d(TAG, "Clicked True");
            }
        });

        //Functionality for No button
        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                flag=1;
                Context context = getApplicationContext();
                if(!checkPrime(num))
                {
                    Toast toast = Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 65);
                }
                else
                {
                    Toast toast = Toast.makeText(context, "Incorrect!!", Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 65);
                }
                Log.d(TAG, "Clicked False");
            }
        });

        //Functionality for next button
        mNextButton = (Button) findViewById(R.id.NextButton);
        mTextViewer = (TextView) findViewById(R.id.textViewer);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(flag==0)
                {
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Previous question was unanswered!", Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 65);
                }
                flag=0;
                newQuestion = createQuestion();
                mTextViewer.setText(newQuestion);
                Log.d(TAG, "Clicked Next");
            }

        });

    }

    //Method to check if the number is prime
    public boolean checkPrime(int number){
        for(int i=2; i<=number/2; i++)
        {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    //Method to create new question
    private String createQuestion(){
        num = r.nextInt((999) + 1);
        newQuestion = "Is " + num + " a prime number?";
        return newQuestion;
    }

    //Saving the state of the app so that it can be restored when the screen is rotated or if the app is resumed.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
//        savedInstanceState.putInt(NUM, num);
        final TextView ques = (TextView)findViewById(R.id.textViewer);
        CharSequence oldQues = ques.getText();
        savedInstanceState.putCharSequence("savedText", oldQues);

        Log.i(TAG, "Inside onSaveInstance");
    }

    //Restoring the state of the app when the screen is rotated or when the app is resumed. onRestoreInstanceState is called before the onResume method.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
//        num=savedInstanceState.getInt(NUM);
        final TextView ques = (TextView)findViewById(R.id.textViewer);
        CharSequence oldQues = savedInstanceState.getCharSequence("savedText");
        ques.setText(oldQues);
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