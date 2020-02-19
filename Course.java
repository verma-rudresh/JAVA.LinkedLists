public class Course implements Entity_
{
    private String name;
    //LinkedList<Student_> allStudents;
    LinkedList<Student_> studentsWithCourse = new LinkedList<Student_> ();
    LinkedList<CourseGrade_> CourseHolders = new LinkedList<CourseGrade_>();

    Course(String CourseName)
    {
        this.name = CourseName;
        //this.allStudents = allStudents;

    }
    public String name()
    {
        return name;
    }
    public ListIterator<Student_> studentList()
    {

        return new ListIterator<Student_> (studentsWithCourse);
    }
}
