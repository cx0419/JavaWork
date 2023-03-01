package com.cx.lunshuti.no3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class No3Demo {
    public static StringBuffer readAll() throws IOException {
        StringBuffer str = new StringBuffer();
        FileInputStream fis = new FileInputStream("src/main/java/com/cx/lunshuti/no3/MovieData.txt");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            str.append(new String(bytes));
        }
        fis.close();
        return str;
    }
    public static List<MovieInfo> readData(StringBuffer str){
        ArrayList<MovieInfo> list = new ArrayList<>();
        String pat = "<tr>([\\s\\S]*?)</tr>";
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String s1 = matcher.group(1);
            System.out.println("ans:"+s1);
            String pat1 = "<td><div>([\\s\\S]*?)</div></td>";
            Pattern pattern1 = Pattern.compile(pat1);
            Matcher matcher1 = pattern1.matcher(s1);
            List<String> strs = new ArrayList<>();
            while (matcher1.find()){
                strs.add(matcher1.group(1));
            }
            MovieInfo movieInfo = new MovieInfo(strs.get(0),strs.get(1),strs.get(2));
            list.add(movieInfo);
        }
        return list;
    }

    private static class MovieInfo implements Serializable{
        private String name;
        private String sales;
        private String times;

        public MovieInfo() {

        }

        public MovieInfo(String name, String sales, String times) {
            this.name = name;
            this.sales = sales;
            this.times = times;
        }

        @Override
        public String toString() {
            return "MovieInfo{" +
                    "name='" + name + '\'' +
                    ", sales='" + sales + '\'' +
                    ", times='" + times + '\'' +
                    '}';
        }
    }

    public static void save(Object obj) throws IOException{
        FileOutputStream out = new FileOutputStream("src/main/java/com/cx/lunshuti/no3/NewMovieData.txt");
        ObjectOutputStream objOut=new ObjectOutputStream(out);
        objOut.writeObject(obj);
        objOut.flush();
        objOut.close();
    }

    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer = No3Demo.readAll();
        System.out.println(stringBuffer);
        List<MovieInfo> list = No3Demo.readData(stringBuffer);
        No3Demo.save(list);
        for (Object o : list) {
            System.out.println(o);
        }
    }
}