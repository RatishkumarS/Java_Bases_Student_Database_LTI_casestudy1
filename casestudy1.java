import java.util.*;
import java.util.Scanner.*;
import java.io.*;
class student
{
    private Integer clgid;
    private String clgname;
    private String crstype;
    private String city;
    private Integer fees;
    private Integer pincode;
    public void newcollege() 
    {
        System.out.println("Enter collegeid,collegename,coursetype,city,fees,pincode in the same order\n");
        Scanner sc=new Scanner(System.in);
        clgid=sc.nextInt();
        clgname=sc.next();
        crstype=sc.next();
        city=sc.next();
        fees=sc.nextInt();
        pincode=sc.nextInt();

        String csvFileName = "database.csv"; // Note the ".csv" file extension
       
 
try {
    FileWriter writer = new FileWriter("D:/casestudy1/database.csv",true);
 
    // This the header for the CSV file
    writer.append("\n");
    writer.append(clgid.toString()+ ","+clgname+","+crstype+","+city+","+fees.toString()+","+pincode.toString());
    //writer.flush();
    writer.close();
    // This is the data for the csv file:
 
    // Probably read from a database result set and and is
    // read within a loop until the end of the data.
    // The database code is not shown here.
 
    // Writing three rows of data
 
    
}
catch (IOException e) {
    // Code to catch exception and deal with it
    System.out.println("File writting corrupted");
}
}
    public static void main(String args[])
    {
        System.out.println("Student DataBase import to csv file ");
        int a=0;
        Scanner sc=new Scanner(System.in);
        student s=new student();
        
            System.out.println("1.To enter new Data");
            System.out.println("2.To search data based on coursetype and city");
            System.out.println("3.To delete data based on id");
        while(a<=3)
        {
            System.out.println("Enter your option:");
            a=sc.nextInt();
            switch(a)
            {
                case 1:
                    s.newcollege();
                    break;
                case 2:
                s.searchdata();
                break;
                case 3:
                s.deletedata();
                default :
                System.out.println("Invalid Input");
                    break;
            }
        }
        
    }
    public void searchdata()
    {
        //String csvFileName = "database.csv";
        try{
            Scanner sc=new Scanner(new File("D:/casestudy1/database.csv")).useDelimiter("\n");
            int flag=0;
            while(sc.hasNext())
            {
                String data=sc.next();
                String[] val=data.split(",");
                if(val[2].equals("EEE")&&val[3].equals("Chennai"))
                {
                    System.out.println(data);
                    flag=1;
                }
            }
            if(flag==0)
            {
                System.out.println("Value not found");
            }

        }
        catch(IOException e){
            System.out.println(e);

        }
       


    }
    public void deletedata()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter college ID");
        String id=s.next();
        ArrayList<String> line=new ArrayList<String>();
        int row=0,del_row=0;
        try{
            Scanner sc=new Scanner(new File("D:/casestudy1/database.csv")).useDelimiter("\n");
            boolean flag=true;
            while(sc.hasNext())
            {
                String lines=sc.next();
                line.add(lines);
                String data[] =lines.split((","));
                if(data[0].trim().equals(id))
                {
                    del_row=row;
                    flag=true;
                }
                else
                {
                    row++;
                }
                if(flag==false)
                {
                    System.out.println("Data not found");

                }
                else{
                        line.remove(row);
                        new FileWriter("D:/casestudy1/database.csv",false).close();
                        FileWriter f=new FileWriter("D:/casestudy1/database.csv",true);
                        for(String c:line)
                        {
                            f.append(c);
                        }
                        f.close();
                        System.out.println("Deletion successfull");
                }

            }
        }catch(IOException e)
        {
            System.out.println("Error occured"+e);
        }

        
    }
}
