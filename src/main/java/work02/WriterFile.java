package work02;

import org.junit.Test;
import work01.SearchRepetition;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * 这是一个类说明
 *
 * @author 冯东宝 (dongbao.feng@ucarinc.com)
 * @date 2019/7/22 下午3:23
 * @since 1.0
 */
public class WriterFile {


    private  static  final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");


    @Test
    public void test(){
        try {
            Set<String> setResult=SearchRepetition.filterRepetition();
            String fileName =getFileName();
            PrintStream printStream = new PrintStream(new FileOutputStream(fileName));
            for (String s: setResult) {
                printStream.printf(s);
            }
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String  getFileName(){
        String dataStr =dateFormat.format(new Date());
        //使用的是相对路径，也可以使用绝对路径  在使用/ 还是 \时，注意是linux系统还是window系统 File.separator
        //咱本地开发很多都是window系统，但是部署到测试，线上，都是linux系统，也就不存在C盘
        String path ="resources"+File.separator+dataStr+".txt";
        return path;
    }
}
