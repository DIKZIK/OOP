package ru.mai.files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MainFile {

    public static void main(String[] args) throws IOException {

/*        File myDir = new File("test");
        File myFile = new File("test/test.txt");
        if(!myDir.exists()) {

            myDir.mkdirs();

        }
        if(!myFile.exists()){

            myFile.createNewFile();
        } else {

            myFile.renameTo(new File("test/test.pdf"));
        }

 */

/*        String path = "test/test.txt";
        File myFile = new File(path);
        File myDir = myFile.getParentFile();
        myDir.mkdirs();
        myFile.createNewFile();

 */

/*        String path = "test/test.txt";
        FileWriter writter = new FileWriter(path, true);
        writter.append(" Hello World!").append(System.lineSeparator()).append("NextLine");
        writter.flush();
        writter.close();

 */

/*        String path = "test/test.txt";
        File myFile = new File(path);
        FileReader reader = new FileReader(myFile);

        int size = 256;
        char[] buf = new char[size];
        int c;
        while ((c = reader.read(buf)) > 0) {

            if(c < size) {

                buf = Arrays.copyOf(buf, c);
            }

            System.out.println(buf);
        }

 */

/*        String path = "test/test.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));

        int c;
        while ((c = reader.read()) != -1) {

            System.out.print((char)c + " ");
        }

 */

/*        String path = "test/test.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;
        while((line = reader.readLine()) != null ) {

            System.out.println(line + "|");
        }

 */

/*
        String path = "test/test.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.append("New date");
        writer.newLine();
        writer.append("Next date");
        writer.flush();
        writer.close();

 */

/*        String path = "test/test.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        String line;
        while (!(line = reader.readLine()).equalsIgnoreCase("ESC")) {
            writer.write(line);
            writer.newLine();
            writer.flush();

        }

        writer.close();

 */

        String path = "test/test.txt";
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
            writer.flush();

        }

        writer.close();


    }
}
