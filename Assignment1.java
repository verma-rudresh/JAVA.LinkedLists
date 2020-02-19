import java.io.*;

public class Assignment1
{
    private static LinkedList<Hostel> allHostels          =  new LinkedList<Hostel> ();
    private static LinkedList<Department> allDepartments  = new LinkedList<Department> ();
    private static LinkedList<Course> allCourses          = new LinkedList<Course> ();
    private static LinkedList<Student_> allStudents       = new LinkedList<Student_>();
    private static LinkedList<CourseGrade_> CourseDetails = new LinkedList<CourseGrade_> ();
    private static LinkedList<String> megaList = new LinkedList<String> ();

    private static void getData(String filename1,String filename2) throws IOException
    {
        FileReader fr1 = new FileReader(filename1);
        BufferedReader br1 = new BufferedReader(fr1);
        FileReader fr2 = new FileReader(filename2);
        BufferedReader br2 = new BufferedReader(fr2);
        String line;


        //reading from a file reader format
        while((line = br2.readLine() )!=null)
        {
            String [] arr= line.split(" ");
            int a = arr.length;
            StringBuilder remain = new StringBuilder();
            for(int i=3;i<a;i++) {
                remain.append(arr[i]).append(" ");
            }
            CourseGrade_ course_details = new CourseGrade(arr[0],arr[1],arr[2], remain.toString());
            CourseDetails.add(course_details);
            if(allCourses.tail == null) {
                Course obj = new Course (arr[1] );
                allCourses.add(obj);
                obj.CourseHolders.add(course_details);
            }
            else {
                int y= 0;
                ListIterator <Course> itr = new ListIterator <Course>(allCourses);
                while(itr.hasNext()) {
                    Course obj = itr.next();
                    if(obj.name().equals(arr[1])) {
                        y++;
                        obj.CourseHolders.add(course_details);
                    }

                }
                if(y==0)
                {
                    Course obj = new Course(arr[1]);
                    allCourses.add(obj);
                    obj.CourseHolders.add(course_details);
                }
            }
			/*ListIterator<Student_> itr1 = new ListIterator<Student_> (allStudents);
			while(itr1.hasNext()) {
				Student_ obj =  itr1.next();
				if(obj.entryNo() == arr[0]) {
				    obj.courseList).add(course_details);
				}
			}*/
        }
        //reading first file
        while((line = br1.readLine() ) != null )
        {
            String[] arr    = line.split(" ");
            Student_ student = new Student(arr[0],arr[1],arr[2],arr[3],CourseDetails);
            allStudents.add(student);
            //adding students in hostels
            if(allHostels.tail == null) {
                Hostel obj = new Hostel (arr[3]);
                allHostels.add(obj);
                obj.Resident.add(student);
            }
            else {
                int y= 0;
                ListIterator <Hostel> itr = new ListIterator <Hostel>(allHostels);
                while(itr.hasNext()) {
                    Hostel obj1 = itr.next();
                    if(obj1.name().equals(arr[3])) {
                        y++;
                        obj1.Resident.add(student);
                    }

                }
                if(y==0)
                {
                    Hostel obj = new Hostel(arr[3]);
                    allHostels.add(obj);
                    obj.Resident.add(student);
                }
            }

            if(allDepartments.tail == null) {
                Department obj = new Department (arr[2]);
                allDepartments.add(obj);
                obj.DepartmentHolders.add(student);
            }
            else {
                int y=0;
                ListIterator <Department> itr = new ListIterator <Department>(allDepartments);
                while(itr.hasNext()) {
                    Department obj1 = itr.next();
                    if(obj1.name().equals(arr[2])) {
                        y++;
                        obj1.DepartmentHolders.add(student);
                    }}
                if(y==0){
                    Department obj = new Department(arr[2]);
                    allDepartments.add(obj);
                    obj.DepartmentHolders.add(student);
                }
            }

        }
        ListIterator<Course> apple = new ListIterator<Course> (allCourses);
        while(apple.hasNext())
        {
            Course obj = apple.next();
            ListIterator<CourseGrade_> itr = new ListIterator<CourseGrade_> (obj.CourseHolders);
            while(itr.hasNext())
            {
                CourseGrade_ obj1 = itr.next();
                String entry = obj1.EntryNo();
                ListIterator<Student_>  itr1 = new ListIterator<Student_> (allStudents);
                while(itr1.hasNext())
                {
                    Student_ obj2 =  itr1.next();
                    if(obj2.entryNo().equals(entry))
                        obj.studentsWithCourse.add(obj2);
                }
            }
        }


        // reading second file


        //second file read
        br1.close();
        br2.close();

    }







