package org.example.program;

public class Student {

    private int id;
    private String name;
    private Grades grades;
    private int scholarshipAmount;
    private int totalMarks;

    public Student(int id, String name, int totalMarks) {
        this.id = id;
        this.name = name;
        this.totalMarks=totalMarks;
        calGrade();
        calScholarship();
    }

    public void calGrade(){

        if(totalMarks>=250){
            grades=Grades.A;
        } else if (totalMarks>=200) {
            grades=Grades.B;
        } else if (totalMarks>=175) {
            grades=Grades.C;
        } else if (totalMarks >= 150) {
            grades=Grades.D;
        }else grades=Grades.F;

    }

    public void calScholarship(){
        scholarshipAmount=1000* grades.getValue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    public int getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(int scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                ", scholarshipAmount=" + scholarshipAmount +
                ", totalMarks=" + totalMarks +
                '}';
    }
}
