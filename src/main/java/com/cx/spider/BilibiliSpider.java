package com.cx.spider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BilibiliSpider {

    public static void main(String[] args) throws Exception {
        String url = "https://www.bilibili.com";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response);
        // Extract video title and link
        String regex = "<a title=\"(.*?)\" href=\"(.*?)\">";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(response.toString());

        List<Video> videos = new ArrayList<>();
        while (matcher.find()) {
            String title = matcher.group(1);
            String link = matcher.group(2);
            Video video = new Video(title, link);
            videos.add(video);
        }

        // Print video information
        for (Video video : videos) {
            System.out.println("Title: " + video.getTitle());
            System.out.println("Link: " + video.getLink());
            System.out.println("Video ID: " + video.getVideoID());
            System.out.println("Thumbnail: " + video.getThumbnail());
            System.out.println();
        }
    }

    private static class Video {
        private String title;
        private String link;

        public Video(String title, String link) {
            this.title = title;
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getVideoID() {
            String regex = "/video/(.*?)/";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(link);
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                return null;
            }
        }

        public String getThumbnail() {
            String apiUrl = "https://api.bilibili.com/x/web-interface/view?bvid=" + getVideoID();
            try {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                String regex = "\"pic\":\"(.*?)\"";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(response.toString());
                if (matcher.find()) {
                    return matcher.group(1);
                } else {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
