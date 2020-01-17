package hktechware.com.testyourbestv101;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectQuiz extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner,spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_quiz);
        Button selectquiz=findViewById(R.id.proceed_select_quiz);
        selectquiz.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               proceedSelectQuiz();
                                           }
                                       }

        );
        spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Class Here...");
        categories.add("9");
        categories.add("10");
        categories.add("11");
        categories.add("12");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner1 = (Spinner) findViewById(R.id.spinner_subject);List<String> categories1 = new ArrayList<String>();
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        categories1.add("Subject Here...");
        categories1.add("Physics");
        categories1.add("Chemistry");
        categories1.add("Biology");
        categories1.add("Computer");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);
        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter1);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    private void proceedSelectQuiz()
    {
        String grade = spinner.getSelectedItem().toString();
        String subject=spinner1.getSelectedItem().toString();
        Intent intent=new Intent(SelectQuiz.this, SelectSyllabus.class);
        intent.putExtra("grade",grade);
        intent.putExtra("subject",subject);
        startActivity(intent);

    }
}
