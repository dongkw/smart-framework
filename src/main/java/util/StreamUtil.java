package util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dkw on 2017/7/3.
 */
public class StreamUtil {
    private static final Logger log=Logger.getLogger(CodeUtil.class);

    /**
     * 从输入流中获取字符串
     * @param is
     * @return
     */
    public static String getString(InputStream is){
        StringBuilder sb=new StringBuilder();
        try {
        BufferedReader reader=new BufferedReader(new InputStreamReader(is));
        String line;
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
        } catch (IOException e) {
            log.error("get string failure",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
