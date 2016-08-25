package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Context;
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
    private int flag = 0;
    private static final String TAG = "HintActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        mHintViewer = (TextView) findViewById(R.id.hintViewer);


        mShowHintButton = (Button) findViewById(R.id.ShowHintButton);
        mShowHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 1;
                //Context context = getApplicationContext();
                mHintViewer.setText("A prime number has only two factors: 1 and the number itself!");
                Log.d(TAG, "Clicked Show Hint");
            }
        });

        Intent intentHintReturn = new Intent();
        intentHintReturn.putExtra("isSeen", flag);
        setResult(RESULT_OK, intentHintReturn);
        finish();
    }
}