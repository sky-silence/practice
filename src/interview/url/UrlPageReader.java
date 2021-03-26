package interview.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 抓去网页内容到指定文件.只能使用jdk自带工具
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/22
 * @since practice 1.0.0
 */
public class UrlPageReader {

    public static void geturl(String urlStr) {
        try {

            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = null;
            BufferedWriter writer = new BufferedWriter(new FileWriter("path"));
            while ((line = reader.readLine()) != null) {
                line = new String(line.getBytes(), "utf-8");
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            reader.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        geturl("http:www.baidu.com");
    }
}
