package hktechware.com.testyourbestv101;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import hktechware.com.testyourbestv101.QuizContract.*;

import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "testyourbest.db";
    private static final int DATABASE_VERSION = 2;

    private static QuizDbHelper instance;

    private SQLiteDatabase db;

    private QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized QuizDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDbHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_SYLLABUS_TABLE = "CREATE TABLE " +
                SyllabusTable.TABLE_NAME + "( " +
                SyllabusTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SyllabusTable.COLUMN_CLASS + " INTEGER, " +
                SyllabusTable.COLUMN_SUBJECT + " TEXT," +
                SyllabusTable.COLUMN_CHAPTER + " INTEGER " +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_SYLLABUS_ID + " INTEGER, " +
                QuestionsTable.COLUMN_CHAPTER + " INTEGER, " +
                "FOREIGN KEY(" + QuestionsTable.COLUMN_SYLLABUS_ID + ") REFERENCES " +
                SyllabusTable.TABLE_NAME + "(" + SyllabusTable._ID + ")" + "ON DELETE CASCADE" +
                ")";

        db.execSQL(SQL_CREATE_SYLLABUS_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillSyllabusTable();
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SyllabusTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void fillSyllabusTable() {
        Syllabus s1=new Syllabus(9,"Physics",9);
        insertSyllabus(s1);
        Syllabus s2=new Syllabus(9,"Chemistry",8);
        insertSyllabus(s2);
        Syllabus s3=new Syllabus(9,"Biology",9);
        insertSyllabus(s3);
        Syllabus s4=new Syllabus(9,"Computer",8);
        insertSyllabus(s4);
        Syllabus s5=new Syllabus(10,"Physics",9);
        insertSyllabus(s5);
        Syllabus s6=new Syllabus(10,"Chemistry",8);
        insertSyllabus(s6);
        Syllabus s7=new Syllabus(10,"Biology",9);
        insertSyllabus(s7);
        Syllabus s8=new Syllabus(10,"Computer",7);
        insertSyllabus(s8);
        Syllabus s9=new Syllabus(11,"Physics",11);
        insertSyllabus(s9);
        Syllabus s10=new Syllabus(11,"Chemistry",11);
        insertSyllabus(s10);
        Syllabus s11=new Syllabus(11,"Biology",14);
        insertSyllabus(s11);
        Syllabus s12=new Syllabus(11,"Computer",10);
        insertSyllabus(s12);
        Syllabus s13=new Syllabus(12,"Physics",10);
        insertSyllabus(s13);
        Syllabus s14=new Syllabus(12,"Chemistry",16);
        insertSyllabus(s14);
        Syllabus s15=new Syllabus(12,"Biology",13);
        insertSyllabus(s15);
        Syllabus s16=new Syllabus(12,"Computer",14);
        insertSyllabus(s16);
        
    }

    public void addSyllabus(Syllabus syllabus) {
        db = getWritableDatabase();
        insertSyllabus(syllabus);
    }
    private void fillQuestionsTable() {
        Question q1 = new Question("Amount of a substance in terms of numbers is measured in:","Gram", "Kilogramme", "Newton","Mole",4, 1,1);
        insertQuestion(q1);

        Question q2 = new Question("A measuring cylinder is used to measure:","Mass", "Area", "Volume","Level of Liquid",3, 1,1);
        insertQuestion(q2);

        Question q3 = new Question("Which one of the following is not base unit?","Mass", "Time", "Force","None of these",3, 1,1);
        insertQuestion(q3);

        Question q4 = new Question("Which of the following is vector quantity?","Speed", "Distance", "Displacement","Power",3, 1,2);
        insertQuestion(q4);

        Question q5 = new Question("A change in position is called:","Speed", "Velocity", "Displacement","Distance",3, 1,2);
        insertQuestion(q5);

        Question q6 = new Question("Unit of velocity is?","Meter/Second", "Meter/Second Square", "Second/Meter Square","None of these",1, 1,2);
        insertQuestion(q6);

        Question q7 = new Question("Inertia depends upon ","Force", "Net Force", "Mass","Velocity",3, 1,3);
        insertQuestion(q7);

        Question q8 = new Question("Which of the following is the unit of momentum?","Nm", "Kgms-2", "Ns","Ns-1",3, 1,3);
        insertQuestion(q8);

        Question q9 = new Question("P=?","Mass x Velocity", "Mass x Radius ", "Mass x Force","Mass x Acceleration",1, 1,3);
        insertQuestion(q9);

        Question q10 = new Question("BASIC programming language was developed in.","1964", "1960", "1955","1950",1, 4,1);
        insertQuestion(q10);

        Question q11 = new Question("Digital computers process data in the form of:","Digits", "Analog signals", "Wave","All of these",1, 4,1);
        insertQuestion(q11);

        Question q12 = new Question("Which of the following is not high level language:","FORTRAN", "Basic", "C and C++ ","Assembly language",4, 4,1);
        insertQuestion(q12);

        Question q13 = new Question("Variables are created in:","RAM", "ROM", "Hard Disk","Cache",1, 16,9);
        insertQuestion(q13);

        Question q14 = new Question("When result of the computation of two very small numbers is too small to be represented, this phenomenon is called:","Arithmetic Overflow", "Arithmetic underflow", "Truncation","Round off",2, 16,9);
        insertQuestion(q14);

        Question q15 = new Question("Which of the following data type offers the highest precision?","float", "long int", "long double ","unsigned long int ",3, 16,9);
        insertQuestion(q15);
    }
    private void insertQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_SYLLABUS_ID, question.getSyllabusId());
        cv.put(QuestionsTable.COLUMN_CHAPTER, question.getChapter());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public void addCategories(List<Syllabus> categories) {
        db = getWritableDatabase();

        for (Syllabus syllabus : categories) {
            insertSyllabus(syllabus);
        }
    }

    private void insertSyllabus(Syllabus syllabus) {
        ContentValues cv = new ContentValues();
        cv.put(SyllabusTable.COLUMN_CLASS, syllabus.getGrade());
        cv.put(SyllabusTable.COLUMN_SUBJECT, syllabus.getSubject());
        cv.put(SyllabusTable.COLUMN_CHAPTER, syllabus.getChapters());
        db.insert(SyllabusTable.TABLE_NAME, null, cv);
    }

    public int getAllSyllabus(String grade, String subject) {
        int syllabus=0;
        db = getReadableDatabase();
        String selection = SyllabusTable.COLUMN_CLASS + " = ? " +
                " AND " + SyllabusTable.COLUMN_SUBJECT + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(grade), subject};
        Cursor c = db.query(
                SyllabusTable.TABLE_NAME,
                new String[]{SyllabusTable.COLUMN_CHAPTER},
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        if (c.moveToFirst()) {
            do {
                syllabus=c.getInt(c.getColumnIndex(SyllabusTable.COLUMN_CHAPTER));
                Log.d("Eher ", "getAllSyllabus: "+syllabus);
            } while (c.moveToNext());
        }
        c.close();
        return syllabus;
    }
    public int getAllSyllabusId(String grade, String subject) {
        int id=0;
        db = getReadableDatabase();
        String selection = SyllabusTable.COLUMN_CLASS + " = ? " +
                " AND " + SyllabusTable.COLUMN_SUBJECT + " = ? " ;
        String[] selectionArgs = new String[]{String.valueOf(grade), subject};
        Cursor c = db.query(
                SyllabusTable.TABLE_NAME,
                new String[]{SyllabusTable._ID},
                selection,
                selectionArgs,
                null,
                null,
                null

        );
        if (c.moveToFirst()) {
            do {
                id=c.getInt(c.getColumnIndex(SyllabusTable._ID));

            } while (c.moveToNext());
        }
        c.close();
        return id;
    }
    public ArrayList<Question> getQuestions(int syllabusId, int chapter) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = QuestionsTable.COLUMN_SYLLABUS_ID + " = ? " +
                " AND " + QuestionsTable.COLUMN_CHAPTER + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(syllabusId), String.valueOf(chapter)};

        Cursor c = db.query(
                QuestionsTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setSyllabusId(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_SYLLABUS_ID)));
                question.setChapter(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CHAPTER)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setSyllabusId(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_SYLLABUS_ID)));
                question.setChapter(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CHAPTER)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
