package work02;

import org.junit.Test;
import work01.SearchRepetition;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 这是一个类说明
 *
 * @author 冯东宝 (dongbao.feng@ucarinc.com)
 * @date 2019/7/22 下午5:23
 * @since 1.0
 */
public class WriterFile {


    private  static  final SimpleDateFormat dateFormat_minute = new SimpleDateFormat("yyyyMMddHHmm");
    private  static  final SimpleDateFormat dateFormat_hour = new SimpleDateFormat("yyyyMMddHH");

    //写入文件 运行该方法
    @Test
    public void testWrite(){
        Set<String> setResult=SearchRepetition.filterRepetition();
        writeFile(setResult,"write");
    }

    //读取文件，排序后写到新文件 运行该方法
    @Test
    public void testRead(){
        List<String> list =readFile();
        writeFile(list,"read");
    }

    //读取文件
    private List<String> readFile(){
        List<String> list = new ArrayList<>();
        String fileName =getPath("write");
        File file = new File(fileName);
        BufferedReader bf = null;
        try {
            //判断文件是否存在
            if(!file.exists()){
                return list;
            }
            bf = new BufferedReader(new FileReader(file));
            String temp = "";
            while (temp != null) {
                temp = bf.readLine();
                if (null == temp || "".equals(temp)) {
                    break;
                }
                list.add(temp);
            }

            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    char[] chars1=s1.toCharArray();
                    char[] chars2=s2.toCharArray();
                    int i=0;
                    while(i<chars1.length && i<chars2.length){
                        if(chars1[i]>chars2[i]){
                            return 1;
                        }else if(chars1[i]<chars2[i]){
                            return -1;
                        }else{
                            i++;
                        }
                    }
                    //s1结束
                    if(i==chars1.length){
                        return -1;
                    }
                    //s2结束
                    if(i== chars2.length){
                        return 1;
                    }
                    return 0;
                }
            });


            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //要在finally中关闭
            if(null != bf){
                try {
                    bf.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
        }
        return list;

    }

    //写入文件
    private void writeFile(Collection<String> setResult,String writeOrRead){
        try {
            String fileName =getPath(writeOrRead);

            File file = new File(fileName);
            if(!file.getParentFile().exists()) {
                //创建目录
                if (!file.getParentFile().mkdirs()) {
                    System.out.println("创建目录失败");
                    return;
                }
            }
            PrintStream printStream = new PrintStream(new FileOutputStream(fileName));
            for (String s: setResult) {
                printStream.println(s);
            }
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private String  getPath(String writeOrRead){
        String temp =dateFormat_hour.format(new Date());

        //使用的是相对路径，也可以使用绝对路径  在使用/ 还是 \时，注意是linux系统还是window系统 File.separator
        //咱本地开发很多都是window系统，但是部署到测试，线上，都是linux系统，也就不存在C盘
        //绝对路径
//        String path ="/Users/dongbao.feng/Documents/workspaceidea/train_group3/src/main/resources/2019072217/write/";
        //相对路径
       String path ="src"+File.separator+"main"+File.separator+"resources"+File.separator+temp+File.separator+File.separator+writeOrRead+File.separator;

       path+=getFileName();
        return path;
    }

    private String  getFileName(){
        String dataStr =dateFormat_minute.format(new Date());
        String fileName =dataStr+".txt";
        return fileName;
    }
}
