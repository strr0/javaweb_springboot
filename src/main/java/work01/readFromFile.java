package work01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class readFromFile {
    public static void main(String[] args){
        try{
            //从a.txt中读取内容
            File file1 = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "a.txt");
            FileInputStream in = new FileInputStream(file1);
            List<String> list = new ArrayList<String>();
            String buffer = new String();
            int n = in.read();
            while(n != -1){
                char ch = (char)n;
                if(ch == '\n'){
                    list.add(buffer);
                    System.out.println(buffer);
                    buffer = new String();
                }
                else
                    buffer += ch;
                n = in.read();
            }
            in.close();
            System.out.println(list.size());

            //排序
            Collections.sort(list);

            //将内容写入b.txt中
            File file2 = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "b.txt");
            FileOutputStream out = new FileOutputStream(file2);
            for(String s : list){
                out.write(s.getBytes());
                out.write("\r\n".getBytes());
            }
            out.close();
            System.out.println("write successfully.");
        }
        catch (FileNotFoundException f){
            System.out.println("file is not found.");
        }
        catch (IOException i){
            System.out.println("catch IOException.");
        }

    }
}
