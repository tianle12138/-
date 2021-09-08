import java.io.*;
class Student implements Serializable
{
    private String name;
    private transient String password;
    private static int count=0;

    public Student(String name,String password)
    {
        System.out.println("调用Student的带参的构造方法");
        this.name=name;
        this.password=password;
        count++;
    }
    public String toString()
    {
        return "人数: "+count+" 姓名: "+name+" 密码: "+password;
    }
}
public class SerializableDemo2
{
    public static void main(String args[])
    {
        try{

            FileOutputStream fos=new FileOutputStream("test.obj");
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            Student s1=new Student("张三","12345");
            Student s2=new Student("王五","54321");
            System.out.println(s1);
            System.out.println(s2);

            oos.writeObject(s1);
            oos.writeObject(s2);

            oos.close();

            //注意：static不会被
            FileInputStream fis=new FileInputStream("test.obj");
            ObjectInputStream ois=new ObjectInputStream(fis);


            Student s3=(Student)ois.readObject();
            Student s4=(Student)ois.readObject();


            System.out.println(s3);
            System.out.println(s4);


            ois.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e1)
        {
            e1.printStackTrace();
        }
    }
}
