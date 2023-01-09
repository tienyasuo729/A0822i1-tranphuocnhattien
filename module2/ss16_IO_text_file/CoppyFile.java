import javafx.scene.image.PixelFormat;

import java.io.*;
import java.lang.reflect.Array;

public class CoppyFile {

    public static void main(String[] args) {
        try {
            FileWriter fileWriterSource = new FileWriter("C:\\codegym\\A0822i1-tranphuocnhattien\\module2\\ss16_IO_text_file\\source");
            BufferedWriter bufferedWriterSource = new BufferedWriter(fileWriterSource);
            String a = "hello";
            bufferedWriterSource.write(a);
            bufferedWriterSource.newLine();
            String b = "world";
            bufferedWriterSource.write(b);
            bufferedWriterSource.close();
            fileWriterSource.close();
            FileReader fileReaderSource =new FileReader("C:\\codegym\\A0822i1-tranphuocnhattien\\module2\\ss16_IO_text_file\\source");
            BufferedReader bufferedReaderSource = new BufferedReader(fileReaderSource);

            FileWriter fileWriterDestination = new FileWriter("C:\\codegym\\A0822i1-tranphuocnhattien\\module2\\ss16_IO_text_file\\destination");
            BufferedWriter bufferedWriterDestination = new BufferedWriter(fileWriterDestination);
            String aff = null;
            while (( aff = bufferedReaderSource.readLine()) != null){
                System.out.println(aff);
                bufferedWriterDestination.write(bufferedReaderSource.readLine());
                bufferedWriterDestination.newLine();
            }
            fileWriterDestination.close();
            bufferedWriterDestination.close();
            fileReaderSource.close();
            bufferedReaderSource.close();
        }catch (FileNotFoundException e){
            e.getStackTrace();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
