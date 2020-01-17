package hktechware.com.testyourbestv101;
public class Syllabus {
    int id;
    private int grade;
    private String Subject;
    private int chapters;
    public Syllabus()
{
}
    public Syllabus(int grade, String subject, int chapters) {
        this.grade = grade;
        this.Subject = subject;
        this.chapters = chapters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        grade = grade;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }
}
