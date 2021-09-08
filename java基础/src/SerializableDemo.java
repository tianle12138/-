import java.io.*;

public class SerializableDemo {

    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setName("张三");
        OutputStream out;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempfile"));
        oos.writeObject(user);
        File file = new File("tempfile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        try {
            User u = (User) ois.readObject();
            System.out.println(u);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class User implements Serializable{
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
