public class Department implements Entity_
{
    private String name;
    //LinkedList<Student_> students;
    LinkedList<Student_> DepartmentHolders = new LinkedList<Student_>();
    Department(String departmentName)
    {
        this.name = departmentName;
        //this.students = allStudents;
    }
    public String name()
    {
        return name;
    }
    public ListIterator<Student_> studentList()
    {


        return new ListIterator<Student_> (DepartmentHolders);
    }
}
