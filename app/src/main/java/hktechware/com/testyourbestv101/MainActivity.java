package hktechware.com.testyourbestv101;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startAppButton=findViewById(R.id.button_start_app);
        Button endApp=findViewById(R.id.button_exit_app);
        endApp.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          exitApp();
                                      }
                                  }
        );
        startAppButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  startApp();
                                              }
                                          }

        );
    }
    private void startApp()
    {
        Intent intent =new Intent(MainActivity.this,SelectQuiz.class);
        startActivity(intent);
    }
    private void exitApp()
    {

        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
