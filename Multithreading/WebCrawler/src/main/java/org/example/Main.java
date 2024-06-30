package org.example;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static String url = "https://skillfactory.ru";
    public static String filePath = "SITE_MAP.txt";

    public static void main(String[] args) {


        SiteMap siteMap = new SiteMap(url);

        WebCrawler webCrawler = new WebCrawler(siteMap);

        new ForkJoinPool().invoke(webCrawler);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.invoke(webCrawler);

        try {
            FileOutputStream stream = new FileOutputStream(filePath);

            String file = tabulateSiteMap(siteMap, 0);

            stream.write(file.getBytes());

            stream.flush();

            stream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String tabulateSiteMap(SiteMap siteMap, int indent) {

        String tab = String.join("", Collections.nCopies(indent, "\t"));

        StringBuilder result = new StringBuilder(tab + siteMap.getUrl());

        siteMap.getSiteMapChildrens().forEach(child -> result.append("\n").append(tabulateSiteMap(child, indent + 1)));

        return result.toString();

    }

}