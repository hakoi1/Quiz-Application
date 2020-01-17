package hktechware.com.testyourbestv101;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class Result extends Activity implements AdapterView.OnItemSelectedListener {
    private TextView resultScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button selectquiz=findViewById(R.id.button_start_app);
        Button endApp=findViewById(R.id.button_exit_app);
                                              selectquiz.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View v) {
                                              tryAgain();
                                          }
                                      }
        );
        endApp.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              exitApp();
                                          }
                                      }
        );
                resultScore = findViewById(R.id.resultScore);

        Intent intent=getIntent();
        int score=0;
        score=intent.getIntExtra("Score",0);
        int questionCountTotal=0;
        questionCountTotal=intent.getIntExtra("questionCountTotal",0);

    if(score==0)
    {
        resultScore.setTextColor(Color.RED);
        resultScore.setText(""+score+" out of "+questionCountTotal);
    }
    else
    {
        resultScore.setTextColor(Color.GREEN);
        resultScore.setText(""+score+" out of "+questionCountTotal);
    }
    }
    private void tryAgain()
    {
        Intent intent=new Intent(Result.this, SelectQuiz.class);
        startActivity(intent);
    }
    private void exitApp()
    {

        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
