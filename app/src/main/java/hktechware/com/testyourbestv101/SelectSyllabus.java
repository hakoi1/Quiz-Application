package hktechware.com.testyourbestv101;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SelectSyllabus extends Activity implements AdapterView.OnItemSelectedListener{
    private Spinner spinner;
    private TextView classandsubject;
    String grade,subject;
    private int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_syllabus);
        Button selectSyllabus=findViewById(R.id.proceed_select_syllabus);
        selectSyllabus.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  proceedSelectSyllabus();
                                              }
                                          }

        );

        spinner = (Spinner) findViewById(R.id.spinner);
        Intent intent=getIntent();
        grade=intent.getStringExtra("grade");
        subject=intent.getStringExtra("subject");
        classandsubject=findViewById(R.id.classandsubject);
        classandsubject.setText(subject+" "+grade);
        // Spinner click listener
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        QuizDbHelper dbHelper=QuizDbHelper.getInstance(this);
        int syllabus=dbHelper.getAllSyllabus(grade,subject);
        id=dbHelper.getAllSyllabusId(grade,subject);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Chapter From Here...");
        for(int i=0;i<syllabus;i++)
            categories.add(""+(i+1));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

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
    private void proceedSelectSyllabus()
    {
        String syllabus = spinner.getSelectedItem().toString();
        Intent intent=new Intent(SelectSyllabus.this, QuizActivity.class);
        intent.putExtra("syllabus",syllabus);
        intent.putExtra("chapter",id);
        intent.putExtra("grade",grade);
        intent.putExtra("subject",subject);
        startActivity(intent);

    }

}
