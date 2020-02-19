public class CourseGrade implements CourseGrade_
{

    String EntryNo;
    String CourseNo;
    String CourseTitle;
    String letterGrade;
    CourseGrade (String EntryNo,String CourseNo,String letterGrade,String CourseTitle)
    {
        this.letterGrade = letterGrade;
        this.CourseNo = CourseNo;
        this.CourseTitle = CourseTitle;
        this.EntryNo = EntryNo;
    }

    public String coursetitle() {

        return CourseTitle;
    }


    public String coursenum() {

        return CourseNo;
    }


    //public String grade() {

    //return null;
    //return GradeInfo_.LetterGrade.(LetterGrade.valueOf(letterGrade));
    //}
    public String grade() {
        return letterGrade;
    }
    public String EntryNo() {

        return EntryNo;
    }

}
