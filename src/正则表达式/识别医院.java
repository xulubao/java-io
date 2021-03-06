package 正则表达式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author XuLuBao
 * @version V1.0
 * @Package 正则表达式
 * @date 2020/8/29 18:00
 */
public class 识别医院 {
    public static void main(String[] args) {
        String urladd = "https://www.haodf.com/";
        String reg = "[\u4e00-\u9fa5]+((医?院)|(中心))";
        String str = "";//医院网址
        String fileName = "f:\\中科韬睿\\JSP\\FILE\\";
        try {
            URL url = new URL(urladd);
            URLConnection urlcon = url.openConnection();
            urlcon.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlcon.getInputStream(),"gb2312"));
            String web = reader.readLine();
            while (web!=null){
                str +=web+"\r\n";
                web = reader.readLine();
            }
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(str);
            PrintWriter writer = new PrintWriter(fileName+"医院.txt");
            while (matcher.find()){
                System.out.println(matcher.group());
                writer.write(matcher.group()+"\r\n");
            }
            reader.close();
            writer.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
