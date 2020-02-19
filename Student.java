public class Student implements Student_
{
    private String entryNo;
    private String name;
    private String hostel;
    private String department;
    //LinkedList<CourseGrade_> CourseDetails;
    private LinkedList<CourseGrade_> courseList = new LinkedList<CourseGrade_>();
    Student(String entryNo,String name,String department,String hostel,LinkedList<CourseGrade_> CourseDetails)
    {
        this.entryNo = entryNo;
        this.name = name;
        this.hostel = hostel;
        this.department = department;
        //this.CourseDetails = CourseDetails;
        ListIterator<CourseGrade_> itr2 = new ListIterator<CourseGrade_> ( CourseDetails);
        while(itr2.hasNext()) {
            CourseGrade_ obj = itr2.next();
            if(obj.EntryNo().equals(entryNo))
                courseList.add(obj);
        }
    }

    public String name()
    {
        return name;
    }

    public String entryNo()
    {
        // TODO Auto-generated method stub
        return entryNo;
    }

    public String hostel() {
        // TODO Auto-generated method stub
        return hostel;
    }

    public String department() {
        // TODO Auto-generated method stub
        return department;
    }

    public String completedCredits()
    {
        ListIterator<CourseGrade_> itr = new ListIterator<CourseGrade_> (courseList);
        int num = 0;
        while(itr.hasNext())
        {
            CourseGrade_ obj=  itr.next();
            if(!obj.grade().equals("I") || !obj.grade().equals("E") ||!obj.grade().equals("F"))
                num+=3;
        }
        return Integer.toString(num);
    }

    public String cgpa()
    {
        ListIterator<CourseGrade_> itr = new ListIterator<CourseGrade_> (courseList);
        double num = 0.00;
        double x=0.00;
        while(itr.hasNext())
        {
            CourseGrade_ obj=  itr.next();
            if(!obj.grade().equals("I"))
            {
                num+= 3*GradeInfo_.gradepoint(GradeInfo_.LetterGrade.valueOf(obj.grade()));
                x +=3.00f;
            }
        }
        double y = num/x;
        return String.format ("%.2f", y);
    }

    public ListIterator<CourseGrade_> courseList()
    {
        return new ListIterator<CourseGrade_> (courseList);
    }

}
