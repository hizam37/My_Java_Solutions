package org.example;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.concurrent.ConcurrentSkipListSet;

import static java.lang.Thread.sleep;

public class HtmlParser {
    public static ConcurrentSkipListSet<String> getUrls(String url) {

        ConcurrentSkipListSet<String> urls = new ConcurrentSkipListSet<>();

        try {

            sleep(7000);
            Connection connection = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .timeout(1000)
                    .followRedirects(false);

            Document document = connection.get();

            Elements elements = document.select("body").select("a");

            for (Element perElement : elements) {

                String link = perElement.absUrl("href");

                if (isLink(link) && !isFile(link)) {

                    urls.add(link);

                }
            }

        } catch (InterruptedException | IOException e) {

            System.out.println(e + "  " + url);

        }

        return urls;

    }

    private static boolean isLink(String link) {

        return link.startsWith(Main.url);

    }

    private static boolean isFile(String link) {

      

        return link.contains(".pdf")
                || link.contains(".png")
                || link.contains(".gif")
                || link.contains(".eps")
                || link.contains(".webp")
                || link.contains(".doc")
                || link.contains(".pptx")
                || link.contains("?_ga")
                || link.contains(".xlsx")
                || link.contains(".docx")
                || link.contains(".jpg");
    }
}

