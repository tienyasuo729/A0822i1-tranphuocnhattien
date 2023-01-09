import java.io.*;

public class CoppyFile {

    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("D:\\codegym\\A0822i1-tranphuocnhattien\\Module2\\ss16_IO_text_file\\destination");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String a = "hello";
            bufferedWriter.write(a);
            bufferedWriter.newLine();
            String b = "world";
            bufferedWriter.write(b);
            bufferedWriter.close();
            fileWriter.close();
            FileReader fileReader =new FileReader("D:\\codegym\\A0822i1-tranphuocnhattien\\Module2\\ss16_IO_text_file\\destination");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                line = bufferedReader.readLine();
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
            e.getStackTrace();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