    private static void answerQueries(String filename) throws IOException
    {

        //int total = 0;
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine() )!=null)
        {
            String []arr = line.split(" ");
            if(arr[0].equals("INFO"))
            {
                String word = arr[1];
                ListIterator<Student_> itr = new ListIterator<Student_> (allStudents);
                while(itr.hasNext())
                {
                    Student_ obj =  itr.next();
                    if(obj.name().equals(word) || obj.entryNo().equals(word))
                    {
                        //int count = 0;
                        LinkedList<String> result = new LinkedList<String> ();
                        String group = obj.entryNo() + " " + obj.name() + " " + obj.department() + " " + obj.hostel() + " " + obj.cgpa() ;
                        result.add(group);
                        //count++;
                        ListIterator<CourseGrade_> course_itr =  obj.courseList();
                        while(course_itr.hasNext())
                        {
                            CourseGrade_ ball =  course_itr.next();
                            String pair =  ball.coursenum() + " " + ball.grade();
                            result.add(pair);
                            //count++;
                        }
                        int count = result.count();
                        //System.out.println(count);
                        String [] array =new String [count-1] ;
                        ListIterator<String> course_itr1 =  new ListIterator<String> (result);
                        int i=0;
                        String [] fix  = new String [1];
                        while(course_itr1.hasNext())
                        {
                            if(i== count-1)
                                fix[0] = course_itr1.next();
                            else
                                array[i] = course_itr1.next();
                            i++;
                        }
                        bubbleSort bubble = new bubbleSort ();
                        String[] array2 = bubble.sort(array);
                        StringBuilder sentence = new StringBuilder(fix[0] + " ");
                        for(int l = 0; l<count-1; l++)
                        {
                            sentence.append(array2[l]).append(" ");
                        }
                        megaList.add(sentence.toString());
                        //total++;
                    }
                }

            }
            //SHARE reading

            else if(arr[0].equals("SHARE"))
            {
                int x=0;
                //int count=0;
                LinkedList<String> result = new LinkedList<String> ();
                //String entryNumber = arr[1];
                ListIterator<Hostel> h1 = new ListIterator<Hostel> (allHostels);
                while(h1.hasNext())
                {

                    Hostel obj = h1.next();
                    if(arr[2].equals(obj.name()))
                    {

                        x++;
                        ListIterator<Student_> itr =  obj.studentList() ;
                        while(itr.hasNext()) {
                            Student_ s1 =  itr.next();
                            if(!s1.entryNo().equals(arr[1])) {
                                result.add(s1.entryNo());
                                //count++;
                            }
                        }
                    }
                }

                if(x==0)
                {
                    ListIterator<Department> d1 = new ListIterator<Department> (allDepartments);
                    while(d1.hasNext())
                    {

                        Department obj = d1.next();
                        if(arr[2].equals(obj.name()))
                        {

                            x++;
                            ListIterator<Student_> itr =  obj.studentList() ;
                            while(itr.hasNext()) {
                                Student_ s1 =  itr.next();
                                if(!s1.entryNo().equals(arr[1])) {
                                    result.add(s1.entryNo());
                                    //count++;
                                }
                            }
                        }
                    }
                }
                if(x==0)
                {

                    ListIterator<Course> c1 = new ListIterator<Course> (allCourses);
                    while(c1.hasNext())
                    {

                        Course obj = c1.next();
                        if(arr[2].equals(obj.name()))
                        {

                            x++;
                            ListIterator<Student_> itr = obj.studentList() ;
                            while(itr.hasNext()) {
                                Student_ s1 =  itr.next();
                                if(!s1.entryNo().equals(arr[1])) {
                                    result.add(s1.entryNo());
                                    //count++;
                                }
                            }
                        }
                    }
                }
                int w = result.count();
                String [] array = new String [w];
                ListIterator<String> course_itr1 =  new ListIterator<String> (result);
                int i=0;
                while(course_itr1.hasNext())
                {
                    array[i] = course_itr1.next();
                    i++;
                }
                bubbleSort bubble = new bubbleSort();
                String[] array2  = bubble.sort(array);
                StringBuilder sentence = new StringBuilder();
                for(int l = 0; l< w; l++)
                {
                    sentence.append(array2[l]).append(" ");
                }
                if(w == 0)
                    megaList.add(" ");
                else
                    megaList.add(sentence.toString());
                //total++;
            }



            else if(arr[0].equals("COURSETITLE"))
            {
                LinkedList<String> result = new LinkedList<String> ();
                ListIterator<CourseGrade_> pink = new ListIterator<CourseGrade_> (CourseDetails);
                while(pink.hasNext())
                {
                    CourseGrade_ obj =  pink.next();
                    if(obj.coursenum().equals(arr[1]))
                    {
                        result.add(obj.coursetitle());
                        break;
                    }
                }
                String[] array = new String[1];
                ListIterator<String> course_itr1 =  new ListIterator<String> (result);
                int i=0;
                while(course_itr1.hasNext())
                {
                    array[i] = course_itr1.next();
                    i++;
                }
                //String sentence = array[0];
                megaList.add(array[0]);
                //total++;
            }
        }

        // now , we will arrange all the linked list in lexicographical order.
        // then, we will print all the lists as strings in the reverse order.
        ListIterator<String> finalIterator = new ListIterator<String> (megaList);
        while(finalIterator.hasNext()) {
            String a=finalIterator.next();
            System.out.println(a);
        }



        br.close();
    }
    public static void main(String [] args) throws IOException
    {

        //if (args.length == 0) {
        //Assignment1.getData("student.txt","courses.txt");
        //Assignment1.answerQueries("queries.txt");

        //}
        Assignment1.getData(args[0],args[1]);
        Assignment1.answerQueries(args[2]);
    }
}
