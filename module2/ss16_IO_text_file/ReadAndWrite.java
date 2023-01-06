import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWrite {
    public static void main(String args[]){
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("module2/ss16_IO_text_file/text");
            String s = "Welcome to java.";
            byte b[] = s.getBytes();// converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
