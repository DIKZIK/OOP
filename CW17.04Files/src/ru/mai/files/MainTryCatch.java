package ru.mai.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainTryCatch {

    public static void main(String[] args) {

        String path = "test/test.txt";

/*        try(FileWriter writter = new FileWriter(path, true) {

        writter.append(" Hello World!")
                writter.append(System.lineSeparator()).append("NextLine");
        writter.flush();
        writter.close();
        }

 */

/*        FileWriter writer = null;
        try {
            writer = new FileWriter(path, true);
            writer.append("Hello world");
            writer.append(System.lineSeparator());
            writer.append("Next Line");
        } catch (IOException e) {
        } finally {
            if(writer != null) {
                try{
                    writer.close();
                } catch (IOException e){}
            }
        }

 */


    }
}
