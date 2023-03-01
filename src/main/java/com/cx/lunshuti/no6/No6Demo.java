package com.cx.lunshuti.no6;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class No6Demo {
    public static StringBuffer readAll() throws IOException {
        StringBuffer str = new StringBuffer();
        FileInputStream fis = new FileInputStream("src/main/java/com/cx/lunshuti/no6/news.txt");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            str.append(new String(bytes,0,len));
        }
        fis.close();
        return str;
    }
    public static List<News> readData(StringBuffer str){
        ArrayList<News> list = new ArrayList<>();
        String pat = "<a href=\"([\\s\\S]*?)\" target=\"([\\s\\S]*?)\" title=\"([\\s\\S]*?)\"</a>[\\s\\S]*?<div>([\\s\\S]*?)</div>";
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            News movieInfo = new News(matcher.group(1),matcher.group(2),matcher.group(3));
            list.add(movieInfo);
        }
        return list;
    }

    @Data
    private static class News implements Serializable{
        private String href;
        private String title;
        private String cdate;

        public News() {

        }

        public News(String href, String title, String cdate) {
            this.href = href;
            this.title = title;
            this.cdate = cdate;
        }
    }

    public static void save(Object obj) throws IOException{
        FileOutputStream out = new FileOutputStream("src/main/java/com/cx/lunshuti/no6/news-1.txt");
        ObjectOutputStream objOut=new ObjectOutputStream(out);
        objOut.writeObject(obj);
        objOut.flush();
        objOut.close();
    }

    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer = No6Demo.readAll();
        System.out.println(stringBuffer);
        List<News> list = No6Demo.readData(stringBuffer);
        No6Demo.save(list);
        for (Object o : list) {
            System.out.println(o);
        }
    }
}