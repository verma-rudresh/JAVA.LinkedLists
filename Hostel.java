public class Hostel implements Entity_
{
    private String name;

    LinkedList<Student_> Resident = new LinkedList<Student_>();
    Hostel(String hostelName)
    {
        this.name = hostelName;
        //this.students = allStudents;

    }
    public String name()
    {
        return name;
    }
    public ListIterator<Student_> studentList()
    {
        return new ListIterator<Student_> (Resident);
    }
}






